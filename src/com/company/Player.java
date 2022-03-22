package com.company;

import java.util.ArrayList;

public class Player {

  private Room playerPosition;
  private UserInterface ui;
  protected int health = 100;

  public void loadUserInterface() {
    ui = new UserInterface();
  }

  private ArrayList<Item> playerInventory = new ArrayList<>();

  public int tryEatFood(Item item) {
    health = setHealth(getHealth() + item.getHealth());
    if (health > 100) {
      ui.eatToMaxHP();
      return health = 100;
    } else if (health == 100){
        return health;
    }
      else
        playerInventory.remove(item);
    return health;
  }

  //Setter
  public void addItemToPlayerInventory(String searchWord, Room room) {
    for (int i = 0; i < room.getRoomInventory().size(); i++) {
      Item tmp = room.getRoomInventory().get(i);
      if (tmp.getItemName().toLowerCase().contains(searchWord)) {
        playerInventory.add(tmp);
        ui.printReactionPickUp(tmp);
        room.getRoomInventory().remove(tmp);
      } else if (i == room.getRoomInventory().size()) { // Add minus 1 after size??
        ui.printErrorCannotFindItem();
      }
    }
  }

  public void removeItemFromPlayerInventory(String searchWord, Room room) {
    for (int i = 0; i < playerInventory.size(); i++) {
      Item tmp = playerInventory.get(i);
      if (tmp.getItemName().toLowerCase().contains(searchWord)) {
        room.getRoomInventory().add(tmp);
        ui.printAddedItemRoom(tmp);
        playerInventory.remove(tmp);
      } else if (i == room.getRoomInventory().size() - 1) {
        ui.printErrorCannotFindItem();
      }
    }
  }

  public void whichFood(String foodItem) {
    for (int i = 0; i < playerInventory.size(); i++) {
      Item food = playerInventory.get(i);
      if (food.getItemName().toLowerCase().contains(foodItem)) {
        userEatsFood(food);
      }


    }
  }

  public void userEatsFood(Item food) {
    int tem = food.getHealth();
    if (tem == 0) {
      ui.notEdible(food);
    } else if (tem < 0) {
      ui.poisoned(food);
      tryEatFood(food);
    } else if (tem > 0 && getHealth() > 100) {
      ui.full(food);
    } else if (getHealth() == 100) {
      ui.full(food);
    } else ui.edible(food);
    tryEatFood(food);
  }

  //Getter
  public ArrayList<Item> itemsAtPlayerPosition(Room room) {
    return room.getRoomInventory();
  }

  public ArrayList<Item> getPlayerInventory() {
    return playerInventory;
  }

  public int getHealth() {
    return health;
  }

  public Room getPlayerPosition() {
    return playerPosition;
  }

  //Setter

  public void setPlayerPosition(Room room) {
    playerPosition = room;
  }

  public int setHealth(int health) {
    this.health = health;
    return health;
  }
}
