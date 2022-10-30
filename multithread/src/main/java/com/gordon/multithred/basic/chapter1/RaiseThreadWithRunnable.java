package com.gordon.multithred.basic.chapter1;

/**
 * @author dongchen
 * @Data 2022/10/15
 * @Time 15:02
 */
public class RaiseThreadWithRunnable {
	public static void main(String[] args) {
		Runnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "ThreadWithRunnable");
		thread.start();
		/**
		 * 两种Runnable创建的优雅方式
		 * 1.Lambda
		 * 2.匿名内部类
		 */
		new Thread(()->{
			System.out.println("Lambda 创建 Runnable.");
		},"ThreadWithLambda").start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("匿名内部类创建Thread");
			}
		},"ThreadWithAnonymous").start();
	}

	static class MyRunnable implements Runnable{

		@Override
		public void run() {
			System.out.println("Thread with Runnable.");
		}
	}
}
