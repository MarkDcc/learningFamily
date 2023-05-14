package cn.bugstack.springframework.aop;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:22
 */
public interface ClassFilter {
	boolean matches(Class<?> clazz);
}
