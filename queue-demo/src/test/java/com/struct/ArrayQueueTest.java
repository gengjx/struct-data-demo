package com.struct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 单元测试：{@link ArrayQueue}
 */
public class ArrayQueueTest {

    @Test
    public void testEnqueueAndDequeueInOrder() {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testDequeueFromEmptyShouldThrow() {
        ArrayQueue queue = new ArrayQueue(3);
        try {
            queue.dequeue();
            fail("Expected RuntimeException when dequeue from empty queue");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testQueueFullShouldThrowOnEnqueue() {
        ArrayQueue queue = new ArrayQueue(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        try {
            queue.enqueue(40);
            fail("Expected RuntimeException when enqueue to full queue");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testGetHeadAndTail() {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        // 当前 head 指向 5，tail 指向下一个要插入的位置，getTail() 期望获取最后一个元素
        assertEquals(5, queue.getHead());
        assertEquals(7, queue.getTail());
    }

    @Test
    public void testPrintDoesNotThrow() {
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // 仅验证不会抛异常
        queue.print();
    }
}



