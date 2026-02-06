package com.struct.concurrency.demo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFDemo5 {


    static void main() throws ExecutionException, InterruptedException {

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            return  1;
        }).thenAccept(number ->{
            System.out.println(number * 5);
        });

        System.out.println(future.get());


        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            return  2;
        });

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            return  3;
        });


        future1.thenAcceptBoth(future2, (a,b)->{
            System.out.println(a + b);
        });


        future1.thenRun(
                ()->{
                    System.out.println(Thread.currentThread().getName());
                }
        );

        System.out.println(future1.get());
    }
}
