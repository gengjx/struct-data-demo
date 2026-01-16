package com.struct;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * 单元测试：{@link Sort}
 */
public class SortTest {

    @Test
    public void testBubbleSort_NormalArray() {
        int[] arr = {1, 3, 2, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.bubbleSort(arr);
        assertArrayEquals("正常数组排序失败", expected, arr);
    }

    @Test
    public void testBubbleSort_AlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.bubbleSort(arr);
        assertArrayEquals("已排序数组应该保持不变", expected, arr);
    }

    @Test
    public void testBubbleSort_ReverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.bubbleSort(arr);
        assertArrayEquals("逆序数组排序失败", expected, arr);
    }

    @Test
    public void testBubbleSort_WithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        Sort.bubbleSort(arr);
        assertArrayEquals("包含重复元素的数组排序失败", expected, arr);
    }

    @Test
    public void testBubbleSort_SingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        Sort.bubbleSort(arr);
        assertArrayEquals("单元素数组应该保持不变", expected, arr);
    }

    @Test
    public void testBubbleSort_TwoElements() {
        int[] arr = {2, 1};
        int[] expected = {1, 2};
        Sort.bubbleSort(arr);
        assertArrayEquals("两元素数组排序失败", expected, arr);
    }

    @Test
    public void testBubbleSort_EmptyArray() {
        int[] arr = {};
        int[] expected = {};
        Sort.bubbleSort(arr);
        assertArrayEquals("空数组应该保持不变", expected, arr);
    }

    @Test
    public void testBubbleSort_AllSameElements() {
        int[] arr = {3, 3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3, 3};
        Sort.bubbleSort(arr);
        assertArrayEquals("所有元素相同的数组应该保持不变", expected, arr);
    }

    @Test
    public void testBubbleSort_NegativeNumbers() {
        int[] arr = {-5, -2, -8, -1, -3};
        int[] expected = {-8, -5, -3, -2, -1};
        Sort.bubbleSort(arr);
        assertArrayEquals("包含负数的数组排序失败", expected, arr);
    }

    @Test
    public void testBubbleSort_MixedPositiveAndNegative() {
        int[] arr = {-3, 5, -1, 2, -4, 0};
        int[] expected = {-4, -3, -1, 0, 2, 5};
        Sort.bubbleSort(arr);
        assertArrayEquals("正负数混合数组排序失败", expected, arr);
    }

    @Test
    public void testBubbleSort_LargeArray() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
        int[] expected = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Sort.bubbleSort(arr);
        assertArrayEquals("大数组排序失败", expected, arr);
    }

    // ========== 插入排序测试用例 ==========

    @Test
    public void testInsertSort_NormalArray() {
        int[] arr = {1, 3, 2, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：正常数组排序失败", expected, arr);
    }

    @Test
    public void testInsertSort_AlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：已排序数组应该保持不变", expected, arr);
    }

    @Test
    public void testInsertSort_ReverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：逆序数组排序失败", expected, arr);
    }

    @Test
    public void testInsertSort_WithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：包含重复元素的数组排序失败", expected, arr);
    }

    @Test
    public void testInsertSort_SingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：单元素数组应该保持不变", expected, arr);
    }

    @Test
    public void testInsertSort_TwoElements() {
        int[] arr = {2, 1};
        int[] expected = {1, 2};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：两元素数组排序失败", expected, arr);
    }

    @Test
    public void testInsertSort_EmptyArray() {
        int[] arr = {};
        int[] expected = {};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：空数组应该保持不变", expected, arr);
    }

    @Test
    public void testInsertSort_AllSameElements() {
        int[] arr = {3, 3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3, 3};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：所有元素相同的数组应该保持不变", expected, arr);
    }

    @Test
    public void testInsertSort_NegativeNumbers() {
        int[] arr = {-5, -2, -8, -1, -3};
        int[] expected = {-8, -5, -3, -2, -1};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：包含负数的数组排序失败", expected, arr);
    }

    @Test
    public void testInsertSort_MixedPositiveAndNegative() {
        int[] arr = {-3, 5, -1, 2, -4, 0};
        int[] expected = {-4, -3, -1, 0, 2, 5};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：正负数混合数组排序失败", expected, arr);
    }

    @Test
    public void testInsertSort_PartiallySorted() {
        int[] arr = {1, 2, 3, 7, 4, 5, 6};
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        Sort.insertSort(arr);
        assertArrayEquals("插入排序：部分有序数组排序失败", expected, arr);
    }

    // ========== 选择排序测试用例 ==========

    @Test
    public void testSelectSort_NormalArray() {
        int[] arr = {1, 3, 2, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：正常数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_AlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：已排序数组应该保持不变", expected, arr);
    }

    @Test
    public void testSelectSort_ReverseOrder() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：逆序数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_WithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：包含重复元素的数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_SingleElement() {
        int[] arr = {42};
        int[] expected = {42};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：单元素数组应该保持不变", expected, arr);
    }

    @Test
    public void testSelectSort_TwoElements() {
        int[] arr = {2, 1};
        int[] expected = {1, 2};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：两元素数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_EmptyArray() {
        int[] arr = {};
        int[] expected = {};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：空数组应该保持不变", expected, arr);
    }

    @Test
    public void testSelectSort_AllSameElements() {
        int[] arr = {3, 3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3, 3};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：所有元素相同的数组应该保持不变", expected, arr);
    }

    @Test
    public void testSelectSort_NegativeNumbers() {
        int[] arr = {-5, -2, -8, -1, -3};
        int[] expected = {-8, -5, -3, -2, -1};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：包含负数的数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_MixedPositiveAndNegative() {
        int[] arr = {-3, 5, -1, 2, -4, 0};
        int[] expected = {-4, -3, -1, 0, 2, 5};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：正负数混合数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_LargeArray() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
        int[] expected = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：大数组排序失败", expected, arr);
    }

    @Test
    public void testSelectSort_MinAtEnd() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};
        Sort.selectSort(arr);
        assertArrayEquals("选择排序：最小元素在末尾的数组排序失败", expected, arr);
    }

    // ========== 三种排序算法对比测试 ==========

    @Test
    public void testAllSorts_Consistency() {
        int[] arr1 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] arr2 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] arr3 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 6, 9};

        Sort.bubbleSort(arr1);
        Sort.insertSort(arr2);
        Sort.selectSort(arr3);

        assertArrayEquals("冒泡排序结果", expected, arr1);
        assertArrayEquals("插入排序结果", expected, arr2);
        assertArrayEquals("选择排序结果", expected, arr3);
    }
}

