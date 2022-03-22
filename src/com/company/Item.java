package com.company;


public class Item {


  public String itemName;
  public String itemDescription;
  public String itemType;
  public int health;
  public Room roomPlacement;
  public boolean setItemPresent;

  public Item(String itemName, String itemDescription, int health, Room roomPlacement) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.health = health;
    this.roomPlacement = roomPlacement;

  }


  public Room getRoomPlacement(Room roomPlacement) {
    return roomPlacement;
  }

  public void setRoomPlacement(Room roomPlacement) {
    this.roomPlacement = roomPlacement;
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

