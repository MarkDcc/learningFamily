package com.gordon.multithred.basic.chapter2.waitNotify;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dongchen
 * @Data 2022/10/16
 * @Time 17:12
 */
public class Producer implements Runnable {
	private Callable action = null;
	private int gap = 500;

	private AtomicInteger trun = new AtomicInteger(0);

	public Producer(Callable action,int gap){
		this.action = action;
		this.gap = gap;
	}
	@Override
	public void run() {
		while (true){
			Object call = null;
			try {
				call = action.call();
				if(null != call){
					System.out.println("第"+trun.get()+"轮生产："+call);
				}

				Thread.sleep(gap);
				trun.incrementAndGet();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
