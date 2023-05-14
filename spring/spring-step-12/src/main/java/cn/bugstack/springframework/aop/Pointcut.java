package cn.bugstack.springframework.aop;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 11:25
 */
public interface Pointcut {
	/**
	 * Return the ClassFilter for this pointcut.
	 *
	 * @return the ClassFilter (never <code>null</code>)
	 */
	ClassFilter getClassFilter();

	/**
	 * Return the MethodMatcher for this pointcut.
	 *
	 * @return the MethodMatcher (never <code>null</code>)
	 */
	MethodMatcher getMethodMatcher();
}
