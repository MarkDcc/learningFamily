package com.gordon.propertyresource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author:dongcc
 * @Date: 2023/10/19 20:44
 */
@Configuration
@ComponentScan(basePackages = {"com.gordon.propertyresource"})
@PropertySource("classpath:propertysource/jdbc.properties")
public class JdbcPropertiesConfiguration {
}
