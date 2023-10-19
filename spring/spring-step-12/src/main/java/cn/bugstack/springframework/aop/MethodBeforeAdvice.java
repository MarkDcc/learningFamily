package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 20:37
 */
public interface MethodBeforeAdvice extends BeforeAdvice{
	void before(Method method, Object[] args, Object target) throws Throwable;
}
