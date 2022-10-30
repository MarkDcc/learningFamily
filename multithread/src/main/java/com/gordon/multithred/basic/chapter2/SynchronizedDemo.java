package com.gordon.multithred.basic.chapter2;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 11:56
 */
public class SynchronizedDemo {

	private static Integer num = 0;
	private Object syncLock = new Object();

	@Test
	public void testSynchronized101() throws InterruptedException {

		CountDownLatch countDownLatch = new CountDownLatch(1000);
		for (int i = 0; i < 1000; i++) {
			new Thread(()->{
				//num++;
				synchronized (syncLock){
					num++;
				}
				countDownLatch.countDown();
			}).start();
		}
		countDownLatch.await();
		System.out.println("结果是："+num);
	}
}
