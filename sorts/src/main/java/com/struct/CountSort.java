package com.struct;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int []d = {2, 5, 3, 0, 2, 3, 0, 3};
        System.out.println("计数排序前: " + Arrays.toString(d));
        countSort(d);
        System.out.println("计数排序后: " + Arrays.toString(d));
    }


    public static void countSort(int[] arr) {

        if (arr == null || arr.length <= 1) {
            return;
        }


        int length = arr.length;

        int max = arr[0];

        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }


        int [] arrIndex = new int [max+1];


        for (int i = 0; i < length; i++) {
            arrIndex[arr[i]]++;
        }


        for (int i = 1; i < max + 1; i++) {
            arrIndex[i] = arrIndex[i-1] + arrIndex[i];
        }

        System.out.println("<UNK>: " + Arrays.toString(arrIndex));
        int [] temp = new int[arr.length];

        for (int i = arr.length -1; i >=0; i--) {
            int value = arr[i];
            int index = arrIndex[value]--;
            System.out.println(value + " : " + index);
            temp[index-1] = value;

        }


        for (int i = 0; i < arr.length; ++i) {
            arr[i] = temp[i];
        }





    }
}
