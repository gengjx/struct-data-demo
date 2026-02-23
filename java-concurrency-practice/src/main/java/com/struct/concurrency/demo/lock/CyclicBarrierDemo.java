package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierDemo {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(5);

    static void main() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("准备发车");
        });

        for (int i = 0; i < 10; i++) {
            final int id = i + 1;
            executorService.execute(()->{

                log.info("{}号选手马上就到",id);
                int sleepMills = ThreadLocalRandom.current().nextInt(2000);
                try {
                    Thread.sleep(sleepMills);
                   log.info(id + "号到了，上车");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

}
