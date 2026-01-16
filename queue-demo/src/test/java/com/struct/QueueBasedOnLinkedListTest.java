package com.struct;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * 单元测试：{@link QueueBasedOnLinkedList}
 */
public class QueueBasedOnLinkedListTest {

    @Test
    public void testEnqueueAndDequeueInOrder() {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testDequeueFromEmptyShouldThrow() {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        try {
            queue.dequeue();
            fail("Expected RuntimeException when dequeue from empty linked-list queue");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testHeadAndTailAfterEnqueue() {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.getHead());
        assertEquals(30, queue.getTail());
    }

    @Test
    public void testHeadAndTailAfterDequeueToEmpty() {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(5);

        assertEquals(5, queue.dequeue());

        // 再次出队应抛异常，说明 head / tail 已被重置为 null
        try {
            queue.dequeue();
            fail("Expected RuntimeException when dequeue from empty queue after removing last element");
        } catch (RuntimeException e) {
            // expected
        }
    }

    @Test
    public void testPrintDoesNotThrow() {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // 仅验证不会抛异常
        queue.print();
    }
}


