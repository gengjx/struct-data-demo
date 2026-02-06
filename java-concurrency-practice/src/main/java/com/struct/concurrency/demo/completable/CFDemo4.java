package com.struct.concurrency.demo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class CFDemo4 {

    static void main() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            return "hello";

        }).thenCompose(new Function<String, CompletableFuture<String>>() {
            @Override
            public CompletableFuture<String> apply(String s) {
                return CompletableFuture.supplyAsync(() -> s + " world");
            }
        });

        System.out.println(future.get());
    }
}
