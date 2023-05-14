package cn.bugstack.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 17:15
 */
public interface Advisor {
	Advice getAdvice();
}
