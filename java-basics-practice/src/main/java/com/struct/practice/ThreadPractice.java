package com.struct.practice;

import java.nio.channels.Pipe.SourceChannel;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程练习
 * 练习内容：
 * 1. 线程的创建方式（继承Thread、实现Runnable）
 * 2. 线程的生命周期
 * 3. 线程同步（synchronized、Lock）
 * 4. 线程通信（wait、notify）
 * 5. 线程池（ExecutorService）
 * 6. 并发工具类（CountDownLatch、CyclicBarrier、Semaphore）
 */
public class ThreadPractice {

    /**
     * 练习1：继承Thread类创建线程
     */
    // TODO: 创建一个继承Thread的类
    // class MyThread extends Thread {
    //     @Override
    //     public void run() {
    //         for (int i = 0; i < 5; i++) {
    //             System.out.println(Thread.currentThread().getName() + ": " + i);
    //             try {
    //                 Thread.sleep(1000);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     }
    // }

    static class MyThread extends Thread{

        public MyThread(){
            
        }
        @Override
        public void run(){
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "L "  + i);
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){

                    }
               
            }

        }
    }
    static void practice1_Thread(){
        System.out.println("[Thread练习一]：继承Thread类");
        MyThread myThread = new MyThread();
        myThread.run();
    }


    /**
     * 练习2：实现Runnable接口创建线程
     */
    // TODO: 创建一个实现Runnable的类
    // class MyRunnable implements Runnable {
    //     @Override
    //     public void run() {
    //         for (int i = 0; i < 5; i++) {
    //             System.out.println(Thread.currentThread().getName() + ": " + i);
    //         }
    //     }
    // }

        static class  MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "L "  + i);
                    try{
                        Thread.sleep(1000);
                        System.out.println("runnable 接口执行成功");
                    }catch(InterruptedException e){

                    }
            }
        }
                   
        }
        static void  practice2_RunnableBasics(){
            MyRunnable myRunnable = new MyRunnable();
            Thread myThread = new Thread(myRunnable);
            myThread.start();
        }



    /**
     * 练习3：线程的基本操作
     */
    public static void practice3_ThreadBasics() {
        System.out.println("=== 练习3：线程基本操作 ===");

        // 1. 启动线程：start()，2. 线程睡眠：Thread.sleep()，3. 线程等待：join()，
        // 4. 线程中断：interrupt()，5. 获取当前线程：Thread.currentThread()，
        // 6. 设置线程名称：setName()，7. 设置线程优先级：setPriority()
        Thread thread = new Thread(() -> {
            try {
                System.out.println("线程开始，名字：" + Thread.currentThread().getName());
                // 线程睡眠2秒
                Thread.sleep(2000);
                System.out.println("线程醒来，优先级：" + Thread.currentThread().getPriority());
            } catch (InterruptedException e) {
                System.out.println("线程被中断！");
            }
        });

        // 设置线程名字
        thread.setName("练习线程");
        // 设置线程优先级
        thread.setPriority(Thread.MAX_PRIORITY);

        thread.start();

        try {
            // 主线程等待新线程结束
            thread.join(1000); // 主线程只等1秒，未必等到子线程运行结束
            if (thread.isAlive()) {
                System.out.println("子线程没有在1秒内结束，主线程将中断它！");
                thread.interrupt();
            }
        } catch (InterruptedException e) {
            System.out.println("主线程等待被中断");
        }

        // 获取当前线程（主线程）
        System.out.println("当前线程(主线程)：" + Thread.currentThread().getName());
    }

    /**
     * 练习4：synchronized关键字
     * 任务：理解synchronized的用法
     */
    // 创建一个共享资源类和同步方法
    static class Counter {
        private int count = 0;

        // 同步方法
        public synchronized void increment() {
            count++;
        }

        // 同步代码块
        public void increment2() {
            synchronized (this) {
                count++;
            }
        }

        public int getCount() {
            return count;
        }
    }

    static void practice4_synchronized() {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("线程1执行i: " + i + " count: " + counter.getCount());
                counter.increment();
               
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("线程2执行i: " + i + " count: " + counter.getCount());
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        // 等待两个线程都执行完成
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("执行结果：" + counter.getCount());
    }

    /**
     * 练习5：Lock接口
     * 任务：使用ReentrantLock实现线程同步
     */
    public static void practice5_ReentrantLock() {
        System.out.println("\n=== 练习5：ReentrantLock ===");

        class LockCounter {
            private int count = 0;
            private final ReentrantLock lock = new ReentrantLock();

            public void increment() {
                lock.lock();
                try {
                    count++;
                } finally {
                    lock.unlock();
                }
            }

            public int getCount() {
                return count;
            }
        }

        LockCounter lockCounter = new LockCounter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("ReentrantLock 线程1执行i: " + i + " count: " + lockCounter.getCount());
                lockCounter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("ReentrantLock 线程2执行i: " + i + " count: " + lockCounter.getCount());
                lockCounter.increment();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ReentrantLock 执行结果：" + lockCounter.getCount());
        System.out.println("synchronized和ReentrantLock区别：synchronized是Java关键字，自动加解锁，不能中断，无法感知是否成功；ReentrantLock是类，灵活，可中断，可尝试加锁，支持公平锁。");
    }

    /**
     * 练习6：wait和notify
     * 任务：实现线程间通信
     */
    public static void practice6_WaitNotify() {
        System.out.println("\n=== 练习6：wait和notify ===");

        // 实现生产者-消费者模式，单元素的消息队列
        class MessageQueue {
            private String message = null;

            public synchronized void produce(String msg) {
                while (message != null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                message = msg;
                System.out.println("生产者生产：" + msg);
                notify(); // 唤醒等待的消费者
            }

            public synchronized String consume() {
                while (message == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String msg = message;
                System.out.println("消费者消费：" + msg);
                message = null;
                notify(); // 唤醒等待的生产者
                return msg;
            }
        }

        MessageQueue queue = new MessageQueue();

        Thread producer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.produce("消息-" + i);
                try {
                    Thread.sleep(500); // 模拟生产耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                queue.consume();
                try {
                    Thread.sleep(800); // 模拟消费耗时
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("生产与消费结束");
    }

    /**
     * 练习7：volatile关键字
     * 任务：理解volatile的作用
     */
    // TODO: 理解volatile关键字
    // 1. volatile保证可见性
    // 2. volatile不保证原子性
    // 3. 使用场景：标志位变量
    
    // class VolatileExample {
    //     private volatile boolean flag = false;
    //     
    //     public void setFlag() {
    //         flag = true;
    //     }
    //     
    //     public boolean getFlag() {
    //         return flag;
    //     }
    // }

    /**
     * 练习8：线程池的使用
     * 任务：掌握ExecutorService的使用
     */
    public static void practice8_ThreadPool() {
        System.out.println("\n=== 练习8：线程池 ===");
        
        // TODO: 使用线程池
        // 1. 创建线程池：Executors.newFixedThreadPool()
        // 2. 提交任务：execute(), submit()
        // 3. 关闭线程池：shutdown(), shutdownNow()
        // 4. 理解线程池的优势
        
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        // 提交任务
        executor.execute(()->{
            System.out.println("执行任务ing");
        });
        
        // 关闭线程池
        executor.shutdown();
    }

    /**
     * 练习9：Callable和Future
     * 任务：使用Callable获取线程返回值
     */
    public static void practice9_CallableFuture() {
        System.out.println("\n=== 练习9：Callable和Future ===");
        
        // TODO: 使用Callable和Future
        // 1. 创建Callable任务
        // 2. 提交任务获取Future对象
        // 3. 使用Future.get()获取结果
        
        ExecutorService executor = Executors.newFixedThreadPool(1);
        
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });
        
        try {
            Integer result = future.get();
            System.out.println("结果: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }

    /**
     * 练习10：CountDownLatch
     * 任务：使用CountDownLatch实现线程等待
     */
    public static void practice10_CountDownLatch() {
        System.out.println("\n=== 练习10：CountDownLatch ===");
        
        // TODO: 使用CountDownLatch
        // 场景：主线程等待多个子线程完成任务
        
        int threadCount = 3;
        CountDownLatch latch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "线程：");
                latch.countDown();
            }).start();
        }

        try {
            latch.await();  // 注意: 这里应该是 latch.await() 而不是 latch.wait()
            System.out.println("所有线程执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 练习11：CyclicBarrier（循环屏障）
     * 任务：使用CyclicBarrier实现线程同步
     * 
     * CyclicBarrier 特点：
     * 1. 让一组线程互相等待，直到所有线程都到达某个屏障点（barrier point）
     * 2. 可以重用（cyclic），屏障可以多次使用
     * 3. 可以设置一个可选的 Runnable 回调，在所有线程到达屏障时执行
     * 
     * 与 CountDownLatch 的区别：
     * - CountDownLatch：一个线程等待多个线程完成（一次性）
     * - CyclicBarrier：多个线程互相等待（可重用）
     */
    public static void practice11_CyclicBarrier() {
        System.out.println("\n=== 练习11：CyclicBarrier ===");
        
        // 示例1：基本使用 - 多个线程在屏障点等待，然后同时继续
        System.out.println("--- 示例1：基本使用 ---");
        int threadCount = 3;
        
        // 创建 CyclicBarrier，参数1：需要等待的线程数，参数2：所有线程到达后执行的回调
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("【屏障回调】所有 " + threadCount + " 个线程都已到达屏障点，开始下一阶段！");
        });
        
        for (int i = 1; i <= threadCount; i++) {
            final int threadId = i;
            new Thread(() -> {
                try {
                    System.out.println("线程-" + threadId + " 正在执行第一阶段任务...");
                    Thread.sleep((long)(Math.random() * 2000)); // 模拟不同执行时间
                    System.out.println("线程-" + threadId + " 第一阶段完成，等待其他线程...");
                    
                    // await() 方法：当前线程到达屏障点并等待，直到所有线程都到达
                    // 返回值：当前线程是第几个到达屏障的（从0开始）
                    int arrivalIndex = barrier.await();
                    System.out.println("线程-" + threadId + " 通过屏障！到达顺序：" + arrivalIndex);
                    
                    // 所有线程都到达后，继续执行后续任务
                    System.out.println("线程-" + threadId + " 开始执行第二阶段任务...");
                    
                } catch (InterruptedException e) {
                    System.out.println("线程-" + threadId + " 被中断");
                } catch (BrokenBarrierException e) {
                    System.out.println("线程-" + threadId + " 屏障被破坏");
                }
            }, "Worker-" + threadId).start();
        }
        
        // 等待所有线程完成
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 示例2：展示 CyclicBarrier 的可重用性（cyclic）
        System.out.println("\n--- 示例2：CyclicBarrier 可重用性 ---");
        CyclicBarrier reusableBarrier = new CyclicBarrier(2, () -> {
            System.out.println("【可重用屏障】两个线程都到达，可以进行下一轮！");
        });
        
        Thread t1 = new Thread(() -> {
            try {
                for (int round = 1; round <= 3; round++) {
                    System.out.println("线程A - 第" + round + "轮任务");
                    Thread.sleep(500);
                    reusableBarrier.await(); // 每轮都等待另一个线程
                    System.out.println("线程A - 第" + round + "轮完成");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        Thread t2 = new Thread(() -> {
            try {
                for (int round = 1; round <= 3; round++) {
                    System.out.println("线程B - 第" + round + "轮任务");
                    Thread.sleep(800);
                    reusableBarrier.await(); // 每轮都等待另一个线程
                    System.out.println("线程B - 第" + round + "轮完成");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        t1.start();
        t2.start();
        
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nCyclicBarrier 使用要点：");
        System.out.println("1. await() 会阻塞当前线程，直到所有线程都调用 await()");
        System.out.println("2. 可以设置超时：await(long timeout, TimeUnit unit)");
        System.out.println("3. 可以重用，适合多阶段任务同步");
        System.out.println("4. 如果某个线程被中断或超时，会抛出 BrokenBarrierException");
    }

    /**
     * 练习12：Semaphore
     * 任务：使用Semaphore控制并发数量
     */
    public static void practice12_Semaphore() {
        System.out.println("\n=== 练习12：Semaphore ===");
        
        // TODO: 使用Semaphore
        // 场景：控制同时访问资源的线程数量
        
        int permits = 3; // 允许3个线程同时访问
        Semaphore semaphore = new Semaphore(permits);



        for (int i = 0; i < 10; i++) {
            
            new Thread(()->{

                try{
                    System.out.println(Thread.currentThread().getName()+"申请资源");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"拿到资源 开始执行");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"执行完成 释放资源");
                    semaphore.release();


                }catch(Exception e){
                    e.printStackTrace();
                }

            }).start();

        }

        
        // for (int i = 0; i < 10; i++) {
        //     new Thread(() -> {
        //         try {
        //             semaphore.acquire(); // 获取许可
        //             // 访问资源
        //             semaphore.release(); // 释放许可
        //         } catch (InterruptedException e) {
        //             e.printStackTrace();
        //         }
        //     }).start();
        // }
    }

    /**
     * 练习13：并发集合
     * 任务：了解并发集合的使用
     */
    public static void practice13_ConcurrentCollections() {
        System.out.println("\n=== 练习13：并发集合 ===");

        // 1. ConcurrentHashMap 示例
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        Runnable mapTask = () -> {
            for (int i = 0; i < 5; i++) {
                String key = Thread.currentThread().getName() + "-key" + i;
                map.put(key, i);
                System.out.println(Thread.currentThread().getName() + " put: " + key + " -> " + i);
            }
        };

        Thread t1 = new Thread(mapTask, "T1");
        Thread t2 = new Thread(mapTask, "T2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ConcurrentHashMap内容：" + map);

        // 2. CopyOnWriteArrayList 示例
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        Runnable listTask = () -> {
            for (int i = 0; i < 3; i++) {
                String value = Thread.currentThread().getName() + "-val" + i;
                list.add(value);
                System.out.println(Thread.currentThread().getName() + " add: " + value);
            }
        };

        Thread t3 = new Thread(listTask, "T3");
        Thread t4 = new Thread(listTask, "T4");
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CopyOnWriteArrayList内容：" + list);

        // 3. BlockingQueue 示例
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);
        Runnable producer = () -> {
            for (int i = 0; i < 5; i++) {
                String value = "item-" + i;
                try {
                    queue.put(value);
                    System.out.println(Thread.currentThread().getName() + " put: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable consumer = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    String value = queue.take();
                    System.out.println(Thread.currentThread().getName() + " take: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread prodThread = new Thread(producer, "Producer");
        Thread consThread = new Thread(consumer, "Consumer");
        prodThread.start();
        consThread.start();
        try {
            prodThread.join();
            consThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 4. 说明并发集合的线程安全性
        System.out.println("并发集合如ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue能保证多线程环境下的数据一致性和线程安全。适用于多线程操作共享数据的场景。");
    }

    /**
     * 练习14：综合练习
     * 任务：实现一个多线程下载器
     * 
     * 实现思路：
     * 1. 将文件分成多个部分（分片）
     * 2. 每个线程下载一个部分
     * 3. 使用CountDownLatch等待所有线程完成
     * 4. 合并下载的文件
     */
    public static void practice14_MultiThreadDownloader() {
        System.out.println("\n=== 练习14：多线程下载器 ===");
        
        // 模拟文件信息
        String fileName = "large_file.dat";
        long fileSize = 1024 * 1024; // 1MB，模拟文件大小
        int threadCount = 4; // 使用4个线程下载
        
        System.out.println("文件：" + fileName);
        System.out.println("文件大小：" + fileSize + " 字节");
        System.out.println("下载线程数：" + threadCount);
        
        // 1. 将文件分成多个部分
        long chunkSize = fileSize / threadCount;
        long lastChunkSize = fileSize - (chunkSize * (threadCount - 1)); // 最后一个分片可能大小不同
        
        System.out.println("\n文件分片信息：");
        for (int i = 0; i < threadCount; i++) {
            long start = i * chunkSize;
            long size = (i == threadCount - 1) ? lastChunkSize : chunkSize;
            long end = start + size - 1;
            System.out.println("分片 " + (i + 1) + ": 字节范围 [" + start + " - " + end + "], 大小: " + size);
        }
        
        // 2. 使用CountDownLatch等待所有线程完成
        CountDownLatch latch = new CountDownLatch(threadCount);
        
        // 存储每个线程下载的数据（实际应用中会写入临时文件）
        byte[][] downloadedChunks = new byte[threadCount][];
        
        // 3. 使用线程池管理下载线程
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        
        long startTime = System.currentTimeMillis();
        
        // 4. 每个线程下载一个部分
        for (int i = 0; i < threadCount; i++) {
            final int chunkIndex = i;
            final long chunkStart = i * chunkSize;
            final long chunkEnd = (i == threadCount - 1) 
                ? chunkStart + lastChunkSize - 1 
                : chunkStart + chunkSize - 1;
            final long currentChunkSize = (i == threadCount - 1) ? lastChunkSize : chunkSize;
            
            executor.submit(() -> {
                try {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " 开始下载分片 " + (chunkIndex + 1) + 
                                     " [字节 " + chunkStart + " - " + chunkEnd + "]");
                    
                    // 模拟下载过程（实际应用中这里会进行网络IO）
                    byte[] chunk = new byte[(int)currentChunkSize];
                    // 模拟下载时间，每个分片下载时间略有不同
                    int downloadTime = 1000 + (int)(Math.random() * 1000);
                    Thread.sleep(downloadTime);
                    
                    // 模拟填充数据（实际应用中是从网络读取）
                    for (int j = 0; j < chunk.length; j++) {
                        chunk[j] = (byte)(chunkIndex * 10 + (j % 10));
                    }
                    
                    downloadedChunks[chunkIndex] = chunk;
                    
                    System.out.println(threadName + " 完成下载分片 " + (chunkIndex + 1) + 
                                     " (大小: " + currentChunkSize + " 字节, 耗时: " + downloadTime + "ms)");
                    
                } catch (InterruptedException e) {
                    System.err.println("线程 " + chunkIndex + " 被中断");
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    System.err.println("线程 " + chunkIndex + " 下载失败: " + e.getMessage());
                    e.printStackTrace();
                } finally {
                    // 完成一个分片，计数器减1
                    latch.countDown();
                }
            });
        }
        
        // 5. 等待所有下载线程完成
        try {
            System.out.println("\n等待所有下载线程完成...");
            latch.await(); // 阻塞直到所有线程完成
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;
            
            System.out.println("\n所有分片下载完成！总耗时: " + totalTime + "ms");
            
            // 6. 合并下载的文件
            System.out.println("\n开始合并文件...");
            byte[] mergedFile = new byte[(int)fileSize];
            int offset = 0;
            
            for (int i = 0; i < threadCount; i++) {
                if (downloadedChunks[i] != null) {
                    System.arraycopy(downloadedChunks[i], 0, mergedFile, offset, downloadedChunks[i].length);
                    offset += downloadedChunks[i].length;
                    System.out.println("已合并分片 " + (i + 1));
                }
            }
            
            System.out.println("\n文件合并完成！");
            System.out.println("最终文件大小: " + mergedFile.length + " 字节");
            System.out.println("下载位置: ./" + fileName);
            
            // 验证文件完整性（简单示例）
            boolean isValid = mergedFile.length == fileSize;
            System.out.println("文件完整性验证: " + (isValid ? "✓ 通过" : "✗ 失败"));
            
        } catch (InterruptedException e) {
            System.err.println("等待下载完成时被中断");
            Thread.currentThread().interrupt();
        } finally {
            // 关闭线程池
            executor.shutdown();
            try {
                if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
        
        System.out.println("\n多线程下载器要点总结：");
        System.out.println("1. 文件分片：将大文件分成多个小部分，提高下载效率");
        System.out.println("2. 线程池：使用ExecutorService管理下载线程");
        System.out.println("3. CountDownLatch：同步等待所有下载线程完成");
        System.out.println("4. 数据合并：将所有分片按顺序合并成完整文件");
        System.out.println("5. 异常处理：确保即使某个线程失败，也能正确处理");
    }

    // 测试方法
    public static void main(String[] args) {
        //practice1_Thread();
        // practice2_RunnableBasics();
        // practice3_ThreadBasics();
        // practice4_synchronized();
        // practice5_ReentrantLock();
        // practice6_WaitNotify();
        practice8_ThreadPool();
        practice9_CallableFuture();
        practice10_CountDownLatch();
        practice11_CyclicBarrier();
        // practice12_Semaphore();
        practice13_ConcurrentCollections();
    }
}

