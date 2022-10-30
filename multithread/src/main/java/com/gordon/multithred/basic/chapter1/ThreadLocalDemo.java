package com.gordon.multithred.basic.chapter1;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 9:50
 */
public class ThreadLocalDemo {

	@Test
	public void testThreadLocalUse() throws ExecutionException, InterruptedException {

		ThreadLocal<Long> threadLocal = new ThreadLocal<>();
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 5; i++) {
			executorService.submit(() -> {
				if (threadLocal.get() == null) {
					threadLocal.set(0L);
				}

				for (int j = 0; j < 10; j++) {
					Long value = threadLocal.get();
					value++;
					threadLocal.set(value);
				}
				System.out.println(Thread.currentThread().getName() + "执行结束，local值为：" + threadLocal.get());
			});
		}


		Thread.sleep(500);

	}

	@Test
	public void testThreadLocalWithInitialValue() {
		ThreadLocal<Long> withInitial = ThreadLocal.withInitial(() -> {
			return 10L;
		});

		new Thread(() -> {
			System.out.println(withInitial.get());
		}).start();
	}

	@Test
	public void testThreadLocalWeakRefrence() throws InterruptedException {
		ThreadLocal<Object> threadLocal = new ThreadLocal<>();
		new Thread(() -> {
			while (true) {
				threadLocal.set(new byte[1024*1024]);
				System.out.println("线程在执行");
			}
		}).start();
		Thread.sleep(500);//500ms内线程执行了多次，当main退出的。线程退出
	}
}
