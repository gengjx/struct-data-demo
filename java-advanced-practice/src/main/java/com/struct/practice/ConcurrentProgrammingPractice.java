package com.struct.practice;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.List;
import java.util.ArrayList;

/**
 * 并发编程深入练习
 * 练习内容：
 * 1. 线程池原理和实现
 * 2. volatile关键字的深入理解
 * 3. synchronized的底层原理
 * 4. CAS（Compare-And-Swap）机制
 * 5. AQS（AbstractQueuedSynchronizer）框架
 * 6. 并发集合的使用
 * 7. Fork/Join框架
 */
public class ConcurrentProgrammingPractice {

    /**
     * 练习1：volatile关键字深入理解
     * 任务：理解volatile的可见性和有序性
     */
    public static void practice1_Volatile() {
        System.out.println("=== 练习1：volatile关键字 ===");
        
        // TODO: 理解volatile的两个特性
        // 1. 可见性（Visibility）
        //    - 当一个线程修改了volatile变量的值，新值对其他线程立即可见
        //    - 保证变量值直接从主内存读取，修改后立即写入主内存
        
        // 2. 有序性（Ordering）
        //    - 禁止指令重排序优化
        //    - 保证volatile变量之前的操作不会被重排序到volatile操作之后
        
        // 注意：volatile不保证原子性！
        // 例如：count++ 不是原子操作，volatile不能保证线程安全
        
        // 示例：使用volatile实现双重检查锁定
        // class Singleton {
        //     private volatile static Singleton instance;
        //     
        //     public static Singleton getInstance() {
        //         if (instance == null) {
        //             synchronized (Singleton.class) {
        //                 if (instance == null) {
        //                     instance = new Singleton();
        //                 }
        //             }
        //         }
        //         return instance;
        //     }
        // }
        
        System.out.println("请阅读注释，理解volatile的特性");
    }

    /**
     * 练习2：volatile可见性验证
     * 任务：通过代码验证volatile的可见性
     */
    public static void practice2_VolatileVisibility() {
        System.out.println("\n=== 练习2：volatile可见性验证 ===");
        
        // TODO: 创建一个类，对比使用volatile和不使用volatile的区别
        // class SharedVariable {
        //     private volatile boolean flag = true;
        //     // private boolean flag = true;  // 不使用volatile
        //     
        //     public void setFlag(boolean flag) {
        //         this.flag = flag;
        //     }
        //     
        //     public boolean getFlag() {
        //         return flag;
        //     }
        // }
        // 
        // 创建线程1：修改flag
        // 创建线程2：读取flag
        // 观察不使用volatile时，线程2是否能看到线程1的修改
        
        System.out.println("请实现volatile可见性验证代码");
    }

    /**
     * 练习3：synchronized底层原理
     * 任务：理解synchronized的实现机制
     */
    public static void practice3_SynchronizedPrinciple() {
        System.out.println("\n=== 练习3：synchronized底层原理 ===");
        
        // TODO: 理解synchronized的实现
        // 1. 对象头（Object Header）
        //    - Mark Word：存储对象的hashCode、GC分代年龄、锁信息等
        //    - Class Metadata Address：指向类的元数据
        //    - Array Length：如果是数组，存储数组长度
        
        // 2. 锁的升级过程
        //    - 无锁状态
        //    - 偏向锁（Biased Locking）
        //      * 大多数情况下，锁总是由同一线程多次获得
        //      * 偏向锁会记录获取锁的线程ID
        //    - 轻量级锁（Lightweight Locking）
        //      * 当有多个线程竞争时，升级为轻量级锁
        //      * 使用CAS操作尝试获取锁
        //    - 重量级锁（Heavyweight Locking）
        //      * 轻量级锁竞争失败后，升级为重量级锁
        //      * 使用操作系统级别的互斥锁（Mutex Lock）
        
        // 3. synchronized的字节码
        //    - monitorenter：进入同步块
        //    - monitorexit：退出同步块
        //    - 使用javap -c查看字节码
        
        System.out.println("请阅读注释，理解synchronized的底层原理");
    }

