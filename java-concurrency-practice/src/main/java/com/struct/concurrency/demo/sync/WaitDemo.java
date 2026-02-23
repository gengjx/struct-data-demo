package com.struct.concurrency.demo.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitDemo {

    final static Object lock = new Object();

    static void main() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t1获得锁");
                try {
                    lock.wait();
                    System.out.println("t1结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2获得锁");
                try {
                    lock.wait();
                    System.out.println("t2结束");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("获得锁去唤醒线程");

        synchronized (lock) {
            lock.notifyAll();
        }

        log.info("main thread end");

    }
}
