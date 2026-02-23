package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockDemo6 {

    static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock(false);

        Thread t1 = new Thread(() -> {
            log.info("t1线程开始。。。。");
            try {
                if (!reentrantLock.tryLock(3, TimeUnit.SECONDS)) {
                    log.debug("获取线程失败");
                    return;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);

            }

            try {
                log.debug("t1获得了锁");
            } finally {
                reentrantLock.unlock();
            }

        });

        reentrantLock.lock();
        try {
            log.debug("main线程获得了锁");
            t1.start();
            //先让线程t1执行
            Thread.sleep(5000);
        } finally {
            reentrantLock.unlock();
        }


    }


}