    /**
     * 练习4：CAS机制
     * 任务：理解CAS（Compare-And-Swap）的工作原理
     */
    public static void practice4_CAS() {
        System.out.println("\n=== 练习4：CAS机制 ===");
        
        // TODO: 理解CAS的工作原理
        // CAS操作包含三个操作数：
        // - 内存位置（V）
        // - 预期原值（A）
        // - 新值（B）
        // 
        // 如果V的值等于A，则将V的值更新为B，否则不做任何操作
        // 这是一个原子操作，由CPU指令保证
        
        // Java中的CAS实现
        AtomicInteger atomicInt = new AtomicInteger(0);
        
        // CAS操作
        boolean success = atomicInt.compareAndSet(0, 1);
        System.out.println("CAS操作结果: " + success);
        System.out.println("当前值: " + atomicInt.get());
        
        // TODO: 实现一个简单的自旋锁
        // class SpinLock {
        //     private AtomicBoolean locked = new AtomicBoolean(false);
        //     
        //     public void lock() {
        //         while (!locked.compareAndSet(false, true)) {
        //             // 自旋等待
        //         }
        //     }
        //     
        //     public void unlock() {
        //         locked.set(false);
        //     }
        // }
        
        System.out.println("请实现一个简单的自旋锁");
    }

    /**
     * 练习5：CAS的ABA问题
     * 任务：理解ABA问题及其解决方案
     */
    public static void practice5_CASABAProblem() {
        System.out.println("\n=== 练习5：CAS的ABA问题 ===");
        
        // TODO: 理解ABA问题
        // ABA问题：
        // 线程1：读取A -> 准备修改为B -> 发现值还是A -> 修改成功
        // 线程2：读取A -> 修改为B -> 修改为A
        // 
        // 虽然最终值还是A，但中间过程发生了变化
        
        // 解决方案：使用版本号（Version Number）
        // Java中的AtomicStampedReference提供了带版本号的引用
        
        AtomicStampedReference<Integer> atomicRef = 
            new AtomicStampedReference<>(100, 1);
        
        int stamp = atomicRef.getStamp();
        Integer value = atomicRef.getReference();
        
        // 带版本号的CAS操作
        boolean success = atomicRef.compareAndSet(value, 200, stamp, stamp + 1);
        System.out.println("带版本号的CAS操作: " + success);
        
        System.out.println("请理解ABA问题及其解决方案");
    }

    /**
     * 练习6：AQS框架理解
     * 任务：理解AbstractQueuedSynchronizer的工作原理
     */
    public static void practice6_AQS() {
        System.out.println("\n=== 练习6：AQS框架 ===");
        
        // TODO: 理解AQS的核心概念
        // 1. 核心数据结构
        //    - state：同步状态
        //    - CLH队列：等待队列（双向链表）
        //    - Node：队列节点
        
        // 2. 核心方法
        //    - tryAcquire(int)：尝试获取独占锁
        //    - tryRelease(int)：尝试释放独占锁
        //    - tryAcquireShared(int)：尝试获取共享锁
        //    - tryReleaseShared(int)：尝试释放共享锁
        //    - acquire(int)：获取锁（会调用tryAcquire）
        //    - release(int)：释放锁（会调用tryRelease）
        
        // 3. 基于AQS的实现类
        //    - ReentrantLock：可重入锁
        //    - CountDownLatch：倒计时门闩
        //    - Semaphore：信号量
        //    - ReentrantReadWriteLock：读写锁
        
        // TODO: 实现一个简单的基于AQS的锁
        // class MyLock {
        //     private final Sync sync = new Sync();
        //     
        //     private static class Sync extends AbstractQueuedSynchronizer {
        //         @Override
        //         protected boolean tryAcquire(int arg) {
        //             if (compareAndSetState(0, 1)) {
        //                 setExclusiveOwnerThread(Thread.currentThread());
        //                 return true;
        //             }
        //             return false;
        //         }
        //         
        //         @Override
        //         protected boolean tryRelease(int arg) {
        //             if (getState() == 0) {
        //                 throw new IllegalMonitorStateException();
        //             }
        //             setExclusiveOwnerThread(null);
        //             setState(0);
        //             return true;
        //         }
        //     }
        //     
        //     public void lock() {
        //         sync.acquire(1);
        //     }
        //     
        //     public void unlock() {
        //         sync.release(1);
        //     }
        // }
        
        System.out.println("请理解AQS框架并实现一个简单的锁");
    }

