package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExchangerDemo3 {

    private static  final Exchanger<ArrayBlockingQueue<String>> exchanger = new Exchanger<>();

    private static final ArrayBlockingQueue<String> empty = new ArrayBlockingQueue<>(5);

    private static final ArrayBlockingQueue<String> full = new ArrayBlockingQueue<>(5);


    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    static void main() {
        executorService.submit(new Producer());
        executorService.submit(new Consumer());

    }


    static class  Producer implements Runnable {
        @Override
        public void run() {

            ArrayBlockingQueue<String> queue = empty;

            try {
                while (true){
                    String str = UUID.randomUUID().toString();
                    try {
                        queue.add(str);
                        System.out.println("producer：生产了一个序列：" + str + ">>>>>加入到交换区");
                        Thread.sleep(2000);
                    } catch (IllegalStateException e) {
                        log.error("生产队列满了，换一个队列：");
                        queue = exchanger.exchange(queue);
                        log.info("生产队列，交换成功，交换到空队列");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    static class  Consumer implements Runnable {

        @Override
        public void run() {
            ArrayBlockingQueue<String> queue = full;

            try {
                while (true){
                    if (!queue.isEmpty()){
                        String str = queue.take();
                        log.info("consumer 消耗了一个任务：{}",str);
                    }else {
                        log.info("consumer 消费队列空了，换一个队列消费");
                        queue = exchanger.exchange(queue);
                        log.info("交换成功");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }



        }
    }


}
