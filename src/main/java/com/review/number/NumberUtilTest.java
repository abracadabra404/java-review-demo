package com.review.number;

import cn.hutool.core.util.NumberUtil;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/25 15:29
 */
public class NumberUtilTest {

    public static void main(String[] args) {
        long toLong = NumberUtil.parseLong("123456");
        System.out.println(toLong);
    }
}
