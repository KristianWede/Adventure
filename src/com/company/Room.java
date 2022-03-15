package com.company;

public class Room {
  private String name;
  private String description;
  private Room n, e, s, w;
  private boolean visited;
  private boolean discoveredDoorN;
  private boolean discoveredDoorE;
  private boolean discoveredDoorW;
  private boolean discoveredDoorS;

  public Room(String name, String description) {
    this.name = name;
    this.description = description;
    this.visited = false;
    this.discoveredDoorN = false;
    this.discoveredDoorE = false;
    this.discoveredDoorW = false;
    this.discoveredDoorS = false;
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

  public boolean isVisited() {
    return visited;
  }

  public boolean isDiscoveredDoorN() {
    return discoveredDoorN;
  }

  public boolean isDiscoveredDoorE() {
    return discoveredDoorE;
  }

  public boolean isDiscoveredDoorW() {
    return discoveredDoorW;
  }

  public boolean isDiscoveredDoorS() {
    return discoveredDoorS;
  }

  //Setters


  public void setDiscoveredDoorN(boolean discoveredDoorN) {
    this.discoveredDoorN = discoveredDoorN;
  }

  public void setDiscoveredDoorE(boolean discoveredDoorE) {
    this.discoveredDoorE = discoveredDoorE;
  }

  public void setDiscoveredDoorW(boolean discoveredDoorW) {
    this.discoveredDoorW = discoveredDoorW;
  }

  public void setDiscoveredDoorS(boolean discoveredDoorS) {
    this.discoveredDoorS = discoveredDoorS;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

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


