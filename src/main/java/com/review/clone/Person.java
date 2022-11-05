package com.review.clone;

/**
 * @program nio-demo
 * @description:
 * @author: xuyaxi
 * @create: 2022/10/21 21:28
 */
public class Person implements Cloneable {

  public Person(Address address) {
    this.address = address;
  }

  private Address address;

  @Override
  public Person clone() {
    try {
      Person person = (Person) super.clone();
      person.setAddress(person.getAddress().clone());
      return person;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
}
