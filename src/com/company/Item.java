package com.company;


public class Item {


  public String itemName;
  public String itemDescription;
  public String itemType;
  public int health;
  public int roomPlacement;
  public boolean setItemPresent;

  public Item(String itemName, String itemDescription, int health, int roomPlacement, boolean setItemPresent) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.health = health;
    this.roomPlacement = roomPlacement;
    this.setItemPresent = setItemPresent;

  }

  public int getRoomPlacement(int roomPlacement) {
    this.roomPlacement = roomPlacement;
    return roomPlacement;
  }

  public boolean isSetItemPresent() {
    return setItemPresent;
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

