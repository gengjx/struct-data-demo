package com.struct.concurrency.demo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CFDemo6 {

    static void main() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("线程一");
            return  3;
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("线程二");
            return  3;
        });

        CompletableFuture future =   future1.thenCombine(future2, (x, y) -> x + y);

        System.out.println(future.get());

    }
}
