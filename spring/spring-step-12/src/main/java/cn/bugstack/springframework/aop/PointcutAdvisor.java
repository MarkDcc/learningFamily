package cn.bugstack.springframework.aop;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 17:18
 */
public interface PointcutAdvisor extends Advisor{

	Pointcut getPointcut();
}
