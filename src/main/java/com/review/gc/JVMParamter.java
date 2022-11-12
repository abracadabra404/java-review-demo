package com.review.gc;

/**
 * @program java-review-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/11/12 16:28
 */
public class JVMParamter {

    public static void main(String[] args) {
        System.out.println("maxMemory:" + Runtime.getRuntime().maxMemory() /1024/1024 +"M");
        System.out.println("freeMemory:" + Runtime.getRuntime().freeMemory() /1024/1024 +"M");
        System.out.println("totalMemory:" + Runtime.getRuntime().totalMemory() /1024/1024 +"M");
    }
}
