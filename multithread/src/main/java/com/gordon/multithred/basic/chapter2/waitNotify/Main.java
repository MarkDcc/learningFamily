package com.gordon.multithred.basic.chapter2.waitNotify;

import java.util.concurrent.*;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 16:35
 */
public class Main {
	private static DataBuffer<IGoods> dataBuffer = new DataBuffer<>();
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		Callable produce = ()->{
				IGoods goods = 	 IGoods.produceOne();
				dataBuffer.add(goods);
				return goods;

			};

		Callable consumer = ()->{
				IGoods goods = dataBuffer.fetch();
				return goods;
		};

//		for (int i = 0; i < 5; i++) {
			executorService.submit(new Producer(produce,500));
			//submit.get();
			//Thread.sleep(1000);
			executorService.submit(new Consumer(consumer,1000));
//		}
	}
}
