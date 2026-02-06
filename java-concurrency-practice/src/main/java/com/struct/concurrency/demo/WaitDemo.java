package com.struct.concurrency.demo;

import java.util.concurrent.BlockingQueue;

public class WaitDemo {

    static class MessageQueue {

        private String msg;

        public MessageQueue() {

        }

        public MessageQueue(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public synchronized void produce(String msg) throws InterruptedException {
            while (this.msg != null) {
                wait();
            }
            System.out.println("produce:" + msg);
            this.msg = msg;
            notify();
        }

        public synchronized void consume() throws InterruptedException {
            while (this.msg == null) {
                wait();
            }
            System.out.println("consume msg:" + msg);
            msg = null;
            notify();
        }
    }

    static void main() throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue();

        Thread prodece = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    messageQueue.produce("times" + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consume = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    messageQueue.consume();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        prodece.start();
        consume.start();

        prodece.join();
        consume.join();
    }

}
