package com.gordon.multithred.basic.chapter1;

/**
 * @author dongchen
 * @Data 2022/10/15
 * @Time 14:56
 */
public class RasieThread {
	public static void main(String[] args) {
		MyThread thread1 = new MyThread("thread1");
		Thread thread = new Thread(thread1);
		System.out.println("Thread start.");
		thread.start();

	}

	static class MyThread extends Thread{
		public MyThread(String name) {
			super(name);
		}

		@Override
		public void run() {
			System.out.println("My first thread.");
		}
	}
}
