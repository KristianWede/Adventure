package com.company;

import java.util.ArrayList;

public class Enemy {
  private int health = 100;
  private Weapon weaponEquipped;
  private String enemyName;
  private boolean enemyEncountered = false;

  public Enemy(String enemyName, int health, Weapon weaponEquipped) {
    this.health = health;
    this.weaponEquipped = weaponEquipped;
    this.enemyName = enemyName;
  }

  public String enemyDead() {
    return "You have killed " + enemyName + "!";
  }

  public String attackedByPlayer(Weapon weapon) {
    setHealth(getHealth() - weapon.getDamage());
    /*if (getHealth() <= 0) {
      return enemyDead();*/
//            System.out.println("You have killed the enemy!" + "\n");
//        System.out.println("You attacked " + enemyName + ". He took " + weapon.getDamage() + " hp worth of damage.");
    return "You attacked " + enemyName + ". He took " + weapon.getDamage() + " hp worth of damage. He now has " + getHealth() + " hp left";
  }

  public String enemyAttacks() {
    if (getHealth() <= 0) {
      return enemyDead();
    }
//        System.out.println("\u001B[33m" + getEnemyName() + " attacked you with his " + getWeaponEquipped().getItemName() + " and you took " + getWeaponEquipped().getDamage() + " damage." + "\u001B[0m");
    else {
      return "\u001B[33m" + getEnemyName() + " attacked you with his " + getWeaponEquipped().getItemName() + " and you took " + getWeaponEquipped().getDamage() + " damage." + "\u001B[0m";
    }
  }


  public boolean getEnemyEncountered() {
    return enemyEncountered;
  }

  public void setEnemyEncountered(boolean enemyEncountered) {
    this.enemyEncountered = enemyEncountered;
  }


  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public Weapon getWeaponEquipped() {
    return weaponEquipped;
  }

  public void setWeaponEquipped(Weapon weaponEquipped) {
    this.weaponEquipped = weaponEquipped;
  }

  public String getEnemyName() {
    return enemyName;
  }

  @Override
  public String toString() {
    return enemyName + " ," + weaponEquipped;
  }
}
