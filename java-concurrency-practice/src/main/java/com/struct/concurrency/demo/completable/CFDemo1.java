package com.struct.concurrency.demo.completable;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFDemo1 {

    static void main() throws ExecutionException, InterruptedException {
        Runnable runnable = (Runnable) () -> {
            System.out.println("无返回值任务");
        };
        CompletableFuture.runAsync(runnable);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("有返回值task");
            return "hello world";});
        System.out.println(completableFuture.get());
    }

}
