package com.gordon.multithred.basic.chapter2.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongchen
 * @Data 2022/10/17
 * @Time 16:01
 */
public class Main {

	private static AtomicInteger num = new AtomicInteger(0);
	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {

//			new Thread(()->{
//				System.out.println(Thread.currentThread().getName()+ new Item(num.getAndIncrement()).toString());
//			},i+"").start();
		}
	}
}
