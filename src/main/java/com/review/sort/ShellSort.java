package com.review.sort;

import java.util.Arrays;

/**
 * @program java-review-demo
 * @description: 希尔排序
 * @author: xuyaxi
 * @create: 2022/11/18 21:28
 * 递减增量排序算法
 * 先将整个待排序的记录序列分割成若干子序列分别进行直接插入排序
 * 待整个序列中的记录基本有序时，在对全体记录进行依次直接插入排序
 *
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] nums = {5,1,3,7,9,2,4,0,6};
        System.out.println(Arrays.toString(shellSort(nums)));
    }


    public static int[] shellSort(int[] nums) {
        int n = nums.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int current = nums[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > current) {
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = current;
            }
            gap /= 2;
        }
        return nums;
    }
}
