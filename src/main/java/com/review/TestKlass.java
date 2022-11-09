package com.review;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/09 22:20
 */
public class TestKlass {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try {
            int i = a / b;
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}
