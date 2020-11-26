package cn.hbmcynzx.base.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext context;
    private static Environment environment;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
        environment = applicationContext.getEnvironment();
    }

    public static ApplicationContext getContext(){
        return context;
    }

    public static Environment getEnvironment(){
        return environment;
    }

    public static String getProperty(String key){
        if(environment != null) {
            return environment.getProperty(key);
        }
        return null;
    }

    public static String getProperty(String key, String defaultValue){
        if(environment != null) {
            return environment.getProperty(key, defaultValue);
        }
        return null;
    }
}
