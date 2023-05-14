package cn.bugstack.springframework.aop.aspectj;

import cn.bugstack.springframework.aop.Pointcut;
import cn.bugstack.springframework.aop.PointcutAdvisor;
import cn.bugstack.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.aopalliance.aop.Advice;

/**
 * @Author:dongchen
 * @Date: 2023/5/14 17:18
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {
	private Advice advice;
	private AspectJExpressionPointcut pointcut;
	private String expression;

	public void setAdvice(Advice advice) {
		this.advice = advice;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	@Override
	public Advice getAdvice() {
		return advice;
	}

	@Override
	public Pointcut getPointcut() {
		if(null == pointcut){
			pointcut = new AspectJExpressionPointcut(expression);
		}
		return pointcut;
	}
}
