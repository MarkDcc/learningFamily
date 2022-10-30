package com.gordon.multithred.basic.chapter2.waitNotify;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 15:08
 */
public class DataBuffer<T> {
	private static final int MAX_AMOUNT = 10;

	private LinkedList<T> store = new LinkedList<>();
	private static Object notFull = new Object();
	private static Object notEmpty = new Object();
	private static Object lock = new Object();

	private AtomicInteger amount = new AtomicInteger(0);

	public void add(T element) throws Exception {

		synchronized (notFull){
			while (amount.get() > MAX_AMOUNT) {
				System.out.println("队列已满");
				Thread.sleep(200);
				notFull.wait();
			}
		}
		synchronized (lock) {
//		System.out.println("添加队列");
			store.add(element);
			amount.incrementAndGet();
			if (amount.get() != store.size()) {
				System.out.println("YYY");
				throw new Exception(amount + "!=" + store.size());
			}
		}
		synchronized (notEmpty){
			notEmpty.notify();
		}

	}


	public T fetch() throws Exception {
		synchronized (notEmpty){
			while (amount.get() <= 0) {
				System.out.println("队列已空");
				notEmpty.wait();
			}
		}
		//Thread.sleep(1000);
		T e = null;
		synchronized (lock) {
			e = store.remove();
			amount.decrementAndGet();
			if (amount.get() != store.size()) {
				throw new Exception(amount + "!=" + store.size());
			}
//		System.out.println("取队列");

		}

		synchronized (notFull){
			notFull.notify();
		}
		return e;

	}
}
