package com.struct.concurrency.demo.lock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo3 {

    static void main() {
        Queue queue = new Queue(5);

        new Thread(new Producer(queue)).start();

        new Thread(new Consumer(queue)).start();


    }


    static class Queue {

        private Object[] items;
        private int size;
        private int takeIndex;
        private int putIndex;
        private  ReentrantLock lock;

        private Condition notFull;
        private Condition notEmpty;


        public Queue(int size) {
            items = new Object[size];
            lock = new ReentrantLock();
            notFull = lock.newCondition();
            notEmpty = lock.newCondition();
        }


        public void put(Object item) {
            lock.lock();
            try {
                while (size == items.length) {
                    System.out.println("queue is full await");
                    notFull.await();
                }
                items[putIndex] = item;
                if(++putIndex == items.length){
                    putIndex = 0;
                }
                size++;
                notEmpty.signal();

            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println("producer 生产："+ item);
                lock.unlock();
            }
        }

        public Object take() {
            lock.lock();
            try {
                while (size == 0) {
                    notEmpty.await();
                }
                Object item = items[takeIndex];
                items[takeIndex] = null;
                if (++takeIndex == items.length) {
                    takeIndex = 0;
                }
                size--;
                notFull.signal();
                return item;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            } finally {
                lock.unlock();
            }

        }

    }



    static class Producer implements Runnable {
        private  Queue queue;
        public Producer(Queue queue) {
            this.queue = queue;
        }

        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                queue.put(new Random().nextInt(1000));
            }
        }
    }

    static class Consumer implements Runnable {
        private  Queue queue;
        public Consumer(Queue queue) {
            this.queue = queue;
        }

        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Object item = queue.take();
                System.out.println("consumer消费："+item);
            }
        }
    }


}
