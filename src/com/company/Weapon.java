package com.company;

public class Weapon extends Item {

  private final int damage;

  public Weapon (String weaponName, String weaponDescription, int damage){
    super(weaponName,weaponDescription);
    this.damage = damage;
  }
}
