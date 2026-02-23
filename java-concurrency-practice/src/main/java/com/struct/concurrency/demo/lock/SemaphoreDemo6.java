package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreDemo6 {

    static void main() throws InterruptedException {

        Semaphore semaphore = new Semaphore(1,true);


       Thread t1 =  new Thread(() -> {
            log.info("{}线程开始", Thread.currentThread().getName());
            semaphore.acquireUninterruptibly();
            log.info("{} 获取线程", Thread.currentThread().getName());
            try {
                TimeUnit.HOURS.sleep(2);
            } catch (InterruptedException e) {
                log.info("{}被打断", Thread.currentThread().getName());
                Thread.currentThread().interrupt();
            }finally {
                semaphore.release();
            }
        },"t1");

       Thread t2 =  new Thread(() -> {
            log.info("{}线程开始", Thread.currentThread().getName());
            try {
                semaphore.acquireUninterruptibly();
                log.info("{} 线程获取凭证", Thread.currentThread().getName());
            }finally {
                log.info("{}线程退出", Thread.currentThread().getName());
                semaphore.release();
            }
        },"t2");
       t1.start();
       Thread.sleep(1000l);
       t2.start();
       t1.interrupt();
        // 主线程获取许可证
        semaphore.acquire();
        System.out.println("The main thread acquired permit.");
        semaphore.release();
        log.info("main thread released permit.");
    }
}
