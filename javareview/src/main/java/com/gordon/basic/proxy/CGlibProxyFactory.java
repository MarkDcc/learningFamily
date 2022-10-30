package com.gordon.basic.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dongchen
 * @Data 2022/10/25
 * @Time 22:23
 */
public class CGlibProxyFactory {
	private Object target;

	public CGlibProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyObject(){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(new MyMethodInterceptor());
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}

	class MyMethodInterceptor implements MethodInterceptor{

		public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
			System.out.println("CGlib before method invoke,method name: "+method.getName());
			proxy.invoke(target,args);
//			proxy.invokeSuper()

			System.out.println("CGlib after method invoke,method name: "+method.getName());
			return null;
		}
	}
}
