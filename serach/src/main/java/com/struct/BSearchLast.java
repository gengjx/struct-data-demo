package com.struct;

public class BSearchLast {

    public static void main(String[] args) {
        System.out.println("Search Last Element equals target");
        int [] arr = {0,0,1,1,1,2,2,2};

        System.out.println(bSearch(arr,0));


    }


    public static int bSearch(int [] arr, int target ) {
        if (arr == null || arr.length == 0){
            return -1;
        }
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {

            int mid = low  + ((high -low) >> 1);

            if(arr[mid] < target){
                low = mid + 1;
            }else if(arr[mid] > target) {
                high = mid - 1;
            }else {
                if (mid == arr.length -1 || arr[mid + 1] != target) {
                    return mid;
                }
                low = mid + 1;
            }


        }

        return -1;

    }

}
