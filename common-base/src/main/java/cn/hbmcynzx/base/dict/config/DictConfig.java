package cn.hbmcynzx.base.dict.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"cn.hbmcynzx.base.dict.mapper"})
public class DictConfig {
}
