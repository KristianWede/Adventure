package com.company;

import java.util.ArrayList;

public class Player {

    private Room playerPosition;
    private UserInterface ui;

    public void loadUserInterface(){
        ui = new UserInterface();
    }


    private ArrayList<Item> playerInventory = new ArrayList<>();




    public void setPlayerPosition(Room room){
        playerPosition = room;
    }

    //Setter
    public void addItemToPlayerInventory(String searchWord,Room room) {
            for (int i = 0; i < room.getRoomInventory().size(); i++) {
                Item tmp = room.getRoomInventory().get(i);
                if (tmp.getItemName().contains(searchWord)) {
                    playerInventory.add(tmp);
                    ui.printAddedItemInventory(tmp);
                    room.getRoomInventory().remove(tmp);
                } else if (i == room.getRoomInventory().size()-1){
                    ui.printErrorCannotFindItem();
                }
            }
    }

    public void removeItemFromPlayerInventory(String searchWord,Room room) {
        for (int i = 0; i < playerInventory.size(); i++) {
                Item tmp = playerInventory.get(i);
                if (tmp.getItemName().contains(searchWord)) {
                    room.getRoomInventory().add(tmp);
                    ui.printAddedItemRoom(tmp);
                    playerInventory.remove(tmp);
                } else if (i == room.getRoomInventory().size()-1){
                    ui.printErrorCannotFindItem();
                }
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
