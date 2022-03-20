package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {
    //Initializes world map.
    private WorldCreator creator;
    private Music music;
    private UserInterface ui;
    private Player player;
    private Item item;

    private Room requestedRoomPos;
    private Room entangledRoom;
    private Room tempEntangledRoom;

    //Put room1 since it's used elsewhere to compare to a starting point and exceptions.

    public void availableDoors() {
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
    } //Unused for the time being. //TODO: Add graphics for each scene.

    public void lightsAreOff() {
        if (player.getPlayerPosition().isRoomDarkIntro()) {
            ui.giveDescription(player.getPlayerPosition());
            player.getPlayerPosition().setRoomDarkIntro(false);
        } else {
            ui.printPlayerReactionDark();
        }
    }

    public void magicWord() {
        //Xyzzy magic word
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
                    availableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    availableDoors();
                    roomArt();
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
                    availableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    availableDoors();
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
                    availableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    availableDoors();
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
                    availableDoors();
                } else {
                    System.out.println(player.getPlayerPosition().getName());
                    availableDoors();
                }
            }
        }
    }

    public void userInputCaseLook() {
        //Checks if the room is dark, if it is, it doesn't display any description or name.
        if (player.getPlayerPosition().isRoomDark()) {
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
        if (doesPlayerHaveItems()){
            ui.printInventory(player.getPlayerInventory());
        } else {
            ui.printPlayerHasNoItems();
        }
    }


    public boolean doesPlayerHaveItems(){
        if (player.getPlayerInventory() != null){
            return true;
        } else {
            return false;
        }
    }

    public boolean doesRoomHaveItem() {
        if (player.getPlayerPosition().isItemPresent()) {
            return true;
        } else {
            return false;
        }
    }

        public void exitGame () {
            System.exit(0);
        }

        public void userInputCaseOnUnlock () {
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

        public void userInputCaseOnLightOn () {
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

        public void userInputTakeItem () {
            if (doesRoomHaveItem()) {
                    ui.printReactionPickUp(player.getPlayerPosition());
                    player.addItemToPlayerInventory(player.getPlayerInventory(), player.getPlayerPosition());
                    player.getPlayerPosition().setItemPresent(false);
                } else {
                    ui.printNoItemsOnGround();
                }
            }


        public void userInputCaseOnLightOff () {
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

        public void execute () throws InterruptedException {
            // Part 1: The room.

            creator = new WorldCreator();
            music = new Music();
            ui = new UserInterface();
            player = new Player();

            //Starting program by "loading" the variables of the Rooms and positions of Rooms inside Room class.
            creator.createWorldMap();
            player.setPlayerPosition(creator.getStarterRoom());
            entangledRoom = creator.getStarterRoom();


            music.playMusic();

            ui.mainMenu();

            ui.clearScreen();

            ui.introduction();

            //UserInput processes input from user and translates into action. (Example; 'go south' will change currentRoom to the one field below it.)
            userChoice();
        }

        public String userChoice () {
            Scanner sc = new Scanner(System.in);
            do {
                ui.askPlayerForInput();
                String decision = sc.nextLine().toLowerCase();
                ui.clearScreen();
                switch (decision) {
                    case "go north", "north", "n" -> userInputCaseNorth();
                    case "go south", "south", "s" -> userInputCaseSouth();
                    case "go east", "east", "e" -> userInputCaseEast();
                    case "go west", "west", "w" -> userInputCaseWest();
                    case "look", "see", "look around" -> userInputCaseLook();
                    case "help", "info", "information" -> ui.userInputCaseHelp();
                    case "exit", "get out", "leave", "shutdown", "game end" -> {
                        ui.userInputCaseExit();
                        exitGame();
                    }
                    case "unlock", "unlock door" -> userInputCaseOnUnlock();
                    case "turn on light", "turn on", "on" -> userInputCaseOnLightOn();
                    case "turn off light", "turn off", "off" -> userInputCaseOnLightOff();
                    case "pick up", "pick up item", "take", "take everything", "take all" -> userInputTakeItem();
                    case "inventory", "backpack" , "check inventory", "inv", "look at item" -> userInputCaseLookItem();
                    //case "drop", "throw away", "drop it" ->
                    case "connor", "connar", "get to the chopper" -> magicWord();
                    default -> ui.errorMessageInvalidMove();
                }
            } while (true);
        }
    }