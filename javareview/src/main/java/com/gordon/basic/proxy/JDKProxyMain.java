package com.gordon.basic.proxy;

import java.lang.reflect.Proxy;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:21
 */
public class JDKProxyMain {
	public static void main(String[] args) {
		/**
		 * jdk反向代理
		 *
		 */

		SmsService smsService = new SmsServiceImpl();
		ProxyObjectInvocationHandler proxyObjectInvocationHandler = new ProxyObjectInvocationHandler(smsService);
		SmsService proxyInstance = (SmsService) Proxy.newProxyInstance(smsService.getClass().getClassLoader(),
				smsService.getClass().getInterfaces(), proxyObjectInvocationHandler);
		proxyInstance.send("zhangsan");

		System.out.println("_________________________");
		proxyInstance.receive();
	}
}
