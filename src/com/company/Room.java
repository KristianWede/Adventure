package com.company;

import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room n, e, s, w;
    private boolean visited;
    private boolean lockedRoom;
    private boolean discoveredDoorN;
    private boolean discoveredDoorE;
    private boolean discoveredDoorW;
    private boolean discoveredDoorS;
    private boolean isRoomDark;
    private boolean roomHasSwitch;
    private boolean roomDarkIntro;
    private ArrayList<Item> roomInventory;
    private ArrayList<Enemy> listOfEnemies = new ArrayList<>();
    private boolean bombRoom;

    private boolean itemPresent;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.roomInventory = new ArrayList<>();
        this.visited = false;
        this.discoveredDoorN = false;
        this.discoveredDoorE = false;
        this.discoveredDoorW = false;
        this.discoveredDoorS = false;
        this.lockedRoom = false;
        this.isRoomDark = false;
        this.roomHasSwitch = false;
        this.roomDarkIntro = false;
        this.itemPresent = false;
    }


    //Getters

    public ArrayList<Item> getRoomInventory() {
        return roomInventory;
    }


    public boolean isRoomDarkIntro() {
        return roomDarkIntro;
    }

    public boolean isRoomHasSwitch() {
        return roomHasSwitch;
    }

    public boolean isRoomDark() {
        return isRoomDark;
    }

    public boolean isLockedRoom() {
        return lockedRoom;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Room getN() {
        return n;
    }

    public Room getE() {
        return e;
    }

    public Room getS() {
        return s;
    }

    public Room getW() {
        return w;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isDiscoveredDoorN() {
        return discoveredDoorN;
    }

    public boolean isDiscoveredDoorE() {
        return discoveredDoorE;
    }

    public boolean isDiscoveredDoorW() {
        return discoveredDoorW;
    }

    public boolean isDiscoveredDoorS() {
        return discoveredDoorS;
    }

    //Setters


    public void addRoomInventory(Item item) {
        this.roomInventory.add(item);
    }

    public void setRoomDarkIntro(boolean roomDarkIntro) {
        this.roomDarkIntro = roomDarkIntro;
    }

    public void setRoomHasSwitch(boolean roomHasSwitch) {
        this.roomHasSwitch = roomHasSwitch;
    }

    public void setRoomDark(boolean roomDark) {
        isRoomDark = roomDark;
    }

    public void setLockedRoom(boolean lockedRoom) {
        this.lockedRoom = lockedRoom;
    }

    public void setDiscoveredDoorN(boolean discoveredDoorN) {
        this.discoveredDoorN = discoveredDoorN;
    }

    public void setDiscoveredDoorE(boolean discoveredDoorE) {
        this.discoveredDoorE = discoveredDoorE;
    }

    public void setDiscoveredDoorW(boolean discoveredDoorW) {
        this.discoveredDoorW = discoveredDoorW;
    }

    public void setDiscoveredDoorS(boolean discoveredDoorS) {
        this.discoveredDoorS = discoveredDoorS;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setN(Room n) {
        this.n = n;
    }

    public void setE(Room e) {
        this.e = e;
    }

    public void setS(Room s) {
        this.s = s;
    }

    public void setW(Room w) {
        this.w = w;
    }

    public ArrayList<Enemy> getListOfEnemies() {
        return listOfEnemies;
    }

    public void addEnemy(Enemy enemy){
        listOfEnemies.add(enemy);
    }

    public boolean isBombRoom() {
        return bombRoom;
    }

    public void setBombRoom(boolean bombRoom) {
        this.bombRoom = bombRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", visited=" + visited +
                ", lockedRoom=" + lockedRoom +
                ", isRoomDark=" + isRoomDark +
                ", roomHasSwitch=" + roomHasSwitch +
                ", roomDarkIntro=" + roomDarkIntro +
                ", hasItem=" + itemPresent +
                "roomInventory" + roomInventory + '}';
    }
}