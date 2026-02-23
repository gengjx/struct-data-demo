package com.struct.concurrency.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Exchanger;

@Slf4j
public class ExchangerDemo {

    static void main() throws InterruptedException {

        final Exchanger<String> exchanger = new Exchanger<>();
        final String goods = "电脑";
        final String money = "$4000";

        Thread thread1 = new Thread(() -> {

            System.out.println("买家准备好了钱："+money);

            try {
              String exchange =   exchanger.exchange(money);
                System.out.println("买家获得了"+exchange);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        thread1.start();

        Thread.sleep(2000l);

        Thread thread2 = new Thread(() -> {
            System.out.println("卖家准备好了货物："+goods);

            try {
                String exchange =  exchanger.exchange(goods);
                System.out.println("卖家获得了："+exchange);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });
        thread2.start();


        thread1.join();
        thread2.join();

        System.out.println(("交易成功......."));


    }


}
