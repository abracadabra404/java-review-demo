package com.review.exception;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/10/23 16:01
 */
public class TestTryCatch {

  public static void main(String[] args) {
    System.out.println(f(2));
  }

  private static int f(int i) {
    try {
      return i * i;
    } finally {
      if (i == 2) {
        return 0;
      }
    }
  }
}
