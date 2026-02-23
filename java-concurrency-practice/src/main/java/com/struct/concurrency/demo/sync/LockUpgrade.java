package com.struct.concurrency.demo.sync;

import org.openjdk.jol.info.ClassLayout;

public class LockUpgrade {


    static void main() throws InterruptedException {

        User user = new User();

        System.out.println("无锁状态：001"+ ClassLayout.parseInstance(user).toPrintable());

        Thread.sleep(5000L);
//        //java 25已经废弃
//        System.out.println("偏向锁状态，101"+ ClassLayout.parseInstance(user).toPrintable());
//
//        for(int i=0;i<2;i++){
//            synchronized (user){
//                System.out.println("偏向锁(101)(带线程id):"+ ClassLayout.parseInstance(user).toPrintable());
//            }
//            System.out.println("偏向锁释放(101)(带线程id)："+ ClassLayout.parseInstance(user).toPrintable());
//        }


        new Thread(()->{
                synchronized (user){
                    System.out.println("轻量级锁 000:"+ ClassLayout.parseInstance(user).toPrintable());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        }).start();

        Thread.sleep(1000L);


        new Thread(()->{
            synchronized (user){
                System.out.println("重量级锁：010"+ClassLayout.parseInstance(user).toPrintable());
            }
        }).start();









    }
}
