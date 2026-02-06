package com.struct.concurrency.demo.threadlocal;

public class ThreadLocalDemo2 {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();


    private String getContent(){
        return threadLocal.get();
    }
    public void setContent(String content){
        threadLocal.set(content);
    }


    static void main() {
        ThreadLocalDemo2 threadLocalDemo2 = new ThreadLocalDemo2();

        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                threadLocalDemo2.setContent(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getName() + threadLocalDemo2.getContent());
            }).start();
        }


        threadLocalDemo2.setContent(Thread.currentThread().getName());

        System.out.println(Thread.currentThread().getName() +" content: "+ threadLocalDemo2.getContent());

        System.out.println("main end");



        ThreadLocal<Integer> threadLocal2 = new ThreadLocal<>();

        System.out.println(threadLocal2.get());

    }


}
