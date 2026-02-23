package com.struct.concurrency.demo.lock;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.concurrent.ThreadLocalRandom.current;
import static java.util.stream.Collectors.toList;

public class CountDownLatchDemo3 {

    private static int[] getArray(int length){
        return IntStream.rangeClosed(1,length).toArray();
    }

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
        int [] array = getArray(10);
        // 通过stream的map运算将商品编号转换为ProductPrice
        List<ProductPrice> list = Arrays.stream(array).mapToObj(ProductPrice::new).collect(toList());
        CountDownLatch latch = new CountDownLatch(list.size());
        list.forEach(pp -> {
            try {
                System.out.println("开始计算价格。。。。");
                // 模拟其他的系统调用，比较耗时，这里用休眠替代
                TimeUnit.SECONDS.sleep(current().nextInt(10));
                // 计算商品价格
                if (pp.prodID % 2 == 0) {
                    pp.setPrice(pp.prodID * 0.9D);
                } else {
                    pp.setPrice(pp.prodID * 0.71D);
                }
                System.out.println(pp.getProdID() + "-> 价格计算完成.");
            } catch (InterruptedException e) {
            } finally {
                // 3. 计数器count down，子任务执行完成
                latch.countDown();
            }
        });
        latch.await();
        System.out.println("所有价格计算完成.");
        list.forEach(System.out::println);
    }
}
