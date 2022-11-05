package com.review.clone;

/**
 * @program nio-demo
 * @description: clone
 * @author: xuyaxi
 * @create: 2022/10/21 21:19
 */
public class TestClone {

  public static void main(String[] args) {
    Object o = new Object();
    Address address = new Address("上海");
    Person person = new Person(address);
    System.out.println(person.getAddress() == (person.clone().getAddress()));
  }
}
