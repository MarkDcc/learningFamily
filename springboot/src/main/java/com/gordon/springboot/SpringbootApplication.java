package com.gordon.springboot;

import com.gordon.springboot.mybatis.mapper.UserMapper;
import com.gordon.springboot.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {
    @Resource
    UserMapper userMapper;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        User userById = userMapper.getUserById(1);
        System.out.println(userById);
    }
}
