package com.struct.concurrency.demo.sync;

public class SyncDemo2 {

    private static int  counter;

    private final Object lock = new Object();

    private void increment(){
        synchronized (this.lock){
            counter++;
        }

    }

    private  synchronized void decrement(){
        synchronized (this.lock){
            counter--;
        }
    }

    static void main() {

        SyncDemo2 sd = new SyncDemo2();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.increment();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               sd.decrement();
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
