package com.struct.concurrency.demo.lock;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerDemo2 {

    private static Exchanger<String> exchanger = new Exchanger<>();

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    static void main() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "12379871924sfkhfksdhfks";
                    exchanger.exchange(A);
                } catch (InterruptedException e) {
                }
            }
        });


        executorService.execute(new Runnable() {
            @Override
            public void run() {

                String B = "12379871924sfkhfksdhfksc";
                try {
                    String A =  exchanger.exchange(B);
                    System.out.println("对账结果："+ A.equals(B));
                    System.out.println("A:"+A);
                    System.out.println("N:"+B);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        });

        executorService.shutdown();

    }

}
