package com.struct;

import java.util.Arrays;

public class QuickSort {



    public static void quickSort(int[] arr) {

        quickSortInternally(arr,0,arr.length-1);
    }

    private static void quickSortInternally(int[] arr, int p, int r) {

        if (p>=r) return;

        int q = partition(arr,p,r);
        quickSortInternally(arr,p,q-1);
        quickSortInternally(arr,q+1,r);


    }


    //以数组左右测的值作为基准点
    private static int partition(int[] arr, int p, int r) {

        int pivot = arr[r];
        int i = p;

        for (int j = p; j < r; j++) {
            if (arr[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }


    public static void main(String[] args) {
        System.out.println("练习快速排序：选定一个基准点，把数组不断的分成两个部分，左边的数据大于，右边的数据小于");
        int[] arr = {1,2,3,4,5,6,7,8,9,10,0,11};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));


    }

}
