package com.struct;


import java.util.Arrays;

//归并排序
public class MergeSort {


    /**
     * 冒泡排序 ，使用分zhi思想
     * @param arr
     */
    public static void mergeSort(int[] arr) {

        mergeSortInternally(arr,0,arr.length-1);

    }

    private static void mergeSortInternally(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;

        mergeSortInternally(arr, p, q);
        mergeSortInternally(arr, q + 1, r);
        merge(arr,p,q,r);


    }

    public static void main(String[] args) {

            int [] arr = {1,2,3,4,5,6,7,8,9,0,11};
            mergeSort(arr);
            System.out.println(Arrays.toString(arr));

     }


     static void  merge(int [] arr, int p, int q, int r) {

        int [] tmp = new int[r-p+1];

        int i = p;

        int j = q+1;

        int k = 0;

        while(i <= q && j <= r) {

            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            }else {
                tmp[k++] = arr[j++];
            }
        }

        while(i <= q) {
            tmp[k++] = arr[i++];
        }
        while(j <= r) {
            tmp[k++] = arr[j++];
        }

        int start = p;
        for (int x = 0; x < tmp.length; x++) {
            arr[start++] = tmp[x];
        }
     }


}
