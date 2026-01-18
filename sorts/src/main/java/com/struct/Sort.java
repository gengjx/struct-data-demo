package com.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 桶排序（Bucket Sort）
     * 
     * 桶排序是一种分布式排序算法，工作原理如下：
     * 1. 将数组分到有限数量的桶里
     * 2. 每个桶再个别排序（可以使用其他排序算法，如插入排序）
     * 3. 最后依次把各个桶中的记录列出来得到有序序列
     * 
     * 时间复杂度：
     *   - 平均情况：O(n + k)，其中 k 是桶的数量
     *   - 最好情况：O(n)（当元素均匀分布时）
     *   - 最坏情况：O(n²)（当所有元素都在一个桶中时）
     * 
     * 空间复杂度：O(n + k)
     * 
     * 稳定性：稳定（取决于桶内排序算法的稳定性，这里使用插入排序，是稳定的）
     * 
     * 适用场景：
     *   - 数据分布比较均匀
     *   - 数据范围已知或可以确定
     *   - 适合外部排序（数据量大，无法全部加载到内存）
     *   - 适合非负整数排序（或可以映射到非负整数）
     * 
     * @param a 待排序的数组
     */
    public static void bucketSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        // 1. 找到数组的最大值和最小值，确定数据范围
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }

        // 2. 计算桶的数量（通常为数组长度的1/10到1/5，这里使用数组长度）
        int bucketCount = a.length;
        // 如果数组长度太大，限制桶的数量，避免创建过多桶
        if (bucketCount > 100) {
            bucketCount = 100;
        }

        // 3. 计算每个桶的容量范围
        int bucketSize = (max - min) / bucketCount + 1;

        // 4. 创建桶（使用ArrayList存储每个桶的元素）
        List<List<Integer>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        // 5. 将数组中的元素分配到对应的桶中
        for (int value : a) {
            // 计算元素应该放入哪个桶
            int bucketIndex = (value - min) / bucketSize;
            // 防止索引越界（当 value == max 时）
            if (bucketIndex >= bucketCount) {
                bucketIndex = bucketCount - 1;
            }
            buckets.get(bucketIndex).add(value);
        }

        // 6. 对每个桶内的元素进行排序（使用插入排序）
        for (List<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                // 将List转换为数组进行排序
                int[] bucketArray = new int[bucket.size()];
                for (int i = 0; i < bucket.size(); i++) {
                    bucketArray[i] = bucket.get(i);
                }
                // 使用插入排序对桶内元素排序
                insertSort(bucketArray);
                // 将排序后的结果放回List
                for (int i = 0; i < bucketArray.length; i++) {
                    bucket.set(i, bucketArray[i]);
                }
            }
        }

        // 7. 依次将各个桶中的元素取出，合并成有序数组
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (Integer value : bucket) {
                a[index++] = value;
            }
        }
    }

    


    public static void main(String[] args) {
        int []a = {1,3,2,4,5};
        bubbleSort(a);
        System.out.println("冒泡排序: " + Arrays.toString(a));

        int []b = {1,3,2,4,5};
        insertSort(b);
        System.out.println("插入排序: " + Arrays.toString(b));

        int []c = {1,3,2,4,5};
        selectSort(c);
        System.out.println("选择排序: " + Arrays.toString(c));

        // 桶排序测试
        int []d = {78, 17, 39, 26, 72, 94, 21, 12, 23, 68, 51, 33, 45, 67, 89};
        System.out.println("桶排序前: " + Arrays.toString(d));
        bucketSort(d);
        System.out.println("桶排序后: " + Arrays.toString(d));

        // 测试包含重复元素的数组
        int []e = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        System.out.println("桶排序前（含重复）: " + Arrays.toString(e));
        bucketSort(e);
        System.out.println("桶排序后（含重复）: " + Arrays.toString(e));
    }

}
