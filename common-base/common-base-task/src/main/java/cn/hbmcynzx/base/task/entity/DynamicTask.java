package cn.hbmcynzx.base.task.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.PeriodicTrigger;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * spring定时任务抽象类 使用该类做定时任务，实现类要添加@Component注解交给spring管理 并实现setTask()指定定时任务
 * 	若不实现后台管理，可指定@PostConstruct方法，调用setCron()方法设置任务执行时间
 * 	若实现后台管理，不用指定@PostConstruct方法，需在taskconfig.xml配置文件添加描述
 *
 */
public abstract class DynamicTask {
    @Autowired
    private TaskScheduler taskScheduler;

    private ScheduledFuture<?> future;
    private boolean start = false;

    public abstract Runnable setTask();

    public void setCron(String cron) {
        stopTask();
        future = taskScheduler.schedule(setTask(), triggerContext -> {
            CronTrigger trigger = new CronTrigger(cron);
            return trigger.nextExecutionTime(triggerContext);
        });
        start = true;
    }

    public void setFixedDelay(long period, TimeUnit timeUnit) {
        stopTask();
        future = taskScheduler.schedule(setTask(), triggerContext -> {
            PeriodicTrigger trigger = new PeriodicTrigger(period, timeUnit);
            return trigger.nextExecutionTime(triggerContext);
        });
        start = true;
    }

    public void stopTask() {
        if (future != null) {
            future.cancel(true);// 取消任务调度
        }
        start = false;
    }

    public void setTaskScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }
}
