package com.struct.practice;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 线性结构练习
 * 练习内容：
 * 1. 数组操作
 * 2. 链表（单链表、双链表、循环链表）
 * 3. 栈（数组实现、链表实现）
 * 4. 队列（普通队列、循环队列、双端队列、优先队列）
 */
public class LinearStructurePractice {

    /**
     * 练习1：数组操作
     * 任务：实现数组的增删改查
     */
    public static class DynamicArray {
        private int[] data;
        private int size;
        private int capacity;

        public DynamicArray(int initialCapacity) {
            this.capacity = initialCapacity;
            this.data = new int[capacity];
            this.size = 0;
        }

        // TODO: 实现添加元素
        public void add(int element) {
            // 如果数组已满，需要扩容
            if (size == capacity) {
                resize();
            }
            // 将元素添加到数组末尾
            // size++
            data[size++] = element;
        }

        // TODO: 实现在指定位置插入元素
        public void insert(int index, int element) {
            // 检查索引是否有效
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException();
            }
            // 如果数组已满，需要扩容
            if (size == capacity) {
                resize();
            }
            // 将index及之后的元素后移
            for (int i = size; i > 0; i--) {
                data[i] = data[i - 1];
            }
            // 在index位置插入element
            // size++
            data[index] = element;
            size++;
        }

        // TODO: 实现删除指定位置的元素
        public int remove(int index) {
            // 检查索引是否有效
            // 保存要删除的元素
            // 将index之后的元素前移
            // size--
            // 返回删除的元素
            return 0;
        }

        // TODO: 实现查找元素
        public int indexOf(int element) {
            // 遍历数组查找元素
            int index = 0;
            for (; index <= size; index++) {
                if (data[index] == element) {
                    return index;
                }
            }
            // 找到返回索引，未找到返回-1
            return -1;
        }

        // TODO: 实现获取指定位置的元素
        public int get(int index) {
            // 检查索引是否有效
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            // 返回指定位置的元素
            return data[index];
        }

