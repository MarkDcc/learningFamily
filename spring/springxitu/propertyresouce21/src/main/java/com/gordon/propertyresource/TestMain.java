package com.gordon.propertyresource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author:dongcc
 * @Date: 2023/10/19 20:44
 */
public class TestMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JdbcPropertiesConfiguration.class);
        JdbcProperties jdbcProperties = context.getBean(JdbcProperties.class);
        System.out.println("jdbcProperties.toString() = " + jdbcProperties.toString());

    }
}
