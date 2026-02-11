package com.struct.concurrency.demo.sync;

public class SyncDemo {

    private static int counter = 0;

    static void main() throws InterruptedException {


      Thread thread1 =  new Thread(() -> {
          for (int i = 0; i < 5000; i++) {
              synchronized (SyncDemo.class) {
                  counter++;
              }

          }
        });

      Thread thread2 =  new Thread(() -> {
          for (int i = 0; i < 5000; i++) {
              synchronized (SyncDemo.class) {
                  counter--;
              }
          }
      });


      thread2.start();
      thread1.start();

      thread1.join();
      thread2.join();


        System.out.println(counter);


    }


}
