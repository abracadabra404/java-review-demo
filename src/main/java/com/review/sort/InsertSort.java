package com.review.sort;

import java.util.Arrays;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/18 20:54
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 9, 6, 4};
        System.out.println(Arrays.toString(insertSort(nums)));
    }

    public static int[] insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int preIndex = i - 1;
            int current = nums[i];
            while (preIndex >= 0 && current < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex -= 1;
            }
            nums[preIndex + 1] = current;
        }
        return nums;
    }
}
