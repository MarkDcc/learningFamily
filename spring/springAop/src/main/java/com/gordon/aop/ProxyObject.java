package com.gordon.aop;

import com.gordon.service.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:24
 */
public class ProxyObject {

	public static Object getObject(Service target,Aop aop){
		return Proxy.newProxyInstance(target.getClass().getClassLoader()
				, target.getClass().getInterfaces()
				, new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

						aop.before();
						Object result = method.invoke(target, args);
						aop.after();
						System.out.println("result = " + result);
						return result;
					}
				}
		);
	}
}
