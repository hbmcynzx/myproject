package cn.hbmcynzx.base.task.utils;

import cn.hbmcynzx.base.task.entity.DynamicTask;
import cn.hbmcynzx.base.task.entity.TaskEntity;
import cn.hbmcynzx.base.task.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TaskUtils {
    private static volatile TaskUtils instance;
    private List<TaskEntity> taskList = new ArrayList<>();
    private Map<String, DynamicTask> taskMap = new HashMap<>();
    private TaskService taskService;
    private ApplicationContext applicationContext;

    private TaskUtils() {}

    public static TaskUtils getInstance() {
        if(instance == null) {
            synchronized (TaskUtils.class) {
                if(instance == null) {
                    instance = new TaskUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 获取定时任务列表
     * @return
     */
    public List<TaskEntity> getTasks() {
        if(taskList != null && taskList.isEmpty()) {
            return reload();
        }
        return taskList;
    }

    public TaskEntity getTaskById(String id) {
        if(taskList != null && !taskList.isEmpty()) {
            for (TaskEntity task : taskList) {
                if (task.getTaskId().equals(id)) {
                    return task;
                }
            }
        }
        return null;
    }

    /**
     * 开启全部任务
     */
    public void start() {
        List<TaskEntity> tasks = getTasks();
        if(tasks != null && !tasks.isEmpty()) {
            tasks.forEach(task -> {
                if (!task.isStart()) {
                    startTask(task);
                }
            });

        }
    }

    /**
     * 开启指定任务
     */
    public void start(String key) {
        List<TaskEntity> tasks = getTasks();
        if(tasks != null && !tasks.isEmpty()) {
            for (TaskEntity task : tasks) {
                if (task.getTaskId().equalsIgnoreCase(key)) {
                    startTask(task);
                    return;
                }
            }
        }
    }

    /**
     * 初始化定时任务
     * @return
     */
    public List<TaskEntity> initStart(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        List<TaskEntity> tasks = getTasks();
        if(tasks != null && !tasks.isEmpty()) {
            tasks.forEach(task -> {
                //任务自启动
                if (task.getAutoStart()) {
                    startTask(task);
                }
            });
            this.taskList = tasks;
        }
        return this.taskList;
    }

    /**
     * 开启任务
     * @param task
     * @return 是否开启
     */
    private void startTask(TaskEntity task) {
        try {
            if (!task.isStart()) {
                DynamicTask dynamicTask = taskMap.get(task.getTaskId());
                if(dynamicTask == null) {
                    //从spring中获取
                    dynamicTask = getTaskFromSpringContext(task);
                    if(dynamicTask == null) {
                        //spring中没有，从类加载器获取
                        dynamicTask = getTaskFromClassLoader(task);
                    }
                    if(dynamicTask == null) {
                        return;
                    }
                    taskMap.put(task.getTaskId(), dynamicTask);
                }
                if("CRON".equals(task.getTaskType())) {
                    //cron
                    dynamicTask.setCron(task.getCron());
                } else {
                    //定时
                    dynamicTask.setFixedDelay(task.getPeriod(), TimeUnit.valueOf(task.getTimeUnit()));
                }
                task.setStart(true);
            }
        }catch (Exception e) {
            log.error("启动任务异常", e);
        }
    }

    /**
     * 重新加载定时任务列表
     * @return
     */
    public List<TaskEntity> reload() {
        List<TaskEntity> taskList = getTaskService().selectList(null);
        if(taskList != null && !taskList.isEmpty() && !taskMap.isEmpty()) {
            taskList.forEach(task -> {
                String taskId = task.getTaskId();
                DynamicTask dynamicTask = taskMap.get(taskId);
                if(dynamicTask != null) {
                    task.setStart(dynamicTask.isStart());
                }
            });
        }
        this.taskList = taskList;
        return this.taskList;
    }

    public void stopTasks() {
        if(taskMap != null) {
            for (Map.Entry<String, DynamicTask> taskEntry : taskMap.entrySet()) {
                taskEntry.getValue().stopTask();
            }
        }
        if (taskList != null && !taskList.isEmpty()) {
            taskList.forEach(task -> task.setStart(false));
        }
    }

    /**
     * description:  停止指定任务
     */
    public void stopTaskByKey(String key) {
        DynamicTask dynamicTask = taskMap.get(key);
        if (null != dynamicTask) {
            dynamicTask.stopTask();
            for (TaskEntity task : taskList) {
                if (task.getTaskId().equals(key)) {
                    task.setStart(false);
                }
            }
        }
    }

    private DynamicTask getTaskFromSpringContext(TaskEntity task){
        Map<String, DynamicTask> tasks = applicationContext.getBeansOfType(DynamicTask.class);
        for(Map.Entry<String, DynamicTask> entry : tasks.entrySet()) {
            DynamicTask value = entry.getValue();
            if(task.getClassName().equals(value.getClass().getName())) {
                return value;
            }
        }
        return null;
    }

    private DynamicTask getTaskFromClassLoader(TaskEntity task) {
        try {
            String className = task.getClassName();
            Class<?> forName = Class.forName(className);
            DynamicTask dynamicTask = (DynamicTask) forName.newInstance();
            TaskScheduler taskScheduler = applicationContext.getBean("taskScheduler", TaskScheduler.class);
            dynamicTask.setTaskScheduler(taskScheduler);
            return dynamicTask;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private TaskService getTaskService() {
        if(taskService == null) {
            taskService = applicationContext.getBean(TaskService.class);
        }
        return taskService;
    }
}
