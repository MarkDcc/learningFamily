package com.gordon.aop;

/**
 * @Author:dongchen
 * @Date: 2022/11/19 18:27
 */
public class TractionalAop implements Aop{
	@Override
	public void after() {
		System.out.println("TractionalAop after....");
	}
}
