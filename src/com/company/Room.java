package com.company;

public class Room {
  private String name;
  private String description;
  private Room n,e,s, w;

  public Room(String name, String description, Room n, Room e, Room s, Room w) {
    this.name = name;
    this.description = description;
    this.n = n;
    this.e = e;
    this.s = s;
    this.w = w;
  }



  /*public Room(String name, String description){


    this.name = name;
    this.description = description;
    this.n = n;
    this.e = e;
    this.s =
*/
  }


