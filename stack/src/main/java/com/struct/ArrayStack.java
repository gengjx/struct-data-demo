package com.struct;

import org.junit.Assert;

import java.util.EmptyStackException;

/**
 * 给予代码实现栈
 */
public class ArrayStack {

    /**
     * 栈数组
     */
    private int[] stack;

    /**
     * 栈目前的个数
     */
    private int count;

    /**
     * 栈总数
     */
    private int capacity;


    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        count = 0;
    }

    public ArrayStack() {
        this(10);
    }


    private void push(int value) {
        if(count == capacity) {
           // throw new StackOverflowError();
            resize(capacity *2);
        }
        stack[count++] = value;
    }

    private void resize(int i) {
        int[] temp = new int[capacity*2];
        System.arraycopy(stack, 0, temp, 0, count);
        stack = temp;
        capacity = capacity*2;
    }

    private void pop() {
        if(count == 0) {
            throw new EmptyStackException();
        }
        stack[--count] = 0;
    }

    private int getTop(){
        if(count == 0) {
            throw new EmptyStackException();
        }
        return stack[count-1];
    }

    private int getCapacity(){
        return capacity;
    }

    private void print() {
        for (int i = count; i > 0; i--) {
            System.out.print(stack[i-1] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();
        Assert.assertEquals(3, stack.getTop());
        stack.pop();
        stack.print();
        Assert.assertEquals(2, stack.getTop());
        stack.push(3);
        stack.print();
        Assert.assertEquals(3, stack.getTop());
        stack.push(4);
        stack.print();
        Assert.assertEquals(6, stack.getCapacity());

    }




}
