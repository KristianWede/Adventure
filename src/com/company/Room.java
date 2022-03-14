package com.company;

public class Room {
  private String name;
  private String description;
  private Room n, e, s, w;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
  }


  //Getters
  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Room getN() {
    return n;
  }

  public Room getE() {
    return e;
  }

  public Room getS() {
    return s;
  }

  public Room getW() {
    return w;
  }

  //Setters

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setN(Room n) {
    this.n = n;
  }

  public void setE(Room e) {
    this.e = e;
  }

  public void setS(Room s) {
    this.s = s;
  }

  public void setW(Room w) {
    this.w = w;
  }
}


