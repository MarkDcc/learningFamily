package com.gordon.springboot.aop;

import java.util.ArrayList;

/**
 * @author dongchen
 * @Data 2022/9/5
 * @Time 18:26
 */
public class AopMain {
    public static void main(String[] args) {
        testProxy();
    }

    private static void testProxy() {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService, new MyInterceptor());
        proxy.sayHello("zhangsan");
        ArrayList<Object> list = new ArrayList<>(100000);
//        System.out.println("\n###############name is null!!#############\n");
//        proxy.sayHello(null);
    }
}
