package com.gordon.aop;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:27
 */
public class LogAop implements Aop{
	@Override
	public void before() {
		System.out.println("LogAop before.....");
	}
}
