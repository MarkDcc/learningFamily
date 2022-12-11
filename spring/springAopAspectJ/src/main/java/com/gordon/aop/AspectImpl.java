package com.gordon.aop;

import com.gordon.pojo.User;
import org.aspectj.apache.bcel.generic.ObjectType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 19:51
 */
@Aspect
public class AspectImpl {

	@Pointcut("execution( * com.gordon.service..*.*(..))")
	public void myPoint() {
	}

	;

	/**
	 * 环绕通知方法的规范
	 *  方法为public
	 *  没有返回值
	 *  只能传入JoinPoint
	 *
	 * @param joinPoint
	 */
	//@Before(value = "myPoint()")
	public void before(JoinPoint joinPoint) {

		System.out.println("前置通知..." + joinPoint.getSignature().getName());
		System.out.println("joinPoint.getSignature() = " + joinPoint.getSignature());
	}

	/**
	 * 后置通知方法的规范
	 * 方法为public
	 * 没有返回值
	 * 切面方法可以没有参数,如果有参数则是目标方法的返回值,也可以包含参数JoinPoint,它必须是第一个参数
	 * returning可以获取方法返回值,参数名必须和切面方法参数名一致
	 * <p>
	 * 切面通知中不能改变方法的返回值，除非返回值是引用类型
	 *
	 * @param joinPoint
	 * @param obj
	 */
	//@AfterReturning(value = "myPoint()", returning = "obj")
	public void afterReturning(JoinPoint joinPoint, Object obj) {
		System.out.println("后置通知...");

		System.out.println("切面通知中未改变之前obj" + obj);
		if (obj instanceof Integer) {
			Integer objI = (Integer) obj;
			objI++;
			System.out.println("切面通知中改变之后obj" + objI);
		}

		if (obj instanceof User) {
			((User) obj).setName("zhangsan");
		}
	}

	/**
	 *环绕通知方法的规范
	 *      * 1)访问权限是public
	 *      * 2)切面方法有返回值,此返回值就是目标方法的返回值.
	 *      * 3)切面方法的名称自定义
	 *      * 4)切面方法有参数,参数就是目标方法.它是ProceedingJoinPoint的类型
	 *      * 5)必须要抛出异常Throwable
	 *      * 6)使用@Around注解
	 *      * 7)参数:value:指定切入点表达式
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	//@Around(value = "myPoint()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("环绕前置通知.");

		Object result = pjp.proceed();//真正方法的执行

		System.out.println("环绕后置通知.");


		return (((Integer)result)+10);
	}

	/**
	 * 异常通知的规范
	 *  方法没有返回值，
	 *  throwing可以定义方法的异常类型，只有匹配的类型才会触发通知。
	 *  或者定义为Throwable则所有的异常都会触发
	 * @param joinPoint
	 * @param ex
	 */
	//@AfterThrowing(value = "myPoint()",throwing = "ex")
	public void afterThrowing(JoinPoint joinPoint,NullPointerException ex){
		System.out.println("异常通知...");
		//System.out.println(ex.toString());
	}

	/**
	 * 最终通知的规范
	 *  方法没有返回值，
	 *  就像finally一样一定会执行
	 * @param joinPoint
	 */
	@After(value = "myPoint()")
	public void after(JoinPoint joinPoint){
		System.out.println("最终通知...");
	}


}
