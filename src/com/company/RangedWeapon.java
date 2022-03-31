package com.company;

public class RangedWeapon extends Weapon {
  private int availableUses;

  public RangedWeapon(String weaponName, String weaponDescription, int damage, int availableUses) {
    super(weaponName, weaponDescription, damage);
    this.availableUses = availableUses;
  }

  public int getAvailableUses() {
    return availableUses;
  }
  public void setAvailableUses(int availableUses) {
    this.availableUses = availableUses;
  }

}
