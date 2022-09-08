package com.gordon.springboot.aop;

import org.springframework.stereotype.Service;

/**
 * @author dongchen
 * @Data 2022/9/5
 * @Time 18:24
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello(String name) {
        if (name == null || name.trim() == "") {
            throw new RuntimeException ("parameter is null!!");
        }
        System.out.println("hello " + name);
    }

}
