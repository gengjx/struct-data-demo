package com.struct.concurrency.demo.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CFDemo3 {

    static void main() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String result = "hello";
            System.out.println("第一阶段："+result);
            return result;
        }).thenApply(v -> v.toUpperCase());
        System.out.println("最终结果："+future.join());
    }


}
