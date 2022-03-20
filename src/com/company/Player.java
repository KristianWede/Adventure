package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {

    private Room playerPosition;

    private ArrayList<Item> playerInventory = new ArrayList<>();




    public void setPlayerPosition(Room room){
        playerPosition = room;
    }

    //Setter
    public void addItemToPlayerInventory(ArrayList<Item> playerInventory, Room room) {
        for (int i = 0; i < room.getRoomInventory().size(); i++) {
            playerInventory.add(room.getRoomInventory().get(i));
            room.setRoomInventory(playerPosition.getRoomInventory());
            this.playerInventory = playerInventory;
        }
    }

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
