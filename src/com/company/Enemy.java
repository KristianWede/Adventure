package com.company;

import java.util.ArrayList;

public class Enemy {
    private Room enemyPosition;
    private UserInterface ui;
    private GameEngine game;
    private int health = 100;
    private Weapon weaponEquipped;
    private String enemyName;
    private boolean enemyEncountered = false;

    public Enemy(String enemyName, Room enemyPosition, int health, Weapon weaponEquipped) {
        this.enemyPosition = enemyPosition;
        this.health = health;
        this.weaponEquipped = weaponEquipped;
        this.enemyName = enemyName;
    }

    public boolean getEnemyEncountered(){
        return enemyEncountered;
    }

    public void setEnemyEncountered(boolean enemyEncountered){
        this.enemyEncountered = enemyEncountered;
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

    public String getEnemyName() {
        return enemyName;
    }

    @Override
    public String toString() {
        return enemyName + " ," + weaponEquipped;
    }
}
