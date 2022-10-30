package com.gordon.basic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:05
 */
public class ProxyObjectInvocationHandler implements InvocationHandler {

	private Object target;

	public ProxyObjectInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equalsIgnoreCase("send")) {
			System.out.println("Proxy  method before send.");
			method.invoke(target,args);
			System.out.println("Proxy  method after send.");
		}else {
			method.invoke(target,args);
		}

		return "success";
	}
}
