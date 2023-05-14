package org.gordon.bean;

import org.gordon.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:dongchen
 * @Date: 2023/5/12 21:31
 */
public class ProxyFactoryBean implements FactoryBean<UseDao> {
	@Override
	public UseDao getObject() {
		InvocationHandler invocationHandler = (Object proxy, Method method, Object[] args)->{
			// 添加排除方法
			if ("toString".equals(method.getName())) return this.toString();

			Map<String, String> hashMap = new HashMap<>();
			hashMap.put("10001", "小傅哥");
			hashMap.put("10002", "八杯水");
			hashMap.put("10003", "阿毛");

			return "被代理的方法 "+ method.getName()+ "方法返回结果为："+ hashMap.get(args[0].toString());
		};
		return (UseDao)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),new Class[]{UseDao.class},
				invocationHandler);
	}

	@Override
	public Class<?> getObjectType() {
		return UseDao.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
