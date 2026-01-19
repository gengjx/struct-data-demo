package com.struct;

public class BinarySearch {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 8;
        System.out.println(binarySearch(arr,target));
        System.out.println(bSearch(arr,target));
    }


    public static int binarySearch(int [] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static int bSearch(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        int low = 0;
        int high = arr.length - 1;
        return bSearchInternally(arr,target,low,high);

    }

    private static int bSearchInternally(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return bSearchInternally(arr, target, low, mid - 1);
        }else {
            return bSearchInternally(arr, target, mid + 1, high);
        }

    }
}
