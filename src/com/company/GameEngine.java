package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class GameEngine {
    //Initializes world map.
    private WorldCreator creator;
    private Music music;
    private UserInterface ui;
    private Player player;

    private Room requestedRoomPos;
    private Room entangledRoom;
    private Room tempEntangledRoom;
    Scanner sc = new Scanner(System.in);

    public void printAvailableDoors() {
        //At the start tries to narrow down the doors that actually exist and then "unlocking" them by making them visible to the player if they've been there before, and then tell them.
        if (player.getPlayerPosition().isDiscoveredDoorN()) {
            ui.printDoorNorthAvailable();
        }
        if (player.getPlayerPosition().isDiscoveredDoorE()) {
            ui.printDoorEastAvailable();
        }
        if (player.getPlayerPosition().isDiscoveredDoorW()) {
            ui.printDoorWestAvailable();
        }
        if (player.getPlayerPosition().isDiscoveredDoorS()) {
            ui.printDoorSouthAvailable();
        }
    }

    public void roomArt() {
        if (player.getPlayerPosition() == creator.getStarterRoom()) {

        }
    } //Unused for the time being. //TODO: Add graphics for each scene. SCRAPPED

    public void lightsAreOff() {
        if (player.getPlayerPosition().isRoomDarkIntro()) {
            ui.giveDescription(player.getPlayerPosition());
            player.getPlayerPosition().setRoomDarkIntro(false);
        } else {
            ui.printPlayerReactionDark();
        }
    }

    public void magicWord() {
        //Xyzzy "sussy" magic word
        //First teleports the player from anywhere on the map to room1.
        //Then it saves the place from which the player comes from.
        //The magic word can now be used to set a new teleport point anywhere on the map and swap back and forth.
        if (player.getPlayerPosition() == entangledRoom) {
            ui.printPlayerReactionTeleNothing();
        } else if (entangledRoom == creator.getStarterRoom()) {
            entangledRoom = player.getPlayerPosition();
            player.setPlayerPosition(creator.getStarterRoom());
            ui.printPlayerReactionTeleFirstRoom();
        } else {
            tempEntangledRoom = entangledRoom;
            entangledRoom = player.getPlayerPosition();
            player.setPlayerPosition(tempEntangledRoom);
            ui.printPlayerTeleported();
            System.out.println(player.getPlayerPosition().getName());
        }
    }

    public String userCheckHealth() {
        int health = player.getHealth();
        if (health >= 25 && health <= 50) {
            return "\u001B[33m" + "You have " + health + " hp left. Avoid combat if possible and find some food! " + "\u001B[0m";
        } else if (health >= 1 && health < 25) {
            return "\u001B[31m" + "Health is critical! You only have " + health + "hp left. Avoid combat by all means and find some food!" + "\u001B[0m";
        } else if (health > 50 && health < 100) {
            return "\u001B[32m" + "You are in great shape! You have " + health + " hp left!" + "\u001B[0m";

        } else if (health == 100) {
            return "You have max health!";
        } else {
            ui.printPlayerHasDied();
            exitGame();
        }
        return "";
    }

    public String warnWhenLowHp() {
        if (player.getHealth() < 50) {
            return userCheckHealth();
        }
        return "";
    }

    public void userInputCaseDirection(String direction) {

        switch (direction) {
            case "north", "n" -> userInputCaseNorth();
            case "south", "s" -> userInputCaseSouth();
            case "east", "e" -> userInputCaseEast();
            case "west", "w" -> userInputCaseWest();

            default -> ui.printUserNotDeclaringDirection();
        }
    }


    public void userInputCaseNorth() {
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (player.getPlayerPosition().getN() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = player.getPlayerPosition().getN();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesNorth();
                //Makes an exception for Room1, so Room1 is already known.
                if (player.getPlayerPosition() == creator.getStarterRoom()) {
                    player.getPlayerPosition().setVisited(true);
                }
                //Sets known doors to discovered since the player has entered both doors in a single move. (Lets the entered door and exited door known.)
                player.getPlayerPosition().setDiscoveredDoorN(true);
                requestedRoomPos.setDiscoveredDoorS(true);
                player.setPlayerPosition(requestedRoomPos);
                //Checks if the room is dark, if it is, it doesn't display any description or name. <-NO
                //Room 3 should have 2 states for name and description.
                //One for each when the lights are off in the room.
                //One for each when the lights are on in the room.
                if (player.getPlayerPosition().isRoomDark()) {
                    lightsAreOff();
                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!player.getPlayerPosition().isVisited()) {
                    player.getPlayerPosition().setVisited(true);
                    System.out.println(player.getPlayerPosition().getDescription());
                    printAvailableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    printAvailableDoors();
                }
            }
        }
    }

    public void userInputCaseSouth() {
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (player.getPlayerPosition().getS() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = player.getPlayerPosition().getS();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesSouth();
                if (player.getPlayerPosition() == creator.getStarterRoom()) {
                    player.getPlayerPosition().setVisited(true);
                }
                player.getPlayerPosition().setDiscoveredDoorS(true);
                player.setPlayerPosition(player.getPlayerPosition().getS());
                player.getPlayerPosition().setDiscoveredDoorN(true);
                //Checks if the room is dark, if it is, it doesn't display any description or name.
                if (player.getPlayerPosition().isRoomDark()) {
                    lightsAreOff();

                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!player.getPlayerPosition().isVisited()) {
                    player.getPlayerPosition().setVisited(true);
                    System.out.println(player.getPlayerPosition().getDescription());
                    printAvailableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    printAvailableDoors();
                }
            }
        }
    }

    public void userInputCaseEast() {
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (player.getPlayerPosition().getE() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = player.getPlayerPosition().getE();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesEast();
                if (player.getPlayerPosition() == creator.getStarterRoom()) {
                    player.getPlayerPosition().setVisited(true);
                }
                player.getPlayerPosition().setDiscoveredDoorE(true);
                player.setPlayerPosition(player.getPlayerPosition().getE());
                player.getPlayerPosition().setDiscoveredDoorW(true);
                //Checks if the room is dark, if it is, it doesn't display any description or name.
                if (player.getPlayerPosition().isRoomDark()) {
                    lightsAreOff();

                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!player.getPlayerPosition().isVisited()) {
                    player.getPlayerPosition().setVisited(true);
                    System.out.println(player.getPlayerPosition().getDescription());
                    printAvailableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    printAvailableDoors();
                }
            }
        }
    }

    public void userInputCaseWest() {
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (player.getPlayerPosition().getW() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = player.getPlayerPosition().getW();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesWest();
                if (player.getPlayerPosition() == creator.getStarterRoom()) {
                    player.getPlayerPosition().setVisited(true);
                }
                player.getPlayerPosition().setDiscoveredDoorW(true);
                player.setPlayerPosition(player.getPlayerPosition().getW())

                ;
                player.getPlayerPosition().setDiscoveredDoorE(true);
                //Checks if the room is dark, if it is, it doesn't display any description or name.
                if (player.getPlayerPosition().isRoomDark()) {
                    lightsAreOff();

                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!player.getPlayerPosition().isVisited()) {
                    player.getPlayerPosition().setVisited(true);
                    System.out.println(player.getPlayerPosition().getDescription());
                    printAvailableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    printAvailableDoors();
                }
            }
        }
    }

    public void userInputCaseLook() {
        //Checks if the room is dark, if it is, it doesn't display any description or name.
        if (isRoomDark()) {
            lightsAreOff();
        } else {
            ui.printPlayerLooksAround();
            System.out.println(player.getPlayerPosition().getDescription());
            System.out.println();
            if (doesRoomHaveItem()) {
                ui.printReactionToFoundItem(player.getPlayerPosition());
            }
        }
    }

    public void userInputCaseLookItem() {
        //Checks if the room has items
        if (doesPlayerHaveItems()) {
            ui.printInventory(player.getPlayerInventory());
        } else {
            ui.printPlayerHasNoItems();
        }
    }

    public void userInputDropItem(String searchWord) {
        if (searchWord != null) {
            if (doesPlayerHaveItems()) {
                player.removeItemFromPlayerInventory(searchWord, player.getPlayerPosition());
            } else {
                ui.printPlayerHasNoItems();
            }
        } else {
            ui.printUserNothingToDrop();
        }

    }

    public boolean doesPlayerHaveItems() {
        if (player.getPlayerInventory().size() != 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean doesRoomHaveItem() {
        if (player.getPlayerPosition().getRoomInventory().size() != 0) {
            return true;
        } else {
            return false;
        }
    }


    public String scannerReturnToLowerCase() {
        Scanner sc = new Scanner(System.in);
        String searchWord = sc.nextLine().toLowerCase();
        return searchWord;
    }

    public boolean isRoomDark() {
        if (player.getPlayerPosition().isRoomDark()) {
            return true;
        } else {
            return false;
        }
    }

    public void exitGame() {
        System.exit(0);
    }

    public void userInputCaseOnUnlock() {
        if (requestedRoomPos != null) {
            if (requestedRoomPos.isLockedRoom()) {
                requestedRoomPos.setLockedRoom(false);
                ui.printDoorUnlocked();
            } else if (!requestedRoomPos.isLockedRoom()) {
                ui.printNothingToUnlock();
            }
        } else {
            ui.printNothingToUnlock();
        }
    }

    public void userInputCaseOnLightOn() {
        if (player.getPlayerPosition().isRoomHasSwitch()) {
            ui.printFoundLightswitch();
            if (player.getPlayerPosition().isRoomDark()) {
                player.getPlayerPosition().setRoomDark(false);
                //Not very effective.
                player.getPlayerPosition().setDescription("""
                        You turn on the lightswitch next to you and as you turn on the lights you realize how big the room really is. 
                        It must be at least 200x200 meters with more than 20 meters to the ceiling. 
                        You see a lot of shelves, almost all of them are empty as if someone looted the place.
                        """);
                System.out.println(player.getPlayerPosition().getDescription());
            } else {
                ui.printLightIsOn();
            }
        } else {
            ui.printNoLightSwitch();
        }
    }

    public void userInputTakeItem(String searchWord) {
        if (searchWord != null) {
            if (!isRoomDark()) {
                if (doesRoomHaveItem()) {
                    player.addItemToPlayerInventory(searchWord, player.getPlayerPosition());
                } else {
                    ui.printNoItemsOnGround();
                }
            } else {
                ui.printPlayerReactionDark();
            }
        } else {
            ui.printUserNothingToTake();
        }
    }

    public void userInputCaseOnLightOff() {
        if (player.getPlayerPosition().isRoomHasSwitch()) {
            ui.printFoundLightswitch();
            if (!player.getPlayerPosition().isRoomDark()) {
                player.getPlayerPosition().setRoomDark(true);
                ui.printTurnOffLight();
            } else {
                ui.printLightIsOff();
            }
        } else {
            ui.printNoLightSwitch();
        }
    }

    public void userInputCaseInspectItem() {
        if (doesPlayerHaveItems()) {
            ui.printPlayerActionOpenInventory();
            player.inspectItemFromInventory();
        } else {
            ui.printPlayerHasNoItems();
        }
    }

    public void equipCheckForWeapon(String searchWord) {
        if (searchWord != null) {
            if (doesPlayerHaveItems()) {
                player.whichWeapon(searchWord);
            }
        } else ui.errorMessageInvalidMove();
    }

    private void unEquipCheckForWeapon(String weapon) {
        if (weapon != null) {
            if (player.weaponEquipped != null) {
                player.weaponEquipped = null;
                for (int i = 0; i < player.getPlayerInventory().size(); i++) {
                    Weapon weaponChoice = (Weapon) player.getPlayerInventory().get(i);

                    weaponChoice.getItemName().toLowerCase().contains(weapon);
                    ui.printUnEquip(weaponChoice);
                }
            }
        } else ui.printUserNothingToEquip();
    }

    public void execute() throws InterruptedException {
        // Part 1: The room.

        creator = new WorldCreator();
        music = new Music();
        ui = new UserInterface();
        player = new Player();

        //Starting program by "loading" the variables of the Rooms and positions of Rooms inside Room class.
        creator.createWorldMap();
        player.setPlayerPosition(creator.getStarterRoom());
        entangledRoom = creator.getStarterRoom();
        player.loadUserInterfaceInPlayer();
        player.loadGameEngineInPlayer();

//    music.playBackground();

        ui.clearScreen();

        ui.mainMenu();

        ui.clearScreen();

        ui.introduction();

        //UserInput processes input from user and translates into action. (Example; 'go south' will change currentRoom to the one field below it.)
        userChoice();

    }


    public String findCommand(String decision) {
        if (decision.contains(" ")) {
            return decision.substring(0, decision.indexOf(" ")).toLowerCase();
        } else {
            return decision;
        }
    }

    public String findSomething(String decision) {
        if (decision.contains(" ")) {
            return decision.substring(decision.indexOf(" ") + 1).toLowerCase();
        } else {
            return null;
        }
    }

    public void userChoice() {
        do {
            ui.printString(player.checkForEnemy());
            player.checkForEnemy();
            ui.printString(warnWhenLowHp());
            ui.askPlayerForInput();
            String decision = scannerReturnToLowerCase();
            ui.clearScreen();

            String command = findCommand(decision);
            String findSomething = findSomething(decision);
            switch (command) {
                case "go" -> userInputCaseDirection(findSomething);
                case "look", "see" -> userInputCaseLook();
                case "help", "info", "information" -> ui.userInputCaseHelp();
                case "exit", "leave", "shutdown", "end" -> {
                    ui.userInputCaseExit();
                    exitGame();
                }
                case "unlock" -> userInputCaseOnUnlock();
                case "on", "lightswitch", "turn on light", "lights on", "flip switch" -> userInputCaseOnLightOn();
                case "turn off light", "turn off", "off", "turn off lightswitch", "off lightswitch" -> userInputCaseOnLightOff();
                case "take" -> userInputTakeItem(findSomething);
                case "inventory", "backpack", "check inventory", "inv", "look at items" -> userInputCaseLookItem();
                case "drop" -> userInputDropItem(findSomething);
                case "inspect", "check" -> userInputCaseInspectItem();
                case "connor", "connar", "get to the chopper" -> magicWord();
                case "health", "hp", "status", "how do i feel", "heal", "am i hurt" -> ui.printString(userCheckHealth());
                case "eat", "eat food", "snack time", "nomnom", "eat item", "consume" -> player.whichFood(findSomething);
                case "equip", "this is sparta", "prepare for battle", "aim" -> equipCheckForWeapon(findSomething);
                case "unequip" -> unEquipCheckForWeapon(findSomething);
                case "attack", "kill", "fire", "launch" -> ui.printString(player.attack(findSomething));
                default -> ui.errorMessageInvalidMove();
            }
        } while (true);
    }
}