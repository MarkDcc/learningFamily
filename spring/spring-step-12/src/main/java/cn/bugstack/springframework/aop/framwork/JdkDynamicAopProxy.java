package cn.bugstack.springframework.aop.framwork;

import cn.bugstack.springframework.aop.AdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.PrivateKey;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 12:02
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

	private final AdvisedSupport advisedSupport;

	public JdkDynamicAopProxy(AdvisedSupport advisedSupport) {
		this.advisedSupport = advisedSupport;
	}

	@Override
	public Object getProxy() {
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
				advisedSupport.getTargetSource().getTargetClass(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		ReflectiveMethodInvocation reflectiveMethodInvocation =
				new ReflectiveMethodInvocation(advisedSupport.getTargetSource().getTarget(), method, args);
		if(advisedSupport.getMethodMatcher().matches(method,advisedSupport.getTargetSource().getTarget().getClass())){
			return advisedSupport.getMethodInterceptor().invoke(reflectiveMethodInvocation);
		}
		return reflectiveMethodInvocation.proceed();
	}
}
