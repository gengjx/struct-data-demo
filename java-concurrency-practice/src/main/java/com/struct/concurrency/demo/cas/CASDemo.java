package com.struct.concurrency.demo.cas;

import java.util.Random;

public class CASDemo {

    private volatile int instance = 1;


    public synchronized void setValue(int exceptValue, int newValue) {
        int oldValue = accessMemory(instance);
        if (oldValue == exceptValue) {
            System.out.println(Thread.currentThread().getName() + " set except value:" + exceptValue + " newValue:" + newValue);
            instance = newValue;
        } else {
            System.out.println(Thread.currentThread().getName() + "写入失败");
        }
    }


    int accessMemory(int instance) {
        return instance;
    }

    static void main() {

        CASDemo casDemo = new CASDemo();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                casDemo.setValue(1, 2);
            }).start();
        }

        System.out.println("main end");
    }


}
