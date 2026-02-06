package com.struct.concurrency.demo;

import lombok.SneakyThrows;

public class ThreadJoinDemo {

    /**
     * A,B,C三个线程顺序执行
     */
    static class Thread1 extends Thread{

        private Thread thread;
        public Thread1(Thread thread){
            this.thread = thread;
        }

        @SneakyThrows
        public void run(){
            System.out.println("thread1 start....");
            if(thread != null){
                thread.join();
            }
            System.out.println("thread1 end...");

        }


    }
    static class Thread2 extends Thread{

        private Thread thread;

        public Thread2(Thread thread){
            this.thread = thread;
        }

        @SneakyThrows
        public void run(){
            System.out.println("thread2 start....");
            if(thread != null){
                thread.join();
            }
            System.out.println("thread2 end...");
        }


    }

    static class Thread3 extends Thread{

        @SneakyThrows
        public  void run(){
            System.out.println("thread3 start....");
            Thread.sleep(1000L);
            System.out.println("thread3 end...");
        }

    }


    static void main() throws InterruptedException {
        Thread3 thread3 = new Thread3();
        Thread2 thread2 = new Thread2(thread3);
        Thread1 thread1 = new Thread1(thread2);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        System.out.println("main end...");
    }


}
