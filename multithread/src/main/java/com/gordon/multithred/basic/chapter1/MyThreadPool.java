package com.gordon.multithred.basic.chapter1;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.security.PrivateKey;
import java.sql.Time;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author dongchen
 * @Data 2022/10/15
 * @Time 21:00
 */
public class MyThreadPool {


	@Test
	public void testThreadPoolHooks() throws InterruptedException {
		ThreadLocal<Long> local = new ThreadLocal<>();
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(10)){
			@Override
			protected void terminated() {
				System.out.println("ThreadPool已经停止。");
			}
			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				Long endTime = System.currentTimeMillis() - local.get();
				System.out.println("afterExecute任务执行花费了："+endTime+"毫秒");
			}
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				super.beforeExecute(t, r);
				local.set(System.currentTimeMillis());
				System.out.println("beforeExecute开始执行.");
			}
		};
		threadPoolExecutor.submit(()->{
			System.out.println("任务开始执行.");
			LockSupport.parkNanos(2000000000);
		});
		Thread.sleep(3000);
		threadPoolExecutor.shutdownNow();
	}

	@Test
	public void testMyThreadPool() throws InterruptedException {
		AtomicInteger initNum = new AtomicInteger();
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 3, 5, TimeUnit.SECONDS,
				new LinkedBlockingQueue<>(2),
				new SelfThreadFactory(),
				new SelfRejectedExecutionHandler()) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("beforeExecute被执行.");
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("afterExecute被执行.");
				//System.out.println(r.);
			}

			@Override
			protected void terminated() {
				System.out.println("terminated被执行.");
			}
		};

		poolExecutor.prestartAllCoreThreads();
		for (int i = 0; i < 10; i++) {
			poolExecutor.execute(()->{
				int taskId = initNum.incrementAndGet();
				System.out.println("当前task顺序："+taskId+"-任务开始执行.");
//				try {
//					Thread.sleep(1000);
//					System.out.println("任务"+taskId+"执行完毕.");
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
				while (true){}
			});
		}

		Thread.sleep(10000);
		System.out.println("开始关闭线程池");
		System.out.println("此时队列中等待的任务为："+poolExecutor.getTaskCount());
		if (!poolExecutor.awaitTermination(3, TimeUnit.SECONDS)) {
			poolExecutor.shutdownNow();
		}

	}

	private class SelfThreadFactory implements ThreadFactory{

		private AtomicInteger threadNum = new AtomicInteger();
		@Override
		public Thread newThread(Runnable r) {
			String threadName = "pool-"+threadNum+"-num";
			threadNum.incrementAndGet();
			System.out.println("开始创建线程："+threadName);
			return new Thread(r,threadName);
		}
	}

	private class SelfRejectedExecutionHandler implements RejectedExecutionHandler{

		@Override
		public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
			System.out.println("线程池无法处理"+r+"任务。直接抛弃.总共taskCount:"+executor.getTaskCount());
		}
	}
}
