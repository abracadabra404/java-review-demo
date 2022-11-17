package com.review.sort;

import java.util.Arrays;

/**
 * @program java-review-demo
 * @description: 选择排序
 * @author: xuyaxi
 * @create: 2022/11/17 23:03
 */
public class SelectionSort {


    public static void main(String[] args) {
        int[] nums = {2, 8, 3, 9, 1, 0};
        System.out.println(Arrays.toString(selectionSort(nums)));
    }

    public static int[] selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }

            }
            if (i != minIndex) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }

        return nums;

    }
}
