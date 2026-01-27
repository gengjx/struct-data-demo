package com.struct;

import java.util.Arrays;

/**
 * 堆排序实现
 * 堆：是一个完全二叉树 堆的种类分为大根堆和小根堆
 * 堆排序的实现思路：堆数据建大根堆，将最大的数据和最后一个数据交换位置，重新建堆，一次类推
 */
public class HeapSort {


    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,7,6,8,9,10};
        System.out.printf("排序前："+Arrays.toString(arr));
        heapSort(arr);
        System.out.printf("堆排序后："+Arrays.toString(arr));


    }

    static void heapSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        // 1、建堆
        buildHeap(arr);

        // 2、排序
        int k = arr.length - 1;
        while (k > 0) {
            // 将堆顶元素（最大）与最后一个元素交换位置
            swap(arr, 0, k);
            // 将剩下元素重新堆化，堆顶元素变成最大元素
            heapify(arr, --k, 0);
        }
    }

    /**
     * 将数组堆化，从最后一个叶子节点依次堆化到根节点
     * @param arr
     */
    static void buildHeap(int[] arr) {
        int len = arr.length -1;
        for (int i = len/2; i >= 0; i--) {
            heapify(arr, arr.length-1, i);
        }
    }


    /**
     * 堆化
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }

    /**
     * 交换数组位置
     * @param arr
     * @param i
     * @param j
     */
    static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
