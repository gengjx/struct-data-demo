package com.struct.concurrency.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

    public static void run() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        try {
            List<Callable<Integer>> tasks = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int idx = i;
                tasks.add(() -> {
                    TimeUnit.MILLISECONDS.sleep(50L);
                    return idx * idx;
                });
            }

            List<Future<Integer>> futures = new ArrayList<>();
            for (Callable<Integer> task : tasks) {
                futures.add(pool.submit(task));
            }

            int sum = 0;
            for (Future<Integer> f : futures) {
                sum += f.get();
            }

            System.out.println("sum=" + sum);
        } finally {
            pool.shutdown();
            pool.awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
