package com.struct;

public class BsearchLE {


    public static void main(String[] args) {
        System.out.println("二分查找，第一个>= 的索引");
        int [] a = {2,3,3,4,4,5,5,5,6,6,6,9};
        System.out.println(bSearch(a,8));
    }

    public static int bSearch(int [] a,int target){

        if (a == null || a.length == 0) return -1;

        int low = 0;
        int high = a.length - 1;
        while (low <= high) {

            int mid  = low + ( (high - low)>>1);

            if(a[mid] < target){
                low = mid + 1;
            }else if(a[mid] >= target){
                if(mid == 0 || a[mid - 1] < target){
                    return mid;
                }else {
                    high = mid - 1;
                }
            }


        }

        return -1;
    }

}
