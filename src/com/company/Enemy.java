package com.company;

public class Enemy {
    private Room enemyPosition;
    private UserInterface ui;
    private GameEngine game;
    protected int health = 100;
    protected Weapon weaponEquipped;

    public Enemy(Room enemyPosition, int health, Weapon weaponEquipped) {
        this.enemyPosition = enemyPosition;
        this.health = health;
        this.weaponEquipped = weaponEquipped;
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


}
