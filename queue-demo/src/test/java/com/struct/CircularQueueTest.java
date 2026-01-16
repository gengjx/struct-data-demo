package com.struct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 单元测试：{@link CircularQueue}
 */
public class CircularQueueTest {

    @Test
    public void testEnqueueAndDequeueInOrder() {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testDequeueFromEmptyShouldThrow() {
        CircularQueue queue = new CircularQueue(3);
        try {
            queue.dequeue();
            fail("Expected RuntimeException when dequeue from empty queue");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testQueueFullShouldThrowOnEnqueue() {
        // 由于循环队列预留一个空位，capacity=3 时最多只能放 2 个元素
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(10);
        queue.enqueue(20);

        try {
            queue.enqueue(30);
            fail("Expected RuntimeException when enqueue to full circular queue");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testWrapAroundBehavior() {
        // 测试 head、tail 环绕时的入队出队顺序
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(1, queue.dequeue());

        // 此时 head 已经向前移动，再入队一个元素，tail 应该环绕
        queue.enqueue(3);

        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testGetHeadAndTail() {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(5, queue.getHead());
        assertEquals(7, queue.getTail());
    }

    @Test
    public void testPrintDoesNotThrow() {
        CircularQueue queue = new CircularQueue(4);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // 仅验证不会抛异常
        queue.print();
    }
}