    /**
     * 练习7：线程池原理理解
     * 任务：深入理解线程池的工作原理
     */
    public static void practice7_ThreadPoolPrinciple() {
        System.out.println("\n=== 练习7：线程池原理 ===");
        
        // TODO: 理解线程池的核心参数
        // 1. corePoolSize：核心线程数
        //    - 线程池中保持的线程数量（即使空闲）
        
        // 2. maximumPoolSize：最大线程数
        //    - 线程池允许的最大线程数
        
        // 3. keepAliveTime：线程空闲时间
        //    - 非核心线程的空闲时间超过该值会被回收
        
        // 4. unit：时间单位
        
        // 5. workQueue：任务队列
        //    - 用于保存等待执行的任务
        //    - 常见队列：ArrayBlockingQueue、LinkedBlockingQueue等
        
        // 6. threadFactory：线程工厂
        //    - 用于创建新线程
        
        // 7. handler：拒绝策略
        //    - AbortPolicy：直接抛出异常（默认）
        //    - CallerRunsPolicy：调用者线程执行
        //    - DiscardPolicy：直接丢弃任务
        //    - DiscardOldestPolicy：丢弃最老的任务
        
        // TODO: 理解线程池的工作流程
        // 1. 提交任务
        // 2. 如果当前线程数 < corePoolSize，创建新线程执行
        // 3. 如果当前线程数 >= corePoolSize，将任务放入队列
        // 4. 如果队列满了且线程数 < maximumPoolSize，创建新线程执行
        // 5. 如果队列满了且线程数 >= maximumPoolSize，执行拒绝策略
        
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            5,  // corePoolSize
            10, // maximumPoolSize
            60L, TimeUnit.SECONDS, // keepAliveTime
            new LinkedBlockingQueue<>(100), // workQueue
            Executors.defaultThreadFactory(), // threadFactory
            new ThreadPoolExecutor.AbortPolicy() // handler
        );
        
