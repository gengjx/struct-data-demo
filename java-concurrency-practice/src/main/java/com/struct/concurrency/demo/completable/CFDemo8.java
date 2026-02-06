package com.struct.concurrency.demo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CFDemo8 {

    static void main() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T1:烧开水...");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶...");
            System.out.println("T2:洗茶杯...");

            System.out.println("T2:拿茶叶...");
            return "龙井";
        });

      CompletableFuture<String> completableFuture =   future1.thenCombine(future2,(__,str)->{
            System.out.println("T1:拿到茶叶:" + str);
            System.out.println("T1:泡茶...");
            return "上茶:" + str;
        });

      completableFuture.get();
    }





}
