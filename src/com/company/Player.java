package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

    private Room playerPosition;

    private ArrayList<Item> playerInventory = new ArrayList<>();




    public void setPlayerPosition(Room room){
        playerPosition = room;
    }

    //Setter
    // TODO: User input for Adding an item to the player's inventory.
    public void addItemToPlayerInventory(String searchWord,Room room) {
            for (int i = 0; i < room.getRoomInventory().size(); i++) {
                Item tmp = room.getRoomInventory().get(i);
                if (tmp.getItemName().contains(searchWord)) {
                    playerInventory.add(tmp);
                    System.out.println("Added " + tmp + " to player inventory");
                    room.getRoomInventory().remove(tmp);
                    System.out.println("Removed " + tmp + "from room inventory.");
                } else if (i == room.getRoomInventory().size()-1){
                    System.out.println("Couldn't find any items with that name! Try again!");
                }
            }
    }


    /* //TODO: User input for removing an item from the player's inventory.
    public void removeItemFromPlayerInventory(ArrayList<Item> playerInventory, Room room, String search) {
        for (int i = 0; i < room.getRoomInventory().size(); i++) {

            room.setRoomInventory(playerInventory.);
            playerInventory.remove(room.getRoomInventory().get(i));
            //this.playerPosition
        }
    }
    */


    //Getter
    public ArrayList<Item> itemsAtPlayerPosition(Room room){
        return room.getRoomInventory();
    }

    public ArrayList<Item> getPlayerInventory(){
        return playerInventory;
    }


    public Room getPlayerPosition(){
        return playerPosition;
    }

}
