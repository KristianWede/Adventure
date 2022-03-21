package com.company;


import java.util.ArrayList;

public class Item {


  public String itemName;
  public String itemDescription;
  public String itemType;

  public Item(String itemName, String itemDescription){
    this.itemName = itemName;
    this.itemDescription = itemDescription;
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

