package com.company;

import java.util.Scanner;

public class ProgramFlow {
    //Initializes world map.
    private WorldCreator creator;
    private Music music;
    private UserInterface ui;

    private Room playerPos;
    private Room requestedRoomPos;
    private Room entangledRoom;
    private Room tempEntangledRoom;

    //Put room1 since it's used elsewhere to compare to a starting point and exceptions.

    public void availableDoors() {
        //At the start tries to narrow down the doors that actually exist and then "unlocking" them by making them visible to the player if they've been there before, and then tell them.
        if (playerPos.isDiscoveredDoorN()) {
            ui.printDoorNorthAvailable();
        }
        if (playerPos.isDiscoveredDoorE()) {
            ui.printDoorEastAvailable();
        }
        if (playerPos.isDiscoveredDoorW()) {
            ui.printDoorWestAvailable();
        }
        if (playerPos.isDiscoveredDoorS()) {
            ui.printDoorSouthAvailable();
        }
    }

    public void roomArt() {
        if (playerPos == creator.getStarterRoom()) {

        }
    } //Unused for the time being. //TODO: Add graphics for each scene.

    public void lightsAreOff() {
        if (playerPos.isRoomDarkIntro()) {
            ui.giveDescription(playerPos);
            playerPos.setRoomDarkIntro(false);
        } else {
            ui.printPlayerReactionDark();
        }
    }

    public void magicWord() {
        //Xyzzy magic word
        //First teleports the player from anywhere on the map to room1.
        //Then it saves the place from which the player comes from.
        //The magic word can now be used to set a new teleport point anywhere on the map and swap back and forth.
        if (playerPos == entangledRoom) {
            ui.printPlayerReactionTeleNothing();
        } else if (entangledRoom == creator.getStarterRoom()) {
            entangledRoom = playerPos;
            playerPos = creator.getStarterRoom();
            ui.printPlayerReactionTeleFirstRoom();
        } else {
            tempEntangledRoom = entangledRoom;
            entangledRoom = playerPos;
            playerPos = tempEntangledRoom;
            ui.printPlayerTeleported();
            ui.giveName(playerPos);
        }
    }


