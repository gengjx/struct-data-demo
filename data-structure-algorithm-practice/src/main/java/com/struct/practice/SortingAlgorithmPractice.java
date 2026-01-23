package com.struct.practice;

import java.util.Arrays;

/**
 * 排序算法练习
 * 练习内容：
 * 1. 冒泡排序
 * 2. 选择排序
 * 3. 插入排序
 * 4. 快速排序
 * 5. 归并排序
 * 6. 堆排序
 * 7. 希尔排序
 * 8. 计数排序
 * 9. 桶排序
 * 10. 基数排序
 */
public class SortingAlgorithmPractice {

    /**
     * 练习1：冒泡排序
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void bubbleSort(int[] arr) {
        // TODO: 实现冒泡排序
        // 1. 外层循环控制排序轮数
        // 2. 内层循环比较相邻元素
        // 3. 如果前一个元素大于后一个元素，交换它们
        // 4. 优化：如果一轮中没有交换，说明已经有序，可以提前结束
    }

    /**
     * 练习2：选择排序
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void selectionSort(int[] arr) {
        // TODO: 实现选择排序
        // 1. 外层循环控制当前位置
        // 2. 内层循环找到未排序部分的最小值
        // 3. 将最小值与当前位置交换
    }

    /**
     * 练习3：插入排序
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     */
    public static void insertionSort(int[] arr) {
        // TODO: 实现插入排序
        // 1. 从第二个元素开始遍历
        // 2. 将当前元素保存为key
        // 3. 将key与前面已排序的元素比较，找到合适的插入位置
        // 4. 将key插入到正确位置
    }

    /**
     * 练习4：快速排序
     * 时间复杂度：平均O(nlogn)，最坏O(n²)
     * 空间复杂度：O(logn)
     * 稳定性：不稳定
     */
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        // TODO: 实现快速排序
        // 1. 如果low >= high，返回
        // 2. 选择基准元素（pivot），进行分区
        // 3. 递归排序左半部分
        // 4. 递归排序右半部分
    }

    private static int partition(int[] arr, int low, int high) {
        // TODO: 实现分区操作
        // 1. 选择最后一个元素作为基准
        // 2. 使用两个指针i和j
        // 3. i指向小于基准的区域，j遍历数组
        // 4. 如果arr[j] < pivot，交换arr[i]和arr[j]，i++
        // 5. 最后将基准元素放到正确位置
        // 6. 返回基准元素的最终位置
        return 0;
    }

    /**
     * 练习5：归并排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * 稳定性：稳定
     */
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        // TODO: 实现归并排序
        // 1. 如果left >= right，返回
        // 2. 计算中点mid
        // 3. 递归排序左半部分
        // 4. 递归排序右半部分
        // 5. 合并两个有序数组
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        // TODO: 实现合并操作
        // 1. 创建临时数组存储左右两部分
        // 2. 比较左右两部分的元素，将较小的放入原数组
        // 3. 将剩余元素复制到原数组
    }

    /**
     * 练习6：堆排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void heapSort(int[] arr) {
        // TODO: 实现堆排序
        // 1. 构建最大堆
        // 2. 依次将堆顶元素（最大值）与末尾元素交换
        // 3. 调整堆，使其保持最大堆性质
        // 4. 重复步骤2-3，直到堆为空
    }

    private static void buildMaxHeap(int[] arr) {
        // TODO: 构建最大堆
        // 从最后一个非叶子节点开始，向上调整
    }

    private static void heapify(int[] arr, int n, int i) {
        // TODO: 调整堆
        // 1. 找到左右子节点
        // 2. 找到最大值所在的索引
        // 3. 如果最大值不是当前节点，交换并递归调整
    }

    /**
     * 练习7：希尔排序
     * 时间复杂度：O(n^1.3) - O(n²)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public static void shellSort(int[] arr) {
        // TODO: 实现希尔排序
        // 1. 选择一个增量序列（如gap = n/2, n/4, ...）
        // 2. 对每个增量，进行插入排序
        // 3. 当增量为1时，完成排序
    }

    /**
     * 练习8：计数排序
     * 时间复杂度：O(n + k)，k是数据范围
     * 空间复杂度：O(k)
     * 稳定性：稳定
     * 适用：数据范围较小的整数排序
     */
    public static void countingSort(int[] arr) {
        // TODO: 实现计数排序
        // 1. 找到数组的最大值和最小值
        // 2. 创建计数数组，大小为max - min + 1
        // 3. 统计每个元素出现的次数
        // 4. 根据计数数组重构原数组
    }

    /**
     * 练习9：桶排序
     * 时间复杂度：平均O(n + k)，最坏O(n²)
     * 空间复杂度：O(n + k)
     * 稳定性：稳定
     */
    public static void bucketSort(int[] arr) {
        // TODO: 实现桶排序
        // 1. 确定桶的数量和范围
        // 2. 将元素分配到对应的桶中
        // 3. 对每个桶进行排序（可以使用其他排序算法）
        // 4. 将桶中的元素依次取出
    }

    /**
     * 练习10：基数排序
     * 时间复杂度：O(d * (n + k))，d是位数，k是基数
     * 空间复杂度：O(n + k)
     * 稳定性：稳定
     * 适用：非负整数排序
     */
    public static void radixSort(int[] arr) {
        // TODO: 实现基数排序
        // 1. 找到数组中的最大值，确定位数
        // 2. 从个位开始，对每一位进行计数排序
        // 3. 重复步骤2，直到最高位
    }

    // 辅助方法：打印数组
    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // 辅助方法：交换数组元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 排序算法练习 ===");
        
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原数组:");
        printArray(arr1);
        
        // 测试各种排序算法
        int[] arr2 = arr1.clone();
        bubbleSort(arr2);
        System.out.println("冒泡排序:");
        printArray(arr2);
        
        int[] arr3 = arr1.clone();
        selectionSort(arr3);
        System.out.println("选择排序:");
        printArray(arr3);
        
        int[] arr4 = arr1.clone();
        insertionSort(arr4);
        System.out.println("插入排序:");
        printArray(arr4);
        
        int[] arr5 = arr1.clone();
        quickSort(arr5);
        System.out.println("快速排序:");
        printArray(arr5);
        
        int[] arr6 = arr1.clone();
        mergeSort(arr6);
        System.out.println("归并排序:");
        printArray(arr6);
    }
}

