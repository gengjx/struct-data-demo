package com.struct.concurrency.demo.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CFDemo7 {

    static void main() throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {

            System.out.println("线程一开始");

            int sleep = new Random().nextInt(10);
            System.out.println("线程一睡眠："+sleep);
            try {
                TimeUnit.SECONDS.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程一结束");
            return  3;
        });


        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("线程二开始");

            int sleep = new Random().nextInt(10);
            System.out.println("线程二睡眠："+sleep);
            try {
                TimeUnit.SECONDS.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程二结束");
            return  2;
        });

        future1.applyToEither(future2,(number)->{
            System.out.println(number);
            return number+1;
        });

        future1.acceptEither(future2,(number)->{
            System.out.println(number);
        });

        System.out.println("最终结果："+future1.get());



    }


}
