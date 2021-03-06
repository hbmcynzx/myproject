package cn.hbmcynzx.task;

import cn.hbmcynzx.base.task.entity.DynamicTask;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestCronTask extends DynamicTask {
    @Override
    public Runnable setTask() {
        return () -> {
            DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(LocalDateTime.now().format(pattern));
        };
    }
}
