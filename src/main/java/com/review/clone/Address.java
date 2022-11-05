package com.review.clone;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/10/21 21:25
 */
public class Address implements Cloneable {

  private String name;

  public Address(String name) {
    this.name = name;
  }

  @Override
  public Address clone() {
    try {
      return (Address) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
