package com.struct.concurrency.demo.threadlocal;

public class ThreadLocalDemo1 {

    private String content;
    public ThreadLocalDemo1() {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }


    static void main() {
        ThreadLocalDemo1 threadLocalDemo1 = new ThreadLocalDemo1();

        for (int i = 0; i < 50; i++) {
            Thread thread = new Thread(() -> {
                threadLocalDemo1.setContent(Thread.currentThread().getName());

                System.out.println(Thread.currentThread().getName() + threadLocalDemo1.getContent());
            });
            thread.start();
        }
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set("hello world");
        System.out.println(threadLocal2.get());
    }

}
