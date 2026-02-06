package com.struct.concurrency;

import com.struct.concurrency.demo.AtomicCounterDemo;
import com.struct.concurrency.demo.CompletableFutureDemo;
import com.struct.concurrency.demo.CountDownLatchDemo;
import com.struct.concurrency.demo.ExecutorServiceDemo;
import com.struct.concurrency.demo.ReentrantLockCounterDemo;
import com.struct.concurrency.demo.SynchronizedCounterDemo;
import com.struct.concurrency.demo.ThreadCreationDemo;
import com.struct.concurrency.demo.ThreadLocalDemo;

public class ConcurrencyLearningApp {

    public static void main(String[] args) throws Exception {
        if (args == null || args.length == 0) {
            printUsage();
            return;
        }

        String command = args[0];
        switch (command) {
            case "thread":
                ThreadCreationDemo.run();
                break;
            case "sync":
                SynchronizedCounterDemo.run();
                break;
            case "lock":
                ReentrantLockCounterDemo.run();
                break;
            case "atomic":
                AtomicCounterDemo.run();
                break;
            case "executor":
                ExecutorServiceDemo.run();
                break;
            case "future":
                CompletableFutureDemo.run();
                break;
            case "latch":
                CountDownLatchDemo.run();
                break;
            case "threadlocal":
                ThreadLocalDemo.run();
                break;
            default:
                printUsage();
        }
    }

    private static void printUsage() {
        System.out.println("Usage: run with an argument:");
        System.out.println("  thread       - Thread creation demo (platform + virtual)");
        System.out.println("  sync         - synchronized counter demo");
        System.out.println("  lock         - ReentrantLock counter demo");
        System.out.println("  atomic       - AtomicInteger counter demo");
        System.out.println("  executor     - ExecutorService demo");
        System.out.println("  future       - CompletableFuture demo");
        System.out.println("  latch        - CountDownLatch demo");
        System.out.println("  threadlocal  - ThreadLocal demo");
    }
}
