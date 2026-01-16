package com.struct;

/**
 * 循环队列
 */
public class CircularQueue {

    /**
     * 队列容量
     */
    private int capacity;

    /**
     * 队列元素
     */
    private int[] items;

    /**
     * 队列头指针
     */

    /**
     * 队列尾指针
     */
    private int head;

    private int tail;


    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
        this.head = 0;
        this.tail = 0;
    }

    public CircularQueue() {
        this(10);
    }

    public void enqueue(int item) {

        if((tail + 1) % capacity == head) {
            throw new RuntimeException("Queue is full");
        }
        items[tail] = item;
        tail = (tail + 1) % capacity;
    }

    public int dequeue() {
        if(head == tail) {
            throw new RuntimeException("Queue is empty");
        }
        int item = items[head];
        head = (head + 1) % capacity;
        return item;
    }

    public int getHead() {
        return items[head];
    }

    public int getTail() {
        return items[tail-1];
    }
    
    public void print() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
