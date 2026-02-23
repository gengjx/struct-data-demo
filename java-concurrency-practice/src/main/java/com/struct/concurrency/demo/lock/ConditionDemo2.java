package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionDemo2 {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();


    static void main() throws InterruptedException {

        new Thread(()->{

           lock.lock();
           try {
                log.info("{},获取到锁",Thread.currentThread().getName());
                condition.await();
           }catch (InterruptedException e){
               e.printStackTrace();
           }finally {
               log.info("{},线程结束释放锁",Thread.currentThread().getName());
               lock.unlock();
           }

        },"t1").start();

        new Thread(()->{

            lock.lock();
            try {
                log.info("{},获取到锁",Thread.currentThread().getName());
                condition.await();

            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                log.info("{},线程结束,释放锁",Thread.currentThread().getName());
                lock.unlock();
            }


        },"t2").start();


        Thread.sleep(5000);
        lock.lock();
        try {
            log.info("{}线程获得锁",Thread.currentThread().getName());
            condition.signalAll();
        }finally {
            lock.unlock();
        }




    }

}
