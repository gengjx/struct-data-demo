package com.struct.concurrency.demo.sync;

public class SyncDemo1 {

    private static int  counter;

    private static synchronized void increment(){
        counter++;
    }

    private static synchronized void decrement(){
        counter--;
    }

    static void main() {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                SyncDemo1.increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                SyncDemo1.decrement();
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter);

    }

}
