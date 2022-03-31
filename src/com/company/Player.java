package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

  private Room playerPosition;
  private UserInterface ui;
  private GameEngine game;
  protected int health = 100;
  protected Weapon weaponEquipped;

  public void loadUserInterfaceInPlayer() {
    ui = new UserInterface();
  }

  public void loadGameEngineInPlayer() {
    game = new GameEngine();
  }

  private ArrayList<Item> playerInventory = new ArrayList<>();


  public int tryEatFood(Food food) throws InterruptedException {
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

  public void inspectItemFromInventory() throws InterruptedException {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Item tmp = playerInventory.get(i);
      ui.printNameAndDescriptionOfItem(tmp, i);
        itemFound = true;
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
  }

  //Setter

  public void addItemToPlayerInventory(String searchWord, Room room) throws InterruptedException {
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

  public boolean findItemInInventory(String searchWord){
    for (int i = 0; i < playerInventory.size(); i++) {
      Item tmp = playerInventory.get(i);
      if (tmp.getItemName().toLowerCase().contains(searchWord)) {
        return true;
      }
    }
    return false;
  }


  public void removeItemFromPlayerInventory(String searchWord, Room room) throws InterruptedException {
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

  public String whichFood(String foodItem) throws InterruptedException {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Item food = playerInventory.get(i);
      if (food.getItemName().toLowerCase().contains(foodItem)) {
        itemFound = true;
        ui.gameTextPrinter(userEatsFood((Food) food));
      }
    }
    if (!itemFound) {
      ui.printErrorCannotFindItem();
    }
    return "";
  }

  public void whichWeapon(String weaponChoice) throws InterruptedException {
    boolean itemFound = false;
    for (int i = 0; i < playerInventory.size(); i++) {
      Item weapon = playerInventory.get(i);

      if (weapon instanceof Weapon) {
        if (weapon.getItemName().toLowerCase().contains(weaponChoice)) {
          itemFound = true;
          userEquipsWeapon((Weapon) weapon);
        }
      }
    }
    if (!itemFound) {
      ui.printPlayerHasNoWeapon();
    }
  }

  private void userEquipsWeapon(Weapon weapon) throws InterruptedException {
    if (weaponEquipped != null) {
      ui.printWeaponAlreadyEquipped();
    } else {
      weaponEquipped = weapon;
      ui.printWeaponEquipped(weapon);
    }
  }

  public String userEatsFood(Food food) throws InterruptedException {
    int tmp = food.getHealth();
    if (tmp == 0) {
      return food + " is not edible";
    } else if (tmp < 0) {
      return "Ew something is wrong with this " + food;
    } else if (tmp > 0 && getHealth() > 100) {
      return "You're already full. Saving " + food + " for another time.";
    } else if (getHealth() == 100) {
      return "You're already full. Saving " + food + " for another time.";
    } else
    tryEatFood(food);
    return "Yummy in my tummy, this " + food + " was delicious!";
  }

  public String checkForEnemy() {

    for (Enemy enemy : playerPosition.getListOfEnemies()) {
      if (!(enemy.getEnemyEncountered())) {
        enemy.setEnemyEncountered(true);
        return "\u001B[31m" + "There's an enemy in the room! " + enemy.getEnemyName() +
            " is here!" + " He has " + enemy.getHealth() + " hp left" + "\u001B[0m" + "\n";
      }
    }
    return "";
  }

  public int checkIfRangedWeapon(Weapon weaponEquipped) {
    if (weaponEquipped instanceof MeleeWeapon) {
      return 1;
    }
    int getAvailableUses = ((RangedWeapon) weaponEquipped).getAvailableUses();
    if (getAvailableUses == 0) {
      return 0;
    } else {
      ((RangedWeapon) weaponEquipped).setAvailableUses((getAvailableUses - 1));
      return getAvailableUses;
    }
  }

  public String attack(String enemyName) throws InterruptedException {
    Thread.sleep(500);
    for (Enemy enemy : playerPosition.getListOfEnemies()) {
      int damageFromEnemy = enemy.getWeaponEquipped().getDamage();
      if (weaponEquipped == null) {
        return "You have no weapon equipped.";
      } else if (checkIfRangedWeapon(weaponEquipped) == 0) {
        setHealth((getHealth() - damageFromEnemy));
        return "You ran out of ammo." + enemy.enemyAttacks(playerPosition, enemy);
      } else if (weaponEquipped.getDamage() < 0) {
        setHealth((getHealth() - damageFromEnemy));
        return youHitYourself() + enemy.enemyAttacks(playerPosition, enemy);
      } else if (enemy.getEnemyName().toLowerCase().equals(enemyName)) {
        setHealth((getHealth() - damageFromEnemy));
        return enemy.attackedByPlayer(weaponEquipped) + "\n" + enemy.enemyAttacks(playerPosition, enemy);
      } else if (enemyName == null) {
        setHealth((getHealth() - damageFromEnemy));
        return enemy.attackedByPlayer(weaponEquipped) + "\n" + enemy.enemyAttacks(playerPosition, enemy);
      }
    }
    return "There is no enemy in this room with that name.";
  }


  public String youHitYourself() {
    setHealth((getHealth() + weaponEquipped.getDamage()));
    return "You hit yourself in confusion.. \n";
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
