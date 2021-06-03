package com.xixiyoyo.domain;

import java.util.List;

public class VO {
  private List<User> userList;

  public VO(List<User> userList) {
    this.userList = userList;
  }

  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  @Override
  public String toString() {
    return "VO{" +
      "userList=" + userList +
      '}';
  }
}
