package cn.hbmcynzx.base.task.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cn.hbmcynzx.base.task.mapper"})
public class TaskMapperConfig {
}
