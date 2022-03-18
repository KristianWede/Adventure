package com.company;

public class Item {


  public String itemName;
  public String itemDescription;
  public String itemType;
  public Room itemPosition;

  public Item(String itemName, String itemDescription, Room itemPosition){
    this.itemName = itemName;
    this.itemDescription = itemDescription;
    this.itemPosition = itemPosition;
  }

  public String getItemName(){
    return itemName;
  }
  public String getItemDescription(){
    return itemDescription;
  }
  public String getItemType(){
    return itemType;
  }

  public String toString(){
    return itemName;
  }

}

