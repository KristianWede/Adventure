package com.company;

import java.util.ArrayList;

public class Player {

    private Room playerPosition;

    private ArrayList<Item> playerInventory = new ArrayList<>();

    public void setPlayerPosition(Room room){
        playerPosition = room;
    }


    public Room getPlayerPosition(){
        return playerPosition;
    }

}
