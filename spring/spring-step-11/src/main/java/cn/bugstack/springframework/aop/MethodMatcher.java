package cn.bugstack.springframework.aop;

import java.lang.reflect.Method;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:24
 */
public interface MethodMatcher {

	boolean matches(Method method,Class<?> targetClass);
}
