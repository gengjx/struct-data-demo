package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class CountDownLatchDemo {

    private static CountDownLatch countDownLatch = new CountDownLatch(8);

    private static CountDownLatch countDownLatch2 = new CountDownLatch(1);


    static void main() throws InterruptedException {

        for (int i = 0; i < 8; i++) {
            new Thread(() -> {
                try {
                    log.info(Thread.currentThread().getName()+"：准备好了");
                    countDownLatch2.await();
                    Thread.sleep(new Random().nextInt(1000));
                    System.out.println(Thread.currentThread().getName()+"完成比赛");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"t"+i).start();

        }

        Thread.sleep(5000l);

        log.info("教练准备好了，吹响口哨");
        countDownLatch2.countDown();
        countDownLatch.await();
        log.info("所有参赛人员完成比赛");
    }


}
