package cn.hbmcynzx.base.dict.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 数据字典配置Bean
 * mybatis mapper扫描
 * @author hbmcynzx
 */
@Configuration
@MapperScan({"cn.hbmcynzx.base.dict.mapper"})
public class DictMapperConfig {
}
