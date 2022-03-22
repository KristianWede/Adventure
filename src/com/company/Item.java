package com.company;


import java.util.ArrayList;

public class Item {


  public String itemName;
  public String itemDescription;
  public String itemType;
  public int health;

  public Item(String itemName, String itemDescription, int health) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.health = health;
  }

  public int getHealth() {
    return health;
  }

  public String getItemName() {
    return itemName;
  }

  public String getItemDescription() {
    return itemDescription;
  }

  public String getItemType() {
    return itemType;
  }

  public String toString() {
    return itemName;
  }

}

