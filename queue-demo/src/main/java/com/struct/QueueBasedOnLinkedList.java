package com.struct;

/**
 * 基于链表实现的队列
 */
public class QueueBasedOnLinkedList {

    private Node head;
    private Node tail;

    static class Node {
        int data;
        Node next;
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public QueueBasedOnLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int data) {
        Node newNode = new Node(data, null);

        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int dequeue() {
        if(head == null) {
            throw new RuntimeException("Queue is empty");
        }
        int data = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return data;
    }

    public int getHead() {
        return head.data;
    }

    public int getTail() {
        return tail.data;
    }

    public void print() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