    public void userInputCaseNorth(){
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (playerPos.getN() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = playerPos.getN();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesNorth();
                //Makes an exception for Room1, so Room1 is already known.
                if (playerPos == creator.getStarterRoom()) {
                    playerPos.setVisited(true);
                }
                //Sets known doors to discovered since the player has entered both doors in a single move. (Lets the entered door and exited door known.)
                playerPos.setDiscoveredDoorN(true);
                requestedRoomPos.setDiscoveredDoorS(true);
                playerPos = requestedRoomPos;
                //Checks if the room is dark, if it is, it doesn't display any description or name. <-NO
                //Room 3 should have 2 states for name and description.
                //One for each when the lights are off in the room.
                //One for each when the lights are on in the room.
                if (playerPos.isRoomDark()) {
                    lightsAreOff();
                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!playerPos.isVisited()) {
                    playerPos.setVisited(true);
                    ui.giveDescription(playerPos);
                    availableDoors();
                } else {
                    ui.giveName(playerPos);
                    availableDoors();
                    roomArt();
                }
            }
        }

    }

    public void userInputCaseSouth(){
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (playerPos.getS() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = playerPos.getS();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesSouth();
                if (playerPos == creator.getStarterRoom()) {
                    playerPos.setVisited(true);
                }
                playerPos.setDiscoveredDoorS(true);
                playerPos = playerPos.getS();
                playerPos.setDiscoveredDoorN(true);
                //Checks if the room is dark, if it is, it doesn't display any description or name.
                if (playerPos.isRoomDark()) {
                    lightsAreOff();

                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!playerPos.isVisited()) {
                    playerPos.setVisited(true);
                    ui.giveDescription(playerPos);
                    availableDoors();
                } else {
                    ui.giveName(playerPos);
                    availableDoors();
                }
            }
        }
    }

    public void userInputCaseEast(){
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (playerPos.getE() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = playerPos.getE();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesEast();
                if (playerPos == creator.getStarterRoom()) {
                    playerPos.setVisited(true);
                }
                playerPos.setDiscoveredDoorE(true);
                playerPos = playerPos.getE();
                playerPos.setDiscoveredDoorW(true);
                //Checks if the room is dark, if it is, it doesn't display any description or name.
                if (playerPos.isRoomDark()) {
                    lightsAreOff();

                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!playerPos.isVisited()) {
                    playerPos.setVisited(true);
                    ui.giveDescription(playerPos);
                    availableDoors();
                } else {
                    ui.giveName(playerPos);
                    availableDoors();
                }
            }
        }
    }

    public void userInputCaseWest(){
        //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
        if (playerPos.getW() == null) {
            ui.printPathBlocked();
        } else {
            //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
            requestedRoomPos = playerPos.getW();
            if (requestedRoomPos.isLockedRoom()) {
                ui.printDoorIsLocked();
            } else {
                ui.printPlayerGoesWest();
                if (playerPos == creator.getStarterRoom()) {
                    playerPos.setVisited(true);
                }
                playerPos.setDiscoveredDoorW(true);
                playerPos = playerPos.getW();
                playerPos.setDiscoveredDoorE(true);
                //Checks if the room is dark, if it is, it doesn't display any description or name.
                if (playerPos.isRoomDark()) {
                    lightsAreOff();

                    //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                } else if (!playerPos.isVisited()) {
                    playerPos.setVisited(true);
                    ui.giveDescription(playerPos);
                    availableDoors();
                } else {
                    ui.giveName(playerPos);
                    availableDoors();
                }
            }
        }

    }

    public void userInputCaseLook(){
        //Checks if the room is dark, if it is, it doesn't display any description or name.
        if (playerPos.isRoomDark()) {
            lightsAreOff();
        } else {
            ui.printPlayerLooksAround();
            ui.giveDescription(playerPos);

        }
    }

    public void userInputCaseLookItem(){
        //Checks if the room has items
        if (playerPos.isHasItem(true)) {


        } else {
            ui.printPlayerLooksAround();
            System.out.println(playerPos.getDescription());
            System.out.println();
        }
    }

    public void exitGame(){
        System.exit(0);
    }

    public void userInputCaseOnUnlock(){
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

    public void userInputCaseOnLightOn(){
        if (playerPos.isRoomHasSwitch()) {
            ui.printFoundLightswitch();
            if (playerPos.isRoomDark()) {
                playerPos.setRoomDark(false);
                //Not very effective.
                playerPos.setDescription("""
                                    You turn on the lightswitch next to you and as you turn on the lights you realize how big the room really is. 
                                    It must be at least 200x200 meters with more than 20 meters to the ceiling. 
                                    You see a lot of shelves, almost all of them are empty as if someone looted the place.
                                    """);
                ui.giveName(playerPos);
            } else {
                ui.printLightIsOn();
            }
        } else {
            ui.printNoLightSwitch();
        }
    }

    public void userInputTakeItem(){
        if (playerPos.isHasItem()) {
            System.out.println("There's an item here");
            if (playerPos.isHasItem()) {
                playerPos.getDescription();
                System.out.println(playerPos.getDescription());
            } else {
                System.out.println("You picked all items up");
            }

        }
    }



    public void userInputCaseOnLightOff(){
        if (playerPos.isRoomHasSwitch()) {
            ui.printFoundLightswitch();
            if (!playerPos.isRoomDark()) {
                playerPos.setRoomDark(true);
                ui.printTurnOffLight();
            } else {
                ui.printLightIsOff();
            }
        } else {
            ui.printNoLightSwitch();
        }
    }

    public void execute() throws InterruptedException {
        // Part 1: The room.

        creator = new WorldCreator();
        music = new Music();
        ui = new UserInterface();

        creator.createWorldMap();
        playerPos = creator.getStarterRoom();
        entangledRoom = creator.getStarterRoom();


        music.playMusic();

        ui.mainMenu();

        ui.clearScreen();

        ui.introduction();

        //UserInput processes input from user and translates into action. (Example; 'go south' will change currentRoom to the one field below it.)
        userChoice();
    }

    public String userChoice() {
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
                case "exit", "get out", "leave", "shutdown","game end" -> {
                    ui.userInputCaseExit();
                    exitGame();
                }
                case "unlock", "unlock door" -> userInputCaseOnUnlock();
                case "turn on light", "turn on", "on" -> userInputCaseOnLightOn();
                case "turn off light", "turn off", "off" -> userInputCaseOnLightOff();
                case "connor", "connar", "get to the chopper" -> magicWord();
                default -> ui.errorMessageInvalidMove();
            }
        } while (true);
    }
}