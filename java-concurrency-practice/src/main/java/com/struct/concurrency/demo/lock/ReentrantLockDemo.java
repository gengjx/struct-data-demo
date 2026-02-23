package com.struct.concurrency.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private static ReentrantLock reentrantLock = new ReentrantLock(true);

    private static int ticket = 8;

    static void main() {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
               reentrantLock.lock();
                if (ticket>0){
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+"购买到了第"+ticket--+"张票");
                }else {
                    System.out.println("票卖完了");
                }
                reentrantLock.unlock();

            }).start();
        }


    }
}
