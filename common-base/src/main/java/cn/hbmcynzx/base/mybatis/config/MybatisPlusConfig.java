package cn.hbmcynzx.base.mybatis.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus配置Bean
 * @author hbmcynzx
 */
@Configuration
public class MybatisPlusConfig {

    /**
     * 获取数据库类型
     */
    @Value("${mybatis-plus.database.dbType}")
    private String dbType;

    /**
     * 拦截器配置
     * @return MybatisPlusInterceptor
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //添加分页拦截器
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.getDbType(dbType)));
        return mybatisPlusInterceptor;
    }


}
