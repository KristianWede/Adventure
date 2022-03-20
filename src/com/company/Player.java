package com.company;

import java.util.ArrayList;

public class Player {

    private Room playerPosition;

    private ArrayList<Item> playerInventory = new ArrayList<>();

    public void setPlayerPosition(Room room){
        playerPosition = room;
    }

    //Getter
    public ArrayList<Item> itemsAtPlayerPosition(Room room){
        return room.getRoomInventory();
    }

    public Room getPlayerPosition(){
        return playerPosition;
    }

}
