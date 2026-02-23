package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierDemo3 {

    static void main() throws BrokenBarrierException, InterruptedException {

        // 定义CyclicBarrier，注意这里的parties值为11
        final CyclicBarrier barrier = new CyclicBarrier(11);
        // 创建10个线程
        for (int i = 0; i < 10; i++) {
            // 定义游客线程，传入游客编号和barrier
            new Thread(new Tourist(i, barrier)).start();
        }
        // 主线程也进入阻塞，等待所有游客都上了旅游大巴
        barrier.await();
        System.out.println("导游:所有的游客都上了车.");
        // 主线程进入阻塞，等待所有游客都下了旅游大巴
        barrier.await();
        System.out.println("导游:所有的游客都下车了.");
    }

    static class Tourist extends Thread{


        private  int touristID;
        private  CyclicBarrier barrier;

        private Tourist(int touristID, CyclicBarrier barrier) {
            this.touristID = touristID;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            log.info("{}游客id准备上车",this.touristID);
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{}游客id上车，等待其他人上车",this.touristID);
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
            System.out.printf("游客:%d 到达目的地\n", touristID);
            // 模拟乘客下车的时间开销
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.info("{}游客id下车，等待其他人下车",this.touristID);
            try {
                barrier.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (BrokenBarrierException e) {
                throw new RuntimeException(e);
            }


        }
    }

}
