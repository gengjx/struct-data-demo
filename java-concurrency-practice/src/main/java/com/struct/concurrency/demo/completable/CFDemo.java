package com.struct.concurrency.demo.completable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CFDemo {

    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("i am a thread");
        }
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("i am a runnable");
        }
    }


    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("i am a callable");
            return "i am a callable";
        }
    }


    static void main() {
        MyThread myThread = new MyThread();
        myThread.start();
        MyRunnable myRunnable = new MyRunnable();

        Thread myThread1 = new Thread(myRunnable);
        myThread1.start();

        MyCallable myCallable = new MyCallable();

        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println("result: "+futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main end");
    }

}
