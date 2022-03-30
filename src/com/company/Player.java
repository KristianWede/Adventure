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

    private void userEquipsWeapon(Weapon weapon) {
        if (weaponEquipped != null) {
            ui.printWeaponAlreadyEquipped();
        } else {
            weaponEquipped = weapon;
            ui.printWeaponEquipped(weapon);
        }
    }

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

    public void lookForEnemy(ArrayList<Enemy> listOfEnemies) {
        game.checkForEnemy(listOfEnemies, getPlayerPosition());
        for (int i = 0; i < listOfEnemies.size(); i++) {
            Room tmp = listOfEnemies.get(i).getEnemyPosition();
        if (tmp == playerPosition){
        setHealth(getHealth() - listOfEnemies.get(i).getWeaponEquipped().getDamage());
        System.out.println( "\u001B[33m" + listOfEnemies.get(i).getEnemyName() + " attacked you with his " + listOfEnemies.get(i).getWeaponEquipped().getItemName() + " and you took " + listOfEnemies.get(i).getWeaponEquipped().getDamage() + " damage." + "\u001B[0m");
    }
        }
    }

    public void attack(ArrayList<Enemy> listOfEnemies) {
        if (game.enemyFound && weaponEquipped != null) {
            for (int i = 0; i < listOfEnemies.size(); i++) {
                Room tmp = listOfEnemies.get(i).getEnemyPosition();
                if (tmp == playerPosition) {
                    listOfEnemies.get(i).setHealth(listOfEnemies.get(i).getHealth() - weaponEquipped.getDamage());
                    System.out.println("You hit " + listOfEnemies.get(i).getEnemyName() + " and gave him " +  weaponEquipped.getDamage() + " hp worth of damage." );
                }

            }
        }

        else if (weaponEquipped == null) {
            ui.noWeaponEquipped();
        }
        else {
            ui.printErrorAttack();
        }
    }

    public void enemyAttacks(){

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
