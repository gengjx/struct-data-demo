package com.struct;

import java.lang.reflect.Array;import java.util.Arrays; /**
 * 堆排序实现
 * 堆：是一个完全二叉树 堆的种类分为大根堆和小根堆
 * 堆排序的实现思路：堆数据建大根堆，将最大的数据和最后一个数据交换位置，重新建堆，一次类推
 */
public class HeapSort {


    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        buildHeap(arr);
        System.out.printf("堆化后："+Arrays.toString(arr));

    }

    static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        //建堆
        buildHeap(arr);
        //排序
        int len = arr.length -1;

        while (len > 0) {
            //交换位置
            swap(arr,0,len);
            //堆化
            heapify(arr,len--,0);
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
     *
     * @param arr 要堆化的数组
     * @param len 最后堆的下标
     * @param index 要堆化的数组下标
     */
    static void heapify(int[] arr,int len,int index) {

        while (true) {
            int maxIndex = index;
            int leftChild = 2*index+1;
            int rightChild = 2*index+2;
            if (leftChild < len && arr[leftChild] > arr[maxIndex]) {
                maxIndex = leftChild;
            }
            if (rightChild < len && arr[rightChild] > arr[maxIndex]) {
                maxIndex = rightChild;
            }
            if (maxIndex == index) {
                break;
            }
            swap(arr,index,maxIndex);
            index = maxIndex;
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
