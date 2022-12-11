package com.gordon.config;

import com.gordon.bean.Tom;
import com.gordon.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_SINGLETON;

/**
 * @Author:dongchen
 * @Date: 2022/11/30 21:40
 */
@Configuration(proxyBeanMethods = false)
public class MyConfig {

	@Bean
	@Scope(value = SCOPE_SINGLETON)
	public User user01(){
		return new User("zhangsan","15");
	}



	@Bean
	public Tom tom(){
		return new Tom();
	}

	public Tom tom02(){
		return new Tom(new User("ll"+new Date(),"18"), "22");
	}
}
