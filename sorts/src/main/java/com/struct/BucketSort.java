package com.struct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BucketSort {

    public static void main(String[] args) {
        int []d = {78, 17, 39, 26, 72, 94, 21, 12, 23, 68, 51, 33, 45, 67, 89};
        System.out.println("桶排序前: " + Arrays.toString(d));
        bucketSort(d,5);
        System.out.println("桶排序后: " + Arrays.toString(d));
    }


    public static void bucketSort(int[] arr, int bucketSize) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int max = arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int bucketCount = (max - min) / bucketSize +1;

        List<List<Integer>> bucketList = new ArrayList<>(bucketSize);

        for (int i = 0; i < bucketCount; i++) {
            bucketList.add(new ArrayList<>());
        }


        for (int i = 0; i < arr.length; i++) {

            int index = (arr[i] - min) / bucketSize;
            bucketList.get(index).add(arr[i]);
        }


        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        int index = 0;
        for (int i = 0; i < bucketList.size(); i++) {
            List<Integer> list = bucketList.get(i);
            for (int j = 0; j < list.size(); j++) {
                arr[index++] = list.get(j);
            }

        }



    }


}
