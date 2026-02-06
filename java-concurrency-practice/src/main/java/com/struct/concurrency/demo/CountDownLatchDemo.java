package com.struct.concurrency.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    public static void run() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            int idx = i;
            Thread.ofVirtual().name("latch-worker-" + i).start(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(100L + idx * 50L);
                    System.out.println("done: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        System.out.println("all done");
    }
}