        System.out.println("请理解线程池的工作原理");
        executor.shutdown();
    }

    /**
     * 练习8：自定义线程池
     * 任务：实现一个简单的线程池
     */
    public static void practice8_CustomThreadPool() {
        System.out.println("\n=== 练习8：自定义线程池 ===");
        
        // TODO: 实现一个简单的线程池
        // 1. 定义一个工作队列（BlockingQueue）
        // 2. 定义一组工作线程（Worker Thread）
        // 3. 实现execute()方法提交任务
        // 4. 工作线程从队列中取任务执行
        
        // class SimpleThreadPool {
        //     private final BlockingQueue<Runnable> taskQueue;
        //     private final List<Worker> workers;
        //     
        //     public SimpleThreadPool(int poolSize, int queueSize) {
        //         this.taskQueue = new LinkedBlockingQueue<>(queueSize);
        //         this.workers = new ArrayList<>();
        //         
        //         for (int i = 0; i < poolSize; i++) {
        //             Worker worker = new Worker();
        //             workers.add(worker);
        //             worker.start();
        //         }
        //     }
        //     
        //     public void execute(Runnable task) {
        //         try {
        //             taskQueue.put(task);
        //         } catch (InterruptedException e) {
        //             Thread.currentThread().interrupt();
        //         }
        //     }
        //     
        //     private class Worker extends Thread {
        //         @Override
        //         public void run() {
        //             while (true) {
        //                 try {
        //                     Runnable task = taskQueue.take();
        //                     task.run();
        //                 } catch (InterruptedException e) {
        //                     break;
        //                 }
        //             }
        //         }
        //     }
        // }
        
        System.out.println("请实现一个简单的线程池");
    }

    /**
     * 练习9：并发集合的使用
     * 任务：掌握并发集合的特性
     */
    public static void practice9_ConcurrentCollections() {
        System.out.println("\n=== 练习9：并发集合 ===");
        
        // TODO: 了解以下并发集合
        // 1. ConcurrentHashMap
        //    - 线程安全的HashMap
        //    - 分段锁机制（Java 7）或CAS+synchronized（Java 8）
        
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("key1", 1);
        map.putIfAbsent("key1", 2); // 如果不存在则放入
        System.out.println("ConcurrentHashMap: " + map);
        
        // 2. CopyOnWriteArrayList
        //    - 写时复制的ArrayList
        //    - 适合读多写少的场景
        
        // CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        // list.add("item1");
        
        // 3. BlockingQueue接口
        //    - ArrayBlockingQueue：有界阻塞队列（数组实现）
        //    - LinkedBlockingQueue：可选有界阻塞队列（链表实现）
        //    - SynchronousQueue：同步队列，不存储元素
        //    - PriorityBlockingQueue：优先级阻塞队列
        
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        try {
            queue.put("item1");
            String item = queue.take();
            System.out.println("BlockingQueue: " + item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 4. ConcurrentLinkedQueue
        //    - 线程安全的无界非阻塞队列
    }

    /**
     * 练习10：Fork/Join框架
     * 任务：掌握Fork/Join框架的使用
     */
    public static void practice10_ForkJoin() {
        System.out.println("\n=== 练习10：Fork/Join框架 ===");
        
        // TODO: 理解Fork/Join框架
        // Fork/Join框架用于并行执行任务
        // 核心思想：分而治之（Divide and Conquer）
        
        // 1. ForkJoinPool：线程池
        // 2. ForkJoinTask：任务基类
        //    - RecursiveTask：有返回值的任务
        //    - RecursiveAction：无返回值的任务
        
        // TODO: 实现一个使用Fork/Join计算数组求和的例子
        // class SumTask extends RecursiveTask<Long> {
        //     private static final int THRESHOLD = 1000;
        //     private int[] array;
        //     private int start;
        //     private int end;
        //     
        //     public SumTask(int[] array, int start, int end) {
        //         this.array = array;
        //         this.start = start;
        //         this.end = end;
        //     }
        //     
        //     @Override
        //     protected Long compute() {
        //         if (end - start < THRESHOLD) {
        //             // 直接计算
        //             long sum = 0;
        //             for (int i = start; i < end; i++) {
        //                 sum += array[i];
        //             }
        //             return sum;
        //         } else {
        //             // 拆分任务
        //             int middle = (start + end) / 2;
        //             SumTask leftTask = new SumTask(array, start, middle);
        //             SumTask rightTask = new SumTask(array, middle, end);
        //             leftTask.fork();
        //             rightTask.fork();
        //             return leftTask.join() + rightTask.join();
        //         }
        //     }
        // }
        
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // int[] array = new int[10000];
        // SumTask task = new SumTask(array, 0, array.length);
        // Long result = forkJoinPool.invoke(task);
        
        System.out.println("请实现Fork/Join示例");
        forkJoinPool.shutdown();
    }

    /**
     * 练习11：死锁和死锁检测
     * 任务：理解死锁的产生和检测
     */
    public static void practice11_Deadlock() {
        System.out.println("\n=== 练习11：死锁 ===");
        
        // TODO: 创建死锁示例
        // 死锁产生的四个必要条件：
        // 1. 互斥条件：资源不能被多个线程同时使用
        // 2. 请求与保持条件：线程持有资源的同时请求其他资源
        // 3. 不剥夺条件：资源只能由持有者主动释放
        // 4. 环路等待条件：形成资源请求的环形链
        
        // Object lock1 = new Object();
        // Object lock2 = new Object();
        // 
        // Thread t1 = new Thread(() -> {
        //     synchronized (lock1) {
        //         try { Thread.sleep(100); } catch (InterruptedException e) {}
        //         synchronized (lock2) {
        //             System.out.println("Thread 1");
        //         }
        //     }
        // });
        // 
        // Thread t2 = new Thread(() -> {
        //     synchronized (lock2) {
        //         try { Thread.sleep(100); } catch (InterruptedException e) {}
        //         synchronized (lock1) {
        //             System.out.println("Thread 2");
        //         }
        //     }
        // });
        // 
        // t1.start();
        // t2.start();
        
        // 死锁检测：
        // 1. jstack命令：查看线程堆栈
        // 2. jvisualvm：可视化工具
        // 3. ThreadMXBean：程序化检测
        
        System.out.println("请理解死锁的产生和检测方法");
    }

    /**
     * 练习12：ThreadLocal深入理解
     * 任务：理解ThreadLocal的原理和使用场景
     */
    public static void practice12_ThreadLocal() {
        System.out.println("\n=== 练习12：ThreadLocal ===");
        
        // TODO: 理解ThreadLocal的原理
        // ThreadLocal为每个线程提供独立的变量副本
        // 实现原理：Thread类中有一个ThreadLocalMap变量
        // ThreadLocalMap的key是ThreadLocal对象，value是存储的值
        
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        
        // 设置值
        threadLocal.set("ThreadLocal Value");
        
        // 获取值
        String value = threadLocal.get();
        System.out.println("ThreadLocal值: " + value);
        
        // 移除值（重要：避免内存泄漏）
        threadLocal.remove();
        
        // 使用场景：
        // 1. 数据库连接管理
        // 2. Session管理
        // 3. 避免参数传递
        
        System.out.println("请理解ThreadLocal的原理和使用场景");
    }

    // 测试方法
    public static void main(String[] args) {
        practice1_Volatile();
        practice2_VolatileVisibility();
        practice3_SynchronizedPrinciple();
        practice4_CAS();
        practice5_CASABAProblem();
        practice6_AQS();
        practice7_ThreadPoolPrinciple();
        practice8_CustomThreadPool();
        practice9_ConcurrentCollections();
        practice10_ForkJoin();
        practice11_Deadlock();
        practice12_ThreadLocal();
    }
}

