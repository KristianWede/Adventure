package com.company;

public class Food extends Item {

  protected int health;

  public Food(String itemName, String itemDescription, int health) {
    super(itemName, itemDescription);
    this.health = health;
  }
  public int getHealth() {
    return health;
  }

}
