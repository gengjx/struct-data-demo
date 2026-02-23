package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁 非公平锁
 */
@Slf4j
public class ReentrantLockDemo5 {

    static void main() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);


        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();

                try {
                    Thread.sleep(20L);
                    log.debug(Thread.currentThread().getName() + " running...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            },"t_"+i).start();
        }
        Thread.sleep(500);

        for (int i = 0; i < 500; i++) {
            new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(100L);
                    log.debug(Thread.currentThread().getName() + " 抢占running...");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
            },"t2_"+i).start();
        }


    }
}
