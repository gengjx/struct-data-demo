package com.struct.concurrency.demo.completable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    static void main() throws ExecutionException, InterruptedException {

        FutureTask<String> task1 = new FutureTask<>(()->{
            System.out.println("T1:查询商品信息中");
            return "商品信息查询完成";
        });

        FutureTask<String> task2 = new FutureTask<>(()->{
            System.out.println("T2:查询商品价格中");
            return "查询商品价格完成";
        });

        FutureTask<String> task3 = new FutureTask<>(()->{
            System.out.println("T3:商品库存查询中");
            return "商品库存查询完成";
        });


        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(task1);
        executor.submit(task2);
        executor.submit(task3);

        System.out.println(task1.get());
        System.out.println(task2.get());
        System.out.println(task3.get());
        executor.shutdown();

        System.out.println("main end");
    }


}
