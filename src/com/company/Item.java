package com.company;


public class Item {


  protected String itemName;
  protected String itemDescription;
  protected int health;
  protected int damage;

  public Item(String itemName, String itemDescription) {
    this.itemName = itemName;
    this.itemDescription = itemDescription;
  }

  public int getHealth() {
    return health;
  }

  public int getDamage() {
    return damage;
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

