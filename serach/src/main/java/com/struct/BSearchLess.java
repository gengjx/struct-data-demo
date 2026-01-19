package com.struct;

public class BSearchLess {


    public static void main(String[] args) {
        System.out.println("二分查找，查找最后一个小于等于的元素");

        int [] arr = {1,2,3,4,5,6,7,8,9};

        System.out.println(bSearch(arr,9));
    }


    public static int bSearch(int[] a, int target) {

        if (a == null || a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);  // 修复：需要括号，因为 >> 的优先级低于 +
            System.out.println(mid);
            if(a[mid] > target) {
                high = mid - 1;
            }else {
                if(mid == a.length - 1  || a[mid + 1] > target) {
                    return mid;
                }else {
                    low = mid + 1;
                }
            }

        }
        return -1;


    }

}
