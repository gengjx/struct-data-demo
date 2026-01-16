package com.struct;

import java.util.Arrays;

public class GenericArray<T> {

    private T[] array;

    private int size;

    private int capacity;


    public int getCapacity(){
        return capacity;
    }

    public GenericArray(int capacity) {
        array = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public GenericArray() {
        this(10);
    }


    public void addIndex(T element,int position) {
        if (position < 0 || position > capacity) {
            throw new IndexOutOfBoundsException();
        }
        array[position] = element;
    }

    public void add(T element) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        array[size++] = element;
    }

    public void remove(int index) {
        if (index < 0 || index >= capacity) {
            throw new IndexOutOfBoundsException();
        }

        for (int i = index; i < capacity-1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int findIndex(T element) {

        for (int i = 0; i < capacity; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;

    }

    public void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < capacity; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        GenericArray<Long> array = new GenericArray<Long>(10);

        array.add(1L);
        array.add(2L);
        array.add(3L);
        array.add(4L);
        array.add(5L);
        array.add(6L);
        array.add(7L);
        array.add(8L);
        array.add(9L);
        array.add(10L);
        array.add(11L);
        array.add(12L);
        array.display();
        array.remove(0);
        array.display();
        System.out.println(array.findIndex(6L));

        System.out.println(array.getCapacity());

    }

}
