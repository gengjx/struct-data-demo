package com.struct;

import java.util.Arrays;
import java.util.Comparator;

/**
 * SortImproved 使用示例
 * 
 * 演示如何使用改进版的排序工具类
 */
public class SortImprovedExample {
    
    public static void main(String[] args) {
        System.out.println("========== SortImproved 使用示例 ==========\n");
        
        // ========== 1. 基本类型排序 ==========
        System.out.println("1. 基本类型排序（int[]）:");
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("   排序前: " + Arrays.toString(arr1));
        SortImproved.bubbleSort(arr1);
        System.out.println("   排序后: " + Arrays.toString(arr1));
        System.out.println();
        
        // ========== 2. 对象类型排序（使用 Comparable） ==========
        System.out.println("2. 对象类型排序（Integer[]，使用 Comparable）:");
        Integer[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("   排序前: " + Arrays.toString(arr2));
        SortImproved.bubbleSort(arr2);
        System.out.println("   排序后: " + Arrays.toString(arr2));
        System.out.println();
        
        // ========== 3. 自定义比较器排序 ==========
        System.out.println("3. 自定义比较器排序（按字符串长度）:");
        String[] arr3 = {"banana", "apple", "cherry", "date"};
        System.out.println("   排序前: " + Arrays.toString(arr3));
        SortImproved.bubbleSort(arr3, Comparator.comparing(String::length));
        System.out.println("   排序后: " + Arrays.toString(arr3));
        System.out.println();
        
        // ========== 4. 三种排序算法对比 ==========
        System.out.println("4. 三种排序算法对比:");
        int[] arr4 = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] arr5 = {3, 1, 4, 1, 5, 9, 2, 6};
        int[] arr6 = {3, 1, 4, 1, 5, 9, 2, 6};
        
        System.out.println("   原始数组: " + Arrays.toString(arr4));
        
        SortImproved.bubbleSort(arr4);
        System.out.println("   冒泡排序: " + Arrays.toString(arr4));
        
        SortImproved.insertSort(arr5);
        System.out.println("   插入排序: " + Arrays.toString(arr5));
        
        SortImproved.selectSort(arr6);
        System.out.println("   选择排序: " + Arrays.toString(arr6));
        System.out.println();
        
        // ========== 5. 边界情况测试 ==========
        System.out.println("5. 边界情况测试:");
        
        // 空数组
        int[] empty = {};
        SortImproved.bubbleSort(empty);
        System.out.println("   空数组: " + Arrays.toString(empty) + " (正常处理)");
        
        // 单元素数组
        int[] single = {42};
        SortImproved.bubbleSort(single);
        System.out.println("   单元素: " + Arrays.toString(single) + " (正常处理)");
        
        // 已排序数组
        int[] sorted = {1, 2, 3, 4, 5};
        SortImproved.bubbleSort(sorted);
        System.out.println("   已排序: " + Arrays.toString(sorted) + " (正常处理)");
        System.out.println();
        
        // ========== 6. 异常情况演示 ==========
        System.out.println("6. 异常情况演示（参数校验）:");
        try {
            SortImproved.bubbleSort((int[]) null);
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ 正确捕获异常: " + e.getMessage());
        }
        
        try {
            SortImproved.bubbleSort((String[]) null, Comparator.naturalOrder());
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ 正确捕获异常: " + e.getMessage());
        }
        
        try {
            String[] withNull = {"a", null, "c"};
            SortImproved.bubbleSort(withNull, Comparator.naturalOrder());
        } catch (IllegalArgumentException e) {
            System.out.println("   ✅ 正确捕获 null 元素异常: " + e.getMessage());
        }
        
        System.out.println("\n========== 示例结束 ==========");
    }
}

