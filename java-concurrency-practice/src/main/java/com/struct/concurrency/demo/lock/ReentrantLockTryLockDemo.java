package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ReentrantLockTryLockDemo {

    private final ReentrantLock reentrantLock = new ReentrantLock();

    private int ticket =1;

    public void buyTicket(){

        try {
            if (reentrantLock.tryLock(1, TimeUnit.SECONDS)){
                if(ticket >= 1){
                    log.info(Thread.currentThread().getName() + "买到了票");
                    ticket =0;
                }else {
                    System.out.println("票已经被抢光了");
                }
                reentrantLock.unlock();
            }else {
                log.info("放弃抢票了");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    static void main(String[] args) {
        ReentrantLockTryLockDemo demo = new ReentrantLockTryLockDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                demo.buyTicket();
            },"ticket_"+i).start();
        }
    }

}
