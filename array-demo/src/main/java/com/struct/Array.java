package com.struct;

import org.junit.Assert;

public class Array {

    private int[] data;

    private int size;

    private int count;


    public Array(int size) {
        this.size = size;
        this.data = new int[size];
        this.count = 0;
    }

    public void insert(int value,int index) {
        if (count == size) {
            System.out.println("Array is full");
            throw new RuntimeException("Array is full");
        }
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        count++;
    }


    public void delete(int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        }

        for (int i = index+1; i < count; i++) {
            data[i-1] = data[i];
        }
        count--;
    }

    public int findIndex(int index){
        if (index < 0 || index > size) {
            throw new RuntimeException("Index out of bounds");
        }
        return data[index];
    }

    public void display() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Array a = new Array(10);
        a.insert(0,0);
        a.insert(1, 1);
        a.insert(2, 2);
        a.insert(3, 3);
        a.insert(4, 4);
        a.display();
        Assert.assertEquals(4, a.findIndex(4));
        a.insert(11, 5);
        a.display();
        a.delete(0);
        a.display();


    }



}
