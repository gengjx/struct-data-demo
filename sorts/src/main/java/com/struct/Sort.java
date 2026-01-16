package com.struct;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 排序算法
 */
public class Sort {


    /*
        冒泡排序
        比较相邻的元素，如果第一个元素比第二个元素大，就交换他们两个。
        对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。
        这步做完后，最后的元素会是最大的数。
        针对所有的元素重复以上的步骤，除了最后一个。
        持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
        时间复杂度：O(n^2)
        空间复杂度：O(1)
        稳定性：稳定
        适用场景：适用于小规模数据的排序
        
    */
    public static void bubbleSort(int []a){
        boolean flag = false;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a.length - i - 1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    /*
        插入排序
        将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
        从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
        时间复杂度：O(n^2)
        空间复杂度：O(1)
        稳定性：稳定
        适用场景：适用于小规模数据的排序
    */
    public static void insertSort(int []a){
        for(int i = 1; i < a.length; i++){
            int value = a[i];
            int j = i - 1;
            for(; j >= 0; j--){
                if(a[j]>value){
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            a[j+1] = value;
        }

    }


    /**
     * 选择排序
     * 每次从未排序序列中选择最小（或最大）元素放到已排序序列的末尾。
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定（相等元素可能交换）
     * 适用场景：适合元素较少且对稳定性要求不高的场景
     */
    public static void selectSort(int[] a) {
        // 外层遍历未排序部分的每个元素
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            // 在未排序区间[i+1, a.length)中寻找最小元素的下标
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            // 只有当最小元素不是当前位置才交换，减少不必要的交换操作
            if (i != minIndex) {
                int tmp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = tmp; 
            }
        }
    }
    

    


    public static void main(String[] args) {
        int []a = {1,3,2,4,5};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));

        insertSort(a);
        System.out.println(Arrays.toString(a));

        selectSort(a);
        System.out.println(Arrays.toString(a));

    }

}
