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
        for (int i = 0; i < playerInventory.size(); i++){
            //playerInventory.add(room.getRoomInventory().indexOf(i));
        }

        //this.playerInventory = playerInventory.add(room.getRoomInventory());
    }

    //Getter
    public ArrayList<Item> itemsAtPlayerPosition(Room room){
        return room.getRoomInventory();
    }


    public Room getPlayerPosition(){
        return playerPosition;
    }

}
