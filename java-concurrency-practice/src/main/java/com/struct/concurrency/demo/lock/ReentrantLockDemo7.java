package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockDemo7 {

    static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();

        Thread t1 = new Thread(() -> {

            try {
                lock.lockInterruptibly();
                Thread.sleep(2000);
                log.info("t1线程执行完成");
            } catch (InterruptedException e) {
                log.debug("t1线程被中断");
                Thread.currentThread().interrupt();
                log.debug("t1线程结束");
                e.printStackTrace();
            }


        },"t1");

        lock.lock();
        log.debug("主线程开始。。。。");
        //先让线程t1执行
        t1.start();

        Thread.sleep(2000);
        //中断t1
        t1.interrupt();
        log.debug("线程t1执行中断");

        // 等待t1线程结束或超时
        t1.join(5000);

        lock.unlock();


    }
}
