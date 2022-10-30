package com.gordon.multithred.basic.chapter1;

import java.net.SocketTimeoutException;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dongchen
 * @Data 2022/10/15
 * @Time 16:31
 */
public class RaiseThreadWithInterrupt {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(() -> {
			System.out.println("线程开始执行。");
			try {
				System.out.println("线程进入sleep.");
				System.out.println("线程的Interrupt异常前状态："+Thread.currentThread().isInterrupted());
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("当前线程被打断了.");
				System.out.println("线程的Interrupt异常后状态："+Thread.currentThread().isInterrupted());
				e.printStackTrace();
				return;
			}
			System.out.println("线程执行完毕");

		}, "InterruptThread");
		thread.start();
		Thread.sleep(500);
		System.out.println("调用Interrupt打断线程.");
		thread.interrupt();

//		Thread runningTask = new Thread(() -> {
//			while (true) {
//				System.out.println("线程开始执行.");
//				System.out.println("线程进入park.");
//				System.out.println("线程interrupt之前的状态："+Thread.currentThread().isInterrupted());
//				LockSupport.parkNanos(10000000);
//				System.out.println("线程interrupt之后的状态："+Thread.currentThread().isInterrupted());
//				if (Thread.currentThread().isInterrupted()) {
//					System.out.println("线程被打断了.结束线程.");
//					System.out.println("线程interrupt状态："+Thread.currentThread().isInterrupted());
//					return;
//				}
//			}
//
//		}, "ThreadWithRunningTask");
//		runningTask.start();
//		LockSupport.parkNanos(1000);
//		runningTask.interrupt();
	}
}
