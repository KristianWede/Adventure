package com.company;

public class Weapon extends Item {

  public Weapon (String weaponName, String weaponDescription, int damage){
    super(weaponName,weaponDescription);
    this.damage = damage;
  }
}
