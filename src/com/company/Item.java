package com.company;


public class Item {


  protected String itemName;
  protected String itemDescription;


  public Item(String itemName, String itemDescription) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
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

