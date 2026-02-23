package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchDemo2 {
    static void main() {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                log.info("{}执行",Thread.currentThread().getName());
                countDownLatch.countDown();
            },"t_"+i).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end");

    }
}
