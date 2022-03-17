package com.company;

import java.util.Scanner;


public class ProgramFlow {
    //Initializes world map.
    private WorldCreator creator;
    private Music music;
    private UserInterface user;

    private Room currentRoom;
    private Room requestedRoom;
    private Room entangledRoom;
    private Room tempEntangleRoom;

    //Put room1 since it's used elsewhere to compare to a starting point and exceptions.

    public void availableDoors() {
        //At the start tries to narrow down the doors that actually exist and then "unlocking" them by making them visible to the player if they've been there before, and then tell them.
        if (currentRoom.isDiscoveredDoorN()) {
            System.out.println("There's a door to the North");
            System.out.println();
        }
        if (currentRoom.isDiscoveredDoorE()) {
            System.out.println("There's a door to the East.");
            System.out.println();
        }
        if (currentRoom.isDiscoveredDoorW()) {
            System.out.println("There's a door to the West");
            System.out.println();
        }
        if (currentRoom.isDiscoveredDoorS()) {
            System.out.println("There's a door to the South");
            System.out.println();
        }
    }

    public void roomArt() {
        //For layout for each room, PROBLEM; where to refer to room?
        if (currentRoom == creator.getStarterRoom()) {

        }
    } //Unused for the time being. //TODO: Add graphics for each scene.

    public void lightsAreOff() {
        if (currentRoom.isRoomDarkIntro()) {
            System.out.println(currentRoom.getDescription());
            currentRoom.setRoomDarkIntro(false);
        } else {
            System.out.println("It's very dark in here! I can barely see anything.");
            System.out.println("Better look for a lightswitch or something somewhere.");
        }
    }


    public void magicWord() {
        //Xyzzy magic word
        //First teleports the player from anywhere on the map to room1.
        //Then it saves the place from which the player comes from.
        //The magic word can now be used to set a new teleport point anywhere on the map and swap back and forth.
        if (currentRoom == entangledRoom) {
            System.out.println("huh, nothing happened.");
        } else if (entangledRoom == creator.getStarterRoom()) {
            entangledRoom = currentRoom;
            currentRoom = creator.getStarterRoom();
            System.out.println("Poof! Seems like I teleported to the first room?");
        } else {
            tempEntangleRoom = entangledRoom;
            entangledRoom = currentRoom;
            currentRoom = tempEntangleRoom;
            System.out.println("Woosh! Seems like I teleported somewhere?");
            System.out.println(currentRoom.getName());
        }
    }


    public void execute() throws InterruptedException {
        // Part 1: The room.

        creator = new WorldCreator();
        music = new Music();
        user = new UserInterface();

        creator.createWorldMap();
        currentRoom = creator.getStarterRoom();
        entangledRoom = creator.getStarterRoom();


        music.playMusic();

        user.mainMenu();

        user.clearScreen();

        user.introduction();


        //UserInput processes input from user and translates into action. (Example; 'go south' will change currentRoom to the one field below it.)
        userInput();


    }


    public String userInput() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("What is your next move?");
            System.out.println("Type 'help' for help.");
            String decision = sc.nextLine().toLowerCase();
            user.clearScreen();
            switch (decision) {
                case "go north":
                    //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
                    if (currentRoom.getN() == null) {
                        System.out.println("Seems like that way is blocked.");
                    } else {
                        //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
                        requestedRoom = currentRoom.getN();
                        if (requestedRoom.isLockedRoom()) {
                            System.out.println("Seems like that door is locked.");
                        } else {
                            System.out.println("Going North.");
                            //Makes an exception for Room1, so Room1 is already known.
                            if (currentRoom == creator.getStarterRoom()) {
                                currentRoom.setVisited(true);
                            }
                            //Sets known doors to discovered since the player has entered both doors in a single move. (Lets the entered door and exited door known.)
                            currentRoom.setDiscoveredDoorN(true);

                            requestedRoom.setDiscoveredDoorS(true);

                            currentRoom = requestedRoom;
                            //Checks if the room is dark, if it is, it doesn't display any description or name. <-NO
                            //Room 3 should have 2 states for name and description.
                            //One for each when the lights are off in the room.
                            //One for each when the lights are on in the room.
                            if (currentRoom.isRoomDark()) {
                                lightsAreOff();

                                //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                            } else if (!currentRoom.isVisited()) {
                                currentRoom.setVisited(true);
                                System.out.println(currentRoom.getDescription());
                                availableDoors();
                            } else {
                                System.out.println(currentRoom.getName());
                                availableDoors();
                                roomArt();
                            }
                        }
                    }

                    break;

                case "go south":
                    //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
                    if (currentRoom.getS() == null) {
                        System.out.println("Seems like that way is blocked.");
                    } else {
                        //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
                        requestedRoom = currentRoom.getS();
                        if (requestedRoom.isLockedRoom()) {
                            System.out.println("Seems like that door is locked.");
                        } else {
                            System.out.println("Going South.");
                            if (currentRoom == creator.getStarterRoom()) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorS(true);
                            currentRoom = currentRoom.getS();
                            currentRoom.setDiscoveredDoorN(true);
                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lightsAreOff();

                                //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                            } else if (!currentRoom.isVisited()) {
                                currentRoom.setVisited(true);
                                System.out.println(currentRoom.getDescription());
                                availableDoors();
                            } else {
                                System.out.println(currentRoom.getName());
                                availableDoors();
                            }
                        }
                    }
                    break;

