package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class CyclicBarrierDemo2 {

    /**
     * 根据品类ID获取商品列表
     *
     * @return
     */
    private static int[] getProductsByCategoryId() {
        // 商品列表编号为从1～10的数字
        return IntStream.rangeClosed(1, 10).toArray();
    }

    /*
     *  商品编号与所对应的价格，当然真实的电商系统中不可能仅存在这两个字段
     */
    private static class ProductPrice {
        private final int prodID;
        private double price;

        private ProductPrice(int prodID) {
            this(prodID, -1);
        }

        private ProductPrice(int prodID, double price) {
            this.prodID = prodID;
            this.price = price;
        }

        int getProdID() {
            return prodID;
        }

        void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "ProductPrice{" + "prodID=" + prodID + ", price=" + price + '}';
        }
    }


    static void main() throws InterruptedException {

        int[] categoryIds = getProductsByCategoryId();

        List<ProductPrice> list = Arrays.stream(categoryIds).mapToObj(ProductPrice::new).toList();
        final CyclicBarrier barrier = new CyclicBarrier(list.size());
        List<Thread> threads = new ArrayList<>();
        list.forEach(p -> {

            Thread thread = new Thread(() -> {
               log.info(p.prodID+": 开启计算价格");
                try {
                    TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
                    if (p.prodID % 2 == 0) {
                        p.setPrice(p.prodID * 0.9D);
                    } else {
                        p.setPrice(p.prodID * 0.71D);
                    }
                    System.out.println(p.getProdID() + "->价格计算完成.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    try {
                        barrier.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    } catch (BrokenBarrierException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            threads.add(thread);
            thread.start();
        });

        for (Thread thread : threads) {
            thread.join();
        }
    log.info("所有价格计算完成");

    }


}
