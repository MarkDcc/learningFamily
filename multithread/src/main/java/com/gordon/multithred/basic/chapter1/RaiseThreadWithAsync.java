package com.gordon.multithred.basic.chapter1;

import java.util.concurrent.*;

/**
 * @author dongchen
 * @Data 2022/10/15
 * @Time 15:45
 */
public class RaiseThreadWithAsync {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		Callable<Long> myCallable = new MyCallable();
		FutureTask<Long> futureTask = new FutureTask<Long>(myCallable);
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println("主线程做自己的事情.");
		thread.join();//等待线程执行结束
		System.out.println("线程执行完成,结果是："+futureTask.get(1, TimeUnit.SECONDS));


	}

	static class MyCallable implements Callable<Long> {
		@Override
		public Long call() throws Exception {
			System.out.println("异步任务执行");
			Thread.sleep(3000);
			return 1L;
		}
	}
}
