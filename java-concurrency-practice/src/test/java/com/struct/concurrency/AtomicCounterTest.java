package com.struct.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;

public class AtomicCounterTest {

    @Test
    public void atomicCounterShouldReachExpectedValue() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);

        int threads = 4;
        int loops = 10_000;

        Thread[] workers = new Thread[threads];
        for (int i = 0; i < threads; i++) {
            workers[i] = new Thread(() -> {
                for (int j = 0; j < loops; j++) {
                    counter.incrementAndGet();
                }
            });
        }

        for (Thread t : workers) {
            t.start();
        }
        for (Thread t : workers) {
            t.join();
        }

        Assert.assertEquals(threads * loops, counter.get());
    }
}
