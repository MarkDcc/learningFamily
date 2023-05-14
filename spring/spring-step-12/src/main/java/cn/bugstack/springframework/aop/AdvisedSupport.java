package cn.bugstack.springframework.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:33
 */
public class AdvisedSupport {

	private boolean proxyTargetClass = false;

	public boolean isProxyTargetClass() {
		return proxyTargetClass;
	}

	public void setProxyTargetClass(boolean proxyTargetClass) {
		this.proxyTargetClass = proxyTargetClass;
	}

	private TargetSource targetSource;
	private MethodMatcher methodMatcher;

	// 方法拦截器
	private MethodInterceptor methodInterceptor;

	public TargetSource getTargetSource() {
		return targetSource;
	}

	public void setTargetSource(TargetSource targetSource) {
		this.targetSource = targetSource;
	}

	public MethodMatcher getMethodMatcher() {
		return methodMatcher;
	}

	public void setMethodMatcher(MethodMatcher methodMatcher) {
		this.methodMatcher = methodMatcher;
	}

	public MethodInterceptor getMethodInterceptor() {
		return methodInterceptor;
	}

	public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
		this.methodInterceptor = methodInterceptor;
	}
}
