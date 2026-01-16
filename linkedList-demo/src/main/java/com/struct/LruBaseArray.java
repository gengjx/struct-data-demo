package com.struct;

import java.util.HashMap;

public class LruBaseArray<T> {
    //数据数组
    private T[] array;

    //数据个数
    private int size;

    //数据容量
    private int capacity;

    //hash索引
    private HashMap<T,Integer> hashIndex;



    public LruBaseArray(int capacity) {
        this.array = (T[]) new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.hashIndex = new HashMap<>(capacity);
    }

    public LruBaseArray() {
        this(10);
    }


    public void offer(T value) {
        
        Integer index = hashIndex.get(value);
        if(index != null){
            update(index,value);
        }else{
            if(isFull()){
                removeAndCache(value);
            }else{
                cache(value,this.size);
            }

        }
       
      

    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString();
    }

    private void cache(T value,int end) {
       
        rigthShift(end);
        array[0] = value;
        this.hashIndex.put(value, 0);
        this.size++;

    }

    private void removeAndCache(T value) {
        T last = array[--size];
        this.hashIndex.remove(last);
        cache(value,this.size);
    }

    private void update(Integer index, T value) {

        rigthShift(index);
        array[0] = value;
        this.hashIndex.put(value, 0);
    }

    private void rigthShift(Integer index) {
      for (int i = index; i > 0; i--) {
        array[i] = array[i-1];
        hashIndex.put(array[i], i);
      }
    }

    private boolean isFull() {
        return size >= capacity;
    }


    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
//            testWithException();
        }

        private static void testWithException() {
            LruBaseArray<Integer> lru = new LruBaseArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LruBaseArray<Integer> lru = new LruBaseArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LruBaseArray<Integer> lru = new LruBaseArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}
