package com.struct.concurrency.demo.sync;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncDemo4 {

    private AtomicInteger count = new AtomicInteger(0);

    private void increment(){
        count.incrementAndGet();
    }


    private void decrement(){
        count.decrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {
        SyncDemo4 syncDemo4 = new SyncDemo4();

        Thread t1 = new Thread(
                ()->{
                    for (int i = 0; i < 5000; i++) {
                        syncDemo4.increment();
                    }
                }
        );

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 5000; i++) {
                syncDemo4.decrement();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(syncDemo4.count);
    }

}
