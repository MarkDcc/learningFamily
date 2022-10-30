package com.gordon.multithred.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author dongchen
 * @Data 2022/10/10
 * @Time 21:16
 */
public class CreateThread1 {
    public static void main(String[] args) throws InterruptedException {
        //方法一：使用Thread子类创建和启动线程
//        Thread create1 = new MyThread("ceate1");
//        create1.start();
//        System.out.println("Thread Name:"+create1.getName());

        //方法二：实现Runnable接口,使用匿名内部类。还可以使用lambda表达式创建
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("MyThread with Runnable.");
//            }
//        });
//        thread2.start();

        //方法三：创建可支持获取返回值的异步任务的线程
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        Thread thread = new Thread(futureTask, "returnableThread");
        thread.start();
        Thread.sleep(500);
        try {
            System.out.println(futureTask.get());
            System.out.println("执行结束");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("一些异步任务的执行");
            Thread.sleep(3000);
            return 100;
        }
    }

    static class MyThread extends Thread{

        public MyThread(String name){
            super(name);
        }


        @Override
        public void run() {
           // super.run();

            System.out.println("MyThread");
        }
    }
}
