package com.company;

public class Weapon extends Item {

    protected int damage;

    public Weapon(String weaponName, String weaponDescription, int damage) {
        super(weaponName, weaponDescription);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}