                case "go east":
                    //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
                    if (currentRoom.getE() == null) {
                        System.out.println("Seems like that way is blocked.");
                    } else {
                        //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
                        requestedRoom = currentRoom.getE();
                        if (requestedRoom.isLockedRoom()) {
                            System.out.println("Seems like that door is locked.");
                        } else {
                            System.out.println("Going East.");
                            if (currentRoom == creator.getStarterRoom()) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorE(true);
                            currentRoom = currentRoom.getE();
                            currentRoom.setDiscoveredDoorW(true);
                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lightsAreOff();

                                //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                            } else if (!currentRoom.isVisited()) {
                                currentRoom.setVisited(true);
                                System.out.println(currentRoom.getDescription());
                                availableDoors();
                            } else {
                                System.out.println(currentRoom.getName());
                                availableDoors();
                            }
                        }
                    }
                    break;

                case "go west":
                    //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
                    if (currentRoom.getW() == null) {
                        System.out.println("Seems like that way is blocked.");
                    } else {
                        //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
                        requestedRoom = currentRoom.getW();
                        if (requestedRoom.isLockedRoom()) {
                            System.out.println("Seems like that door is locked.");
                        } else {
                            System.out.println("Going West.");
                            if (currentRoom == creator.getStarterRoom()) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorW(true);
                            currentRoom = currentRoom.getW();
                            currentRoom.setDiscoveredDoorE(true);
                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lightsAreOff();

                                //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                            } else if (!currentRoom.isVisited()) {
                                currentRoom.setVisited(true);
                                System.out.println(currentRoom.getDescription());
                                availableDoors();
                            } else {
                                System.out.println(currentRoom.getName());
                                availableDoors();
                            }
                        }
                    }

                    break;

                case "look":
                    //Checks if the room is dark, if it is, it doesn't display any description or name.
                    if (currentRoom.isRoomDark()) {
                        lightsAreOff();
                    } else {
                        System.out.println("Looking around.");
                        System.out.println(currentRoom.getDescription());
                    }
                    break;

                case "help":
                    System.out.println("""
                            You can go either north, east, west or south by: 'go (direction)'
                            'help' to repeat this message.
                            'look' to look around in current room.
                            'unlock' to try and unlock a door.
                            'turn on light' turns on light.
                            'turn off light' turns off light.
                            'exit' to exit game and end program.""");
                    break;

                case "exit":
                    System.out.println("Exiting game...");
                    System.out.println("Hope you saved your progress, cause I didn't!");
                    System.exit(0);
                    break;

                case "unlock":
                    if (requestedRoom != null) {
                        if (requestedRoom.isLockedRoom()) {
                            requestedRoom.setLockedRoom(false);
                            System.out.println("I unlocked the door.");
                        } else if (!requestedRoom.isLockedRoom()) {
                            System.out.println("I don't see anything to unlock!");
                        }
                    } else {
                        System.out.println("I don't see anything to unlock!");
                    }
                    break;

                //The cases for turn on/off light only work for Room3 and nothing else. Could be upgraded in the future.
                case "turn on light":
                    if (currentRoom.isRoomHasSwitch()) {
                        System.out.println("There's a lightswitch!");
                        if (currentRoom.isRoomDark()) {
                            currentRoom.setRoomDark(false);
                            //Not very effective.
                            currentRoom.setDescription("""
                                    You turn on the lightswitch next to you and as you turn on the lights you realize how big the room really is. 
                                    It must be at least 200x200 meters with more than 20 meters to the ceiling. 
                                    You see a lot of shelves, almost all of them are empty as if someone looted the place.
                                    """);
                            System.out.println(currentRoom.getDescription());
                        } else {
                            System.out.println("The light is already on!");
                        }
                    } else {
                        System.out.println("There is no lightswitch!");
                    }
                    break;
                case "turn off light":
                    if (currentRoom.isRoomHasSwitch()) {
                        System.out.println("There's a lightswitch!");
                        if (!currentRoom.isRoomDark()) {
                            currentRoom.setRoomDark(true);
                            System.out.println("You turn off the lightswitch next to you and it's pitch black. ");
                        } else {
                            System.out.println("The light is already off!");
                        }
                    } else {
                        System.out.println("There is no lightswitch!");
                    }

                    break;

                case "connor":
                    magicWord();
                    break;
                default:
                    System.out.println("Not a valid choice!");
                    break;
            }
        } while (true);
    }
}