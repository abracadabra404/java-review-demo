package com.review.sort;

import java.util.Arrays;

/**
 * @program java-review-demo
 * @description: 冒泡排序
 * @author: xuyaxi
 * @create: 2022/11/17 22:49
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 0, 3, 2, 4};
        System.out.println(Arrays.toString(bubbleSort(nums)));
    }


    public static int[] bubbleSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            for (int j = 0; j < nums.length -i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return nums;
    }



}
