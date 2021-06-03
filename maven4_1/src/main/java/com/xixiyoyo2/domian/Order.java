package com.xixiyoyo2.domian;

import java.util.Date;

public class Order {

  private int oid;
  private Date stime;
  private double total;

  //一对一时创建对象
  private Users users;

  public int getOid() {
    return oid;
  }

  public void setOid(int oid) {
    this.oid = oid;
  }

  public Date getStime() {
    return stime;
  }

  public void setStime(Date stime) {
    this.stime = stime;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public Users getUsers() {
    return users;
  }

  public void setUsers(Users users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "Order{" +
      "oid=" + oid +
      ", stime=" + stime +
      ", total=" + total +
      ", users=" + users +
      '}';
  }
}
