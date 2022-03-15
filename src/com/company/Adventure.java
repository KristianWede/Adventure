package com.company;

import java.util.Scanner;

public class Adventure {
    //Initializes world map.
    private Room currentRoom;
    private Room requestedRoom;
    //Put room1 since it's used elsewhere to compare to a starting point and exceptions.
    Room room1 = new Room("Room1", "This is room 1");

    public void worldMap() {
        Room room2 = new Room("Room2", "This is room 2");
        Room room3 = new Room("Room3", "This is room 3");
        Room room4 = new Room("Room4", "This is room 4");
        Room room5 = new Room("Room5", "This is room 5");
        Room room6 = new Room("Room6", "This is room 6");
        Room room7 = new Room("Room7", "This is room 7");
        Room room8 = new Room("Room8", "This is room 8");
        Room room9 = new Room("Room9", "This is room 9");

        //Maps out what "fields" are available to each other, use the map for reference.
        //Room 1
        room1.setN(null);
        room1.setE(room2);
        room1.setS(room4);
        room1.setW(null);

        //Room 2
        room2.setN(null);
        room2.setE(room3);
        room2.setS(null);
        room2.setW(room1);

        //Room 3
        room3.setN(null);
        room3.setE(null);
        room3.setS(room6);
        room3.setW(room2);

        //Locking Room 4.
        room4.setLockedRoom(true);

        //Room 4
        room4.setN(room1);
        room4.setE(null);
        room4.setS(room7);
        room4.setW(null);

        //Room 5
        room5.setN(null);
        room5.setE(null);
        room5.setS(room8);
        room5.setW(null);

        //Room 6
        room6.setN(room3);
        room6.setE(null);
        room6.setS(room9);
        room6.setW(null);

        //Room 7
        room7.setN(room4);
        room7.setE(room8);
        room7.setS(null);
        room7.setW(null);

        //Room 8
        room8.setN(room5);
        room8.setE(room9);
        room8.setS(null);
        room8.setW(room7);

        //Room 9
        room9.setN(room6);
        room9.setE(null);
        room9.setS(null);
        room9.setW(room8);

        currentRoom = room1;
    }

    public void availableDoors(){
        //At the start tries to narrow down the doors that actually exist and then "unlocking" them by making them visible to the player if they've been there before, and then tell them.
        if (currentRoom.isDiscoveredDoorN()){
            System.out.println("There's a door to the North"); //PROBLEM, How does program know what rooms we've been to?
            System.out.println();
        } if (currentRoom.isDiscoveredDoorE()) {
            System.out.println("There's a door to the East.");
            System.out.println();
        } if (currentRoom.isDiscoveredDoorW()) {
            System.out.println("There's a door to the West");
            System.out.println();
        } if (currentRoom.isDiscoveredDoorS()) {
            System.out.println("There's a door to the South");
            System.out.println();
        }
    }

    public void execute() {
        // Part 1: The room.
        worldMap();

        introduction();
        //UserInput processes input from user and translates into action. (Example; 'go south' will change currentRoom to the one field below it.)
        userInput();


    }

    private void introduction() {
        System.out.println("Some random introduction to an adventure.");
    }

    public String userInput() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("What is your next move?");
            System.out.println("Type 'help' for help.");
            String decision = sc.nextLine().toLowerCase();
            switch (decision) {
                case "go north":
                    //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
                    if (currentRoom.getN() == null) {
                        System.out.println("Seems like that way is blocked.");
                    } else {
                        //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
                        requestedRoom = currentRoom.getN();
                        if (requestedRoom.isLockedRoom()) {
                            System.out.println("Seems like that room is locked.");
                        } else {
                            System.out.println("Going North.");
                            //Makes an exception for Room1, so Room1 is already known.
                            if (currentRoom == room1) {
                                currentRoom.setVisited(true);
                            }
                            //Sets known doors to discovered since the player has entered both doors in a single move. (Lets the entered door and exited door known.)
                            currentRoom.setDiscoveredDoorN(true);
                            currentRoom = currentRoom.getN();
                            currentRoom.setDiscoveredDoorS(true);
                            //Checks if the room has already been visited before, if true, it gives the long description, if not, gives the "name" which is just the short description.
                            if (!currentRoom.isVisited()) {
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

                case "go south":
                    //Checks if chosen direction is optional, if it is, it will set the new currentroom variable to the direction.
                    if (currentRoom.getS() == null) {
                        System.out.println("Seems like that way is blocked.");
                    } else {
                        //Assigns requestedRoom to the room the player is trying to get to. If it's a locked room, it will display this message.
                        requestedRoom = currentRoom.getS();
                        if (requestedRoom.isLockedRoom()) {
                            System.out.println("Seems like that room is locked.");
                        } else {
                            System.out.println("Going South.");
                            if (currentRoom == room1) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorS(true);
                            currentRoom = currentRoom.getS();
                            currentRoom.setDiscoveredDoorN(true);
                            if (!currentRoom.isVisited()) {
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
                                    System.out.println("Seems like that room is locked.");
                                } else {
                                    System.out.println("Going East.");
                                    if (currentRoom == room1) {
                                        currentRoom.setVisited(true);
                                    }
                                    currentRoom.setDiscoveredDoorE(true);
                                    currentRoom = currentRoom.getE();
                                    currentRoom.setDiscoveredDoorW(true);
                                    if (!currentRoom.isVisited()) {
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
                                    System.out.println("Seems like that room is locked.");
                                } else {
                                    System.out.println("Going West.");
                                    if (currentRoom == room1) {
                                        currentRoom.setVisited(true);
                                    }
                                    currentRoom.setDiscoveredDoorW(true);
                                    currentRoom = currentRoom.getW();
                                    currentRoom.setDiscoveredDoorE(true);

                                    if (!currentRoom.isVisited()) {
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
                            System.out.println("Looking around.");
                            System.out.println(currentRoom.getDescription());
                            break;

                        case "help":
                            System.out.println("""
                                    You can go either north, east, west or south by: 'go (direction)'
                                    'help' to repeat this message.
                                    'look' to look around in current room.
                                    'exit' to exit game and end program.""");
                            break;

                        case "exit":
                            System.out.println("Exiting game...");
                            System.out.println("Hope you saved your progress, cause I didn't!");
                            System.exit(0);
                            break;

                        default:
                            System.out.println("Not a valid choice!");
                            break;
                    }
            }  while (true) ;
    }

    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.execute();
    }
}