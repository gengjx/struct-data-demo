package com.struct.concurrency.demo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo {

    public static void run() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
            sleep(100);
            return 20;
        });

        CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
            sleep(150);
            return 22;
        });

        CompletableFuture<Integer> result = f1.thenCombine(f2, Integer::sum);
        System.out.println("result=" + result.get());
    }

    private static void sleep(long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
