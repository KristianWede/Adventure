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
    /* //TODO: User input for Adding an item to the player's inventory.
    public void addItemToPlayerInventory(ArrayList<Item> playerInventory, Room room, WorldCreator creator) {
        for (int i = 0; i < room.getRoomInventory().size(); i++) {



        }





        if (itemName == creator.key.itemName) {
            for (int i = 0; i < room.getRoomInventory().size(); i++) {
                playerInventory.add(room.getRoomInventory().get(i));
                room.setRoomInventory(playerPosition.getRoomInventory());
                this.playerInventory = playerInventory;
            }
        }
    }

     */

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
