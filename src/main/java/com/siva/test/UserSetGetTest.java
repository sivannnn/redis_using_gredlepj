package com.siva.test;

import com.siva.redis.dao.RedisStrDao;
import com.siva.redis.entity.RedisResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试方法.
 * 
 * @author siva
 * @version v1.0
 */
public class UserSetGetTest {
    /**
     * 注入方法.
     */
    private static ApplicationContext ac;

    /**
     * 
     * @param args 系统参数.
     */
    public static void main(final String[] args) {
        String appContextPath = "classpath:/spring/spring-redis.xml";
        ac = new ClassPathXmlApplicationContext(appContextPath);
        
        RedisStrDao redisStrDao = (RedisStrDao) ac.getBean("redisStrDao");
        RedisResponse result= redisStrDao.getValueByKey("name");
        if(1 == result.getFlag()){
            System.out.println((String)result.getData());
        }
        
    }
}
