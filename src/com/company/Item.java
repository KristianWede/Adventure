package com.company;


public class Item {


  public String itemName;
  public String itemDescription;
  public int health;

  public Item(String itemName, String itemDescription) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
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


  public String toString() {
    return itemName;
  }

}

