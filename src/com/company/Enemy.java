package com.company;

import java.util.ArrayList;

public class Enemy {
    private Room enemyPosition;
    private UserInterface ui;
    private GameEngine game;
    protected int health = 100;
    protected Weapon weaponEquipped;
    protected String enemyName;

    public Enemy(String enemyName, Room enemyPosition, int health, Weapon weaponEquipped) {
        this.enemyPosition = enemyPosition;
        this.health = health;
        this.weaponEquipped = weaponEquipped;
        this.enemyName = enemyName;
    }

    public String enemyName(){
        return enemyName;
    }

    public Room getEnemyPosition() {
        return enemyPosition;
    }


    public void setEnemyPosition(Room enemyPosition) {
        this.enemyPosition = enemyPosition;
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

    public String getEnemyName(){
        return enemyName;
    }

    @Override
    public String toString() {
        return enemyName + " ," + weaponEquipped;
    }
}
