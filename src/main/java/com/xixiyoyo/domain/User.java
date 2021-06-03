package com.xixiyoyo.domain;

public class User {
  private String name;
  private int age;
  private Double money;

  public User(String name, int age, Double money) {
    this.name = name;
    this.age = age;
    this.money = money;
  }

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Double getMoney() {
    return money;
  }

  public void setMoney(Double money) {
    this.money = money;
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", age=" + age +
      ", money=" + money +
      '}';
  }
}
