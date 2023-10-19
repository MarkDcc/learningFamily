package cn.bugstack.springframework.test;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.config.BeanPostProcessor;
import cn.bugstack.springframework.context.support.ClassPathXmlApplicationContext;
import cn.bugstack.springframework.test.bean.IUserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 * 作者：DerekYRC https://github.com/DerekYRC/mini-spring
 * @description 单元测试
 * @date 2022/3/14
 *
 *
 */
public class ApiTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}