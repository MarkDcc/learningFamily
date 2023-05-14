package cn.bugstack.springframework.test;

import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.CustomerEvent;
import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 单元测试
 * @date 2022/03/10
 *
 *
 */
public class ApiTest {

    @Test
    public void test(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomerEvent(applicationContext,"1001","First message"));
        applicationContext.close();
    }
}
