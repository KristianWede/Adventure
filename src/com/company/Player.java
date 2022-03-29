package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

  private Room playerPosition;
  private UserInterface ui;
  private GameEngine game;
  protected int health = 100;
  protected boolean equipWeapon = false;

  public void loadUserInterfaceInPlayer() {
    ui = new UserInterface();
  }

  public void loadGameEngineInPlayer() {
    game = new GameEngine();
  }

  private ArrayList<Item> playerInventory = new ArrayList<>();

  public int tryEatFood(Food food) {
    if (getHealth() == 100) {
    return health;
    }
    health = setHealth(getHealth() + food.getHealth());
    playerInventory.remove(food);
    if (health > 100) {
      ui.MaxHP();
      return health = 100;
    } else {
      return health;
    }
  }

  public void inspectItemFromInventory() {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Item tmp = playerInventory.get(i);
      ui.printPlayerInventorySingularNumbered(tmp, i);
    }
    ui.printChooseItemToInspect();
    Scanner sc = new Scanner(System.in);
    String choice = sc.nextLine();

    for (int i = 0; i < playerInventory.size(); i++) {
      Item tmp = playerInventory.get(i);
      if (tmp.getItemName().toLowerCase().contains(choice)) {
        ui.printNameAndDescriptionOfItem(tmp);
        itemFound = true;
      }
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
  }

  //Setter
  public void addItemToPlayerInventory(String searchWord, Room room) {
    boolean itemFound = false;
    for (int i = 0; i < room.getRoomInventory().size(); i++) {
      Item tmp = room.getRoomInventory().get(i);
      if (tmp.getItemName().toLowerCase().contains(searchWord)) {
        playerInventory.add(tmp);
        ui.printReactionPickUp(tmp);
        room.getRoomInventory().remove(tmp);
        itemFound = true;
      }
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
  }

  public void removeItemFromPlayerInventory(String searchWord, Room room) {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Item tmp = playerInventory.get(i);
      if (tmp.getItemName().toLowerCase().contains(searchWord)) {
        room.getRoomInventory().add(tmp);
        ui.printAddedItemRoom(tmp);
        playerInventory.remove(tmp);
        itemFound = true;
      }
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
  }

  public void whichFood(String foodItem) {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Food food = (Food) playerInventory.get(i);
      if (food.getItemName().toLowerCase().contains(foodItem)) {
        itemFound = true;
        userEatsFood(food);
      }
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
  }

  public void whichWeapon(String weaponChoice) {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Item weapon = playerInventory.get(i);

      if (weapon instanceof Weapon){
        if (weapon.getItemName().toLowerCase().contains(weaponChoice)) {
          itemFound = true;
          userEquipsWeapon((Weapon) weapon);
      }
      }
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
  }

  private void userEquipsWeapon(Weapon weapon) {
    if (equipWeapon == true){
      ui.printWeaponAlreadyEquipped();
    }
    else {
    equipWeapon = true;
    ui.printWeaponEquipped(weapon);
  }}

  public void userEatsFood(Food food) {
    int tmp = food.getHealth();
    if (tmp == 0) {
      ui.notEdible(food);
    } else if (tmp < 0) {
      ui.poisoned(food);
    } else if (tmp > 0 && getHealth() > 100) {
      ui.full(food);
    } else if (getHealth() == 100) {
      ui.full(food);
    } else ui.edible(food);
    tryEatFood(food);
  }

  public void attack() {

  }

  //Getter


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
