package cn.hbmcynzx.base.task.controller;

import cn.hbmcynzx.base.mybatis.service.BaseService;
import cn.hbmcynzx.base.task.entity.TaskEntity;
import cn.hbmcynzx.base.task.service.TaskService;
import cn.hbmcynzx.base.task.utils.TaskUtils;
import cn.hbmcynzx.base.utils.ResultMsg;
import cn.hbmcynzx.base.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 定时任务控制层
 * @author hbmcynzx
 */
@RestController
@RequestMapping("task")
public class TaskController extends BaseController<TaskEntity> {

    @Autowired
    private TaskService taskService;
    @Override
    public BaseService<TaskEntity> getService() {
        return taskService;
    }

    /**
     * 开启定时任务
     * @param task
     * @return
     */
    @PostMapping("start")
    public ResultMsg start(@RequestBody TaskEntity task) {
        if (!StringUtils.isEmpty(task.getTaskId())) {
            //开启指定线程
            TaskUtils.getInstance().start(task.getTaskId());
        } else {
            //开启所有线程
            TaskUtils.getInstance().start();
        }
        return ResultMsg.success("操作成功");
    }

    /**
     * 停止定时任务
     * @param task
     * @return
     */
    @PostMapping("stop")
    public ResultMsg stop(@RequestBody TaskEntity task) {
        if (!StringUtils.isEmpty(task.getTaskId())) {
            //关闭指定线程
            TaskUtils.getInstance().stopTaskByKey(task.getTaskId());
        } else {
            //关闭所有线程
            TaskUtils.getInstance().stopTasks();
        }
        return ResultMsg.success("操作成功");
    }

    @PostMapping("insert")
    @Override
    public Object insert(@RequestBody TaskEntity taskEntity) {
        Object result = super.insert(taskEntity);
        TaskUtils.getInstance().reload();
        return result;
    }

    @PostMapping("update")
    @Override
    public Object update(@RequestBody TaskEntity taskEntity) {
        TaskEntity task = TaskUtils.getInstance().getTaskById(taskEntity.getTaskId());
        if(task != null && task.isStart()) {
            //任务处于开启状态，不能修改
            return ResultMsg.error("任务已开启，不能修改");
        }
        Object result = super.update(taskEntity);
        TaskUtils.getInstance().reload();
        return result;
    }

    @PostMapping("delete/{id}")
    @Override
    public Object deleteById(@PathVariable Serializable id) {
        TaskEntity task = TaskUtils.getInstance().getTaskById((String) id);
        if(task != null && task.isStart()) {
            //任务处于开启状态，不能修改
            return ResultMsg.error("任务已开启，不能删除");
        }
        Object result = super.deleteById(id);
        TaskUtils.getInstance().reload();
        return result;
    }

    @GetMapping("selectAllTasks")
    public Object selectAllTasks() {
        List<TaskEntity> tasks = TaskUtils.getInstance().getTasks();
        return ResultMsg.success("查询成功", tasks);
    }

    @GetMapping("selectReloadTasks")
    public Object selectReloadTasks() {
        List<TaskEntity> tasks = TaskUtils.getInstance().reload();
        return ResultMsg.success("查询成功", tasks);
    }

}
