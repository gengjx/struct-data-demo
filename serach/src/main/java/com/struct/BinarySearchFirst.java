package com.struct;

import java.util.Arrays;

public class BinarySearchFirst {


    public static void main(String[] args) {
        int [] arr = {1,1,1,2,3,4,5,6,7,8,9,10};

        System.out.println(Arrays.toString(arr));

        System.out.println(bSearch(arr,1));

    }


    public static int  bSearch(int [] arr ,int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            if (arr[0] == target) {
                return 0;
            }else {
                return -1;
            }
        }

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                if (mid == 0 || arr[mid - 1] != target) {
                    return mid;
                }else {
                    high = mid - 1;
                }
            }else if (arr[mid] > target) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }

        }



        return -1;



    }



}
