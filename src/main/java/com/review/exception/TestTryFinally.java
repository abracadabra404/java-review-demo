package com.review.exception;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/10/23 16:05
 */
public class TestTryFinally {

  public static void main(String[] args) {
    try {
      System.out.println("doing try");
      throw new RuntimeException("Runtime exception");
    } catch (Exception e) {
      System.out.println("catch exception -> " + e.getMessage());
      System.exit(1);
    } finally {
      System.out.println("doing finally");
    }
  }
}
