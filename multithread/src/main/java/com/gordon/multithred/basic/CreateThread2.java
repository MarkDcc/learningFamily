package com.gordon.multithred.basic;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author dongchen
 * @Data 2022/10/10
 * @Time 22:47
 */
public class CreateThread2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(()->{
            try {
                Thread.sleep(1000);
                System.out.println("Runnable执行结束。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //lambda根据Future<Integer> future使用类型推断得出泛型为Integer.
        //所以当使用lambda简化函数式接口的时候，泛型定义在引用中
        Future<Long> future = executorService.submit(() -> {
            System.out.println("Callable执行结束");
            return 1L;
        });
        System.out.println("Callable执行结果"+future.get());

        executorService.submit(()->{
            System.out.println("submit执行Runnable");
        });
    }
}
