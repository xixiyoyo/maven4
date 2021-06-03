package com.xixiyoyo.domain;

import java.util.List;

public class Users {
  private int id;
  private String name;
  private String password;
  private int age;
  private int role;

  private List<Roles> roles;

  public Users(int id, String name, String password, int age, int role, List<Roles> roles) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.age = age;
    this.role = role;
    this.roles = roles;
  }

  public Users(int id, String name, String password, int age, int role) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.age = age;
    this.role = role;
  }

  public Users(String name, String password, int age) {
    this.name = name;
    this.password = password;
    this.age = age;
  }

  public Users() {
  }

  public List<Roles> getRoles() {
    return roles;
  }

  public void setRoles(List<Roles> roles) {
    this.roles = roles;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getRole() {
    return role;
  }

  public void setRole(int role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "Users{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", password='" + password + '\'' +
      ", age=" + age +
      ", role=" + role +
      '}';
  }
}
