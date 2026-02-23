package com.struct.concurrency.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo1 {
    static int count = 0;
    static ReentrantLock lock = new ReentrantLock();
//
//    static XinLock lock = new XinLock();
    static void main() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                lock.lock();
                for (int i1 = 0; i1 < 10000; i1++) {
                    count++;
                }
                lock.unlock();
            }).start();
        }

        Thread.sleep(5000L);
        System.out.println(count);


    }
}
