package com.company;

public class Item {

  public String itemName;
  public String itemDescription;

  public Item(String itemName, String itemDescription){
    this.itemName = itemName;
    this.itemDescription = "This is an Item Description!";
  }

  public String getItemName(){
    return itemName;
  }
  public String getItemDescription(){
    return itemDescription;
  }

  public String toString(){
    return itemName;
  }

}

