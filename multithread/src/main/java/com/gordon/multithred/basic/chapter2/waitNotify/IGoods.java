package com.gordon.multithred.basic.chapter2.waitNotify;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 15:05
 */
public class IGoods {
  //private static  AtomicInteger index = new AtomicInteger(0);

	public static IGoods produceOne() throws InterruptedException {
		//index.incrementAndGet();
		//Thread.sleep(500);
		return new IGoods();
	}

	@Override
	public String toString() {
		return "IGoods{}";
	}
}
