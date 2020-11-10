package cn.hbmcynzx.task;

import cn.hbmcynzx.base.task.entity.DynamicTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestPeriodTask extends DynamicTask {
    @Override
    public Runnable setTask() {
        return () -> {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println("PERIOD定时器测试：" + LocalDateTime.now().format(pattern));
        };
    }
}
