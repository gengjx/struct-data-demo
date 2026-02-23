package com.struct.concurrency.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入
 */
public class ReentrantLockDemo2 {

    private final ReentrantLock lock = new ReentrantLock();

    public  void recursiveCall(int num){

        lock.lock();
        try{
            if(num == 0){
                return;
            }
            System.out.println("num:"+num);
            recursiveCall(num-1);
        }catch (Exception e){
            e.printStackTrace();
            lock.unlock();
        }

    }

    static void main() {
        ReentrantLockDemo2 reentrantLockDemo2 = new ReentrantLockDemo2();
        reentrantLockDemo2.recursiveCall(10);
    }
}
