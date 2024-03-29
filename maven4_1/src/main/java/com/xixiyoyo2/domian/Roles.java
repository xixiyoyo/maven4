package com.xixiyoyo2.domian;

public class Roles {
  private int rid;
  private String rname;
  private String rdesc;

  public Roles(int rid, String rname, String rdesc) {
    this.rid = rid;
    this.rname = rname;
    this.rdesc = rdesc;
  }

  public Roles() {
  }

  public Roles(String rname, String rdesc) {
    this.rname = rname;
    this.rdesc = rdesc;
  }

  public int getRid() {
    return rid;
  }

  public void setRid(int rid) {
    this.rid = rid;
  }

  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }

  public String getRdesc() {
    return rdesc;
  }

  public void setRdesc(String rdesc) {
    this.rdesc = rdesc;
  }

  @Override
  public String toString() {
    return "Roles{" +
      "rid=" + rid +
      ", rname='" + rname + '\'' +
      ", rdesc='" + rdesc + '\'' +
      '}';
  }
}