        // TODO: 实现数组扩容
        private void resize() {
            // 创建新数组，容量为原来的2倍
            int [] newData = new int[data.length * 2];
            // 将原数组元素复制到新数组
            System.arraycopy(data, 0, newData, 0, data.length);
            // 更新capacity和data引用
            data = newData;
            this.capacity = data.length;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    /**
     * 练习2：单链表
     * 任务：实现单链表的基本操作
     */
    public static class SinglyLinkedList {
        private Node head;
        private int size;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public SinglyLinkedList() {
            this.head = null;
            this.size = 0;
        }

        // TODO: 在链表头部添加节点
        public void addFirst(int data) {
            // 创建新节点
            Node node = new Node(data);
            if (head == null) {
                head = node;
            }else {
                // 新节点的next指向head
                // head指向新节点
                node.next = head.next;
                head.next = node;
            }
            // size++
            size++;
        }

        // TODO: 在链表尾部添加节点
        public void addLast(int data) {
            // 创建新节点
            Node node = new Node(data);
            // 如果链表为空，head指向新节点
            if (head == null) {
                head = node;
            }else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = node;
            }
            size++;
            // 否则找到最后一个节点，将其next指向新节点
            // size++
        }

        public void print() {
            Node node = head;
            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.println();
        }

        // TODO: 在指定位置插入节点
        public void insert(int index, int data) {
            // 检查索引是否有效
            // 如果index为0，调用addFirst
            // 否则找到index-1位置的节点
            // 创建新节点，插入到index位置
            // size++
        }

        // TODO: 删除指定位置的节点
        public int remove(int index) {
            // 检查索引是否有效
            // 如果index为0，删除头节点
            // 否则找到index-1位置的节点
            // 删除index位置的节点
            // size--
            // 返回删除节点的数据
            return 0;
        }

        // TODO: 查找元素
        public int indexOf(int data) {
            // 从头节点开始遍历
            // 找到返回索引，未找到返回-1
            return -1;
        }

        // TODO: 获取指定位置的元素
        public int get(int index) {
            // 检查索引是否有效
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            // 遍历到index位置
            Node node = head;
            int i = 0;
            while (node != null) {
                if (i++ == index) {
                    return node.data;
                }
                node = node.next;
            }
            // 返回节点的数据
            return -1;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // TODO: 反转链表
        public void reverse() {
            // 使用三个指针：prev, current, next
            // 遍历链表，反转每个节点的next指针
        }
    }

    /**
     * 练习3：双链表
     * 任务：实现双链表的基本操作
     */
    public static class DoublyLinkedList {
        private Node head;
        private Node tail;
        private int size;

        private static class Node {
            int data;
            Node prev;
            Node next;

            Node(int data) {
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        // TODO: 在头部添加节点
        public void addFirst(int data) {
            // 创建新节点
            // 如果链表为空，head和tail都指向新节点
            // 否则，新节点的next指向head，head的prev指向新节点，head指向新节点
            // size++
        }

        // TODO: 在尾部添加节点
        public void addLast(int data) {
            // 创建新节点
            // 如果链表为空，head和tail都指向新节点
            // 否则，tail的next指向新节点，新节点的prev指向tail，tail指向新节点
            // size++
        }

        // TODO: 删除指定位置的节点
        public int remove(int index) {
            // 检查索引是否有效
            // 找到index位置的节点
            // 更新前驱和后继节点的指针
            // size--
            // 返回删除节点的数据
            return 0;
        }

        public int size() {
            return size;
        }
    }

    /**
     * 练习4：栈（数组实现）
     * 任务：使用数组实现栈
     */
    public static class ArrayStack {
        private int[] data;
        private int top;
        private int capacity;

        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.top = -1;
        }

        // TODO: 入栈
        public void push(int element) {
            // 检查栈是否已满
            // top++，将元素放入data[top]
        }

        // TODO: 出栈
        public int pop() {
            // 检查栈是否为空
            // 返回data[top]，top--
            return 0;
        }

        // TODO: 查看栈顶元素
        public int peek() {
            // 检查栈是否为空
            // 返回data[top]，不改变top
            return 0;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == capacity - 1;
        }
    }

    /**
     * 练习5：栈（链表实现）
     * 任务：使用链表实现栈
     */
    public static class LinkedStack {
        private Node top;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public LinkedStack() {
            this.top = null;
        }

        // TODO: 入栈
        public void push(int element) {
            // 创建新节点
            // 新节点的next指向top
            // top指向新节点
        }

        // TODO: 出栈
        public int pop() {
            // 检查栈是否为空
            // 保存top的数据
            // top指向top.next
            // 返回保存的数据
            return 0;
        }

        // TODO: 查看栈顶元素
        public int peek() {
            // 检查栈是否为空
            // 返回top的数据
            return 0;
        }

        public boolean isEmpty() {
            return top == null;
        }
    }

    /**
     * 练习6：队列（数组实现）
     * 任务：使用数组实现队列
     */
    public static class ArrayQueue {
        private int[] data;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public ArrayQueue(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.front = 0;
            this.rear = -1;
            this.size = 0;
        }

        // TODO: 入队
        public void enqueue(int element) {
            // 检查队列是否已满
            // rear = (rear + 1) % capacity
            // data[rear] = element
            // size++
        }

        // TODO: 出队
        public int dequeue() {
            // 检查队列是否为空
            // 保存data[front]
            // front = (front + 1) % capacity
            // size--
            // 返回保存的数据
            return 0;
        }

        // TODO: 查看队首元素
        public int peek() {
            // 检查队列是否为空
            // 返回data[front]
            return 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    /**
     * 练习7：双端队列
     * 任务：实现双端队列
     */
    public static class Deque {
        private int[] data;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public Deque(int capacity) {
            this.capacity = capacity;
            this.data = new int[capacity];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        // TODO: 在头部添加元素
        public void addFirst(int element) {
            // 检查队列是否已满
            // front = (front - 1 + capacity) % capacity
            // data[front] = element
            // size++
        }

        // TODO: 在尾部添加元素
        public void addLast(int element) {
            // 检查队列是否已满
            // data[rear] = element
            // rear = (rear + 1) % capacity
            // size++
        }

        // TODO: 删除头部元素
        public int removeFirst() {
            // 检查队列是否为空
            // 保存data[front]
            // front = (front + 1) % capacity
            // size--
            // 返回保存的数据
            return 0;
        }

        // TODO: 删除尾部元素
        public int removeLast() {
            // 检查队列是否为空
            // rear = (rear - 1 + capacity) % capacity
            // 返回data[rear]
            // size--
            return 0;
        }
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 线性结构练习 ===");
        
        // 测试动态数组
        System.out.printf("动态数组练习：");
        DynamicArray array = new DynamicArray(10);
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.printf("打印数组："+ Arrays.toString(array.data));
        array.insert(1, 4);
        System.out.printf("打印数组："+Arrays.toString(array.data));
        // TODO: 测试数组的各种操作
        int k = 5;
        for (int i = k; i < 20; i++) {
            array.add(i);
        }
        System.out.printf("扩容后数组："+Arrays.toString(array.data));
        //查找元素
        Assert.assertEquals(2L,array.indexOf(2));
        System.out.println();
        // 测试单链表
        SinglyLinkedList list = new SinglyLinkedList();
        // TODO: 测试链表的各种操作
        System.out.println("链表练习：【单链表 双联表 循环链表】");
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(4);
        list.print();
        Assert.assertEquals(4L,list.get(1));

        // 测试栈
        ArrayStack stack = new ArrayStack(10);
        // TODO: 测试栈的各种操作
        
        // 测试队列
        ArrayQueue queue = new ArrayQueue(10);
        // TODO: 测试队列的各种操作
    }
}

