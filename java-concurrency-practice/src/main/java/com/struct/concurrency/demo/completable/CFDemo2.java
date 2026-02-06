package com.struct.concurrency.demo.completable;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CFDemo2 {

    static void main() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            if (new Random().nextInt(10) % 2 == 0) {
                throw new RuntimeException();
            }
            return "hello";
        });

        future.whenComplete((res, ex) -> {
            if(res != null){
                System.out.println(res+"执行完成");
            }
        });

        future.exceptionally(ex -> {
            System.out.println(ex);
            return "执行异常";
        }).join();
    }
}
