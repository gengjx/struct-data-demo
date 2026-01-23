package com.struct.practice;

/**
 * 查找算法练习
 * 练习内容：
 * 1. 顺序查找
 * 2. 二分查找
 * 3. 插值查找
 * 4. 斐波那契查找
 * 5. 哈希查找
 * 6. 二叉搜索树查找
 */
public class SearchAlgorithmPractice {

    /**
     * 练习1：顺序查找
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        // TODO: 实现顺序查找
        // 遍历数组，找到目标值返回索引，未找到返回-1
        return -1;
    }

    /**
     * 练习2：二分查找（递归）
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * 前提：数组必须有序
     */
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        // TODO: 实现递归二分查找
        // 1. 如果left > right，返回-1
        // 2. 计算中点mid = (left + right) / 2
        // 3. 如果arr[mid] == target，返回mid
        // 4. 如果arr[mid] > target，在左半部分查找
        // 5. 如果arr[mid] < target，在右半部分查找
        return -1;
    }

    /**
     * 练习3：二分查找（迭代）
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     */
    public static int binarySearchIterative(int[] arr, int target) {
        // TODO: 实现迭代二分查找
        // 1. 初始化left = 0, right = arr.length - 1
        // 2. 当left <= right时：
        //    - 计算mid = (left + right) / 2
        //    - 如果arr[mid] == target，返回mid
        //    - 如果arr[mid] > target，right = mid - 1
        //    - 如果arr[mid] < target，left = mid + 1
        // 3. 未找到返回-1
        return -1;
    }

    /**
     * 练习4：查找第一个等于target的元素
     * 任务：在有序数组中查找第一个等于target的元素索引
     */
    public static int findFirst(int[] arr, int target) {
        // TODO: 实现查找第一个等于target的元素
        // 使用二分查找，但需要处理重复元素的情况
        // 当找到target时，继续向左查找，直到找到第一个
        return -1;
    }

    /**
     * 练习5：查找最后一个等于target的元素
     * 任务：在有序数组中查找最后一个等于target的元素索引
     */
    public static int findLast(int[] arr, int target) {
        // TODO: 实现查找最后一个等于target的元素
        // 使用二分查找，但需要处理重复元素的情况
        // 当找到target时，继续向右查找，直到找到最后一个
        return -1;
    }

    /**
     * 练习6：查找第一个大于等于target的元素
     * 任务：在有序数组中查找第一个大于等于target的元素索引
     */
    public static int findFirstGreaterOrEqual(int[] arr, int target) {
        // TODO: 实现查找第一个大于等于target的元素
        // 使用二分查找
        // 如果arr[mid] >= target，可能是答案，继续向左查找
        // 如果arr[mid] < target，向右查找
        return -1;
    }

    /**
     * 练习7：插值查找
     * 时间复杂度：平均O(loglogn)，最坏O(n)
     * 适用：数据分布均匀的有序数组
     */
    public static int interpolationSearch(int[] arr, int target) {
        // TODO: 实现插值查找
        // 插值查找是二分查找的改进
        // mid = left + (target - arr[left]) * (right - left) / (arr[right] - arr[left])
        // 其他逻辑与二分查找类似
        return -1;
    }

    /**
     * 练习8：斐波那契查找
     * 时间复杂度：O(logn)
     * 使用黄金分割点进行查找
     */
    public static int fibonacciSearch(int[] arr, int target) {
        // TODO: 实现斐波那契查找
        // 1. 生成斐波那契数列
        // 2. 找到大于等于数组长度的最小斐波那契数
        // 3. 将数组扩展到斐波那契数长度
        // 4. 使用黄金分割点进行查找
        return -1;
    }

    /**
     * 练习9：哈希查找
     * 时间复杂度：平均O(1)，最坏O(n)
     */
    public static class HashTable {
        private static class Entry {
            int key;
            int value;
            Entry next;

            Entry(int key, int value) {
                this.key = key;
                this.value = value;
                this.next = null;
            }
        }

        private Entry[] table;
        private int capacity;

        public HashTable(int capacity) {
            this.capacity = capacity;
            this.table = new Entry[capacity];
        }

        // TODO: 哈希函数
        private int hash(int key) {
            // 使用简单的取模法
            return key % capacity;
        }

        // TODO: 插入元素
        public void put(int key, int value) {
            // 1. 计算哈希值
            // 2. 如果该位置为空，直接插入
            // 3. 如果该位置有元素，使用链地址法处理冲突
        }

        // TODO: 查找元素
        public Integer get(int key) {
            // 1. 计算哈希值
            // 2. 在该位置的链表中查找
            // 3. 找到返回value，未找到返回null
            return null;
        }

        // TODO: 删除元素
        public boolean remove(int key) {
            // 1. 计算哈希值
            // 2. 在该位置的链表中查找并删除
            // 3. 删除成功返回true，未找到返回false
            return false;
        }
    }

    // 测试方法
    public static void main(String[] args) {
        System.out.println("=== 查找算法练习 ===");
        
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        
        // 测试顺序查找
        int index1 = linearSearch(arr, 7);
        System.out.println("顺序查找 7: " + index1);
        
        // 测试二分查找
        int index2 = binarySearchRecursive(arr, 7);
        System.out.println("二分查找（递归）7: " + index2);
        
        int index3 = binarySearchIterative(arr, 7);
        System.out.println("二分查找（迭代）7: " + index3);
        
        // 测试查找第一个和最后一个
        int[] arr2 = {1, 2, 2, 2, 3, 4, 5};
        int first = findFirst(arr2, 2);
        int last = findLast(arr2, 2);
        System.out.println("第一个2的位置: " + first);
        System.out.println("最后一个2的位置: " + last);
    }
}

