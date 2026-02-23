package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreDemo {


    Semaphore semaphore = new Semaphore(2);

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    static void main() throws InterruptedException {

        SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(10);
            demo.executorService.submit(() -> {
                demo.getInfo2();
            });
        }
    }


    public void getInfo(){
            try {
                semaphore.acquire();
                Thread.sleep(100);
                log.info(Thread.currentThread().getName()+" : 获取商品信息成功");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                semaphore.release();
            }
    }

    public void getInfo2(){
        try {
           if (!semaphore.tryAcquire()){
               log.info("限流，请求失败");
               return;
           }
            Thread.sleep(50);
            log.info(Thread.currentThread().getName()+" : 获取商品信息成功");
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }finally {
            semaphore.release();
        }
    }

}
