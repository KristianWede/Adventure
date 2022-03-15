package com.company;

import java.util.Scanner;

public class Adventure {
    //Initializes world map.
    private Room currentRoom;
    private Room requestedRoom;
    private Room entangledRoom;
    //Put room1 since it's used elsewhere to compare to a starting point and exceptions.
    Room room1 = new Room("Room1", """
            A square room with writings on the wall. 
            This big ceiling windows reveals the sky, which is covered in the brown/black clouds. 
            Behind the clouds you can see small glimmers of light. The light is most definitely not the sun.
            """);

    public void worldMap() {
        Room room2 = new Room("Room2", """
        You are standing in a long corridor. You can’t see the other end of the corridor. 
        Along the walls you notice big piles of what seems to be trash. 
        There is a faint sweet smell, almost as if something has started to rot. 
        At the other end you notice a flash of green light. You freeze and wait for another flash. 
        There! You see the flash one more time.
        """);
        Room room3 = new Room("Room3", """
                The door closes behind you. It is pitch black. 
                You cant even see your hand in front of you. 
                You have no idea how big the room is, but as you take your first steps inside the room, you notice a slight echo. 
                You are under the impression that you are inside a very big room.
                """);
        Room room4 = new Room("Room4", "This is room 4");//TODO: Add story
        Room room5 = new Room("Room5", "This is room 5");//TODO: Add story
        Room room6 = new Room("Room6", """
                As soon as you enter the room, you hear a buzzing sound.
                Suddenly the whole room is lit up by the ceiling lights.
                You look around and notice the peculiar surroundings. 
                The floor is made of big white tiles, giving the room a very ‘clinical’ feeling. 
                In the far corner you see a few metal trolleys with what appears to be trays for medical equipment. 
                There are a few used instruments on the floor and some drops of what looks like blood. What is this place?
                """);
        Room room7 = new Room("Room7", "This is room 7");//TODO: Add story
        Room room8 = new Room("Room8", "This is room 8");//TODO: Add story
        Room room9 = new Room("Room9", """
                As you enter the room you instantly feel the change in temperature. 
                The room is hot with torches hanging from the walls, giving the room a very dungeon-like feeling. 
                 can’t see all the corners, but you can easily see the main part of the room. 
                 As you move towards the middle you hear a cracking noise from underneath your feet. 
                 It sounded almost as if you stepped on a twig. Looking down you realise what it is you stepped on - bones! 
                 You jump forward but lose you balance instantly. Luckily, your landing is softened by something piled up in front of you. 
                 You look up and find yourself staring into the lifeless eyes of middleaged man. You scream like a little girl. 
                 As you get your breathing under control you hear a noise. It sounded a lot like rubble being pushed around. 
                 What is lurking around in the shadows? Red eyes emerge from the shadows. 
                 ‘Clonk, clonk, clonk’. You look back towards the door you entered through. It is closed. What now?!
                                
                """);

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

        //Setting Room 3 to darkness.
        room3.setRoomDark(true);
        room3.setRoomHasSwitch(true);

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

    public void availableDoors() {
        //At the start tries to narrow down the doors that actually exist and then "unlocking" them by making them visible to the player if they've been there before, and then tell them.
        if (currentRoom.isDiscoveredDoorN()) {
            System.out.println("There's a door to the North"); //PROBLEM, How does program know what rooms we've been to?
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
        if (currentRoom == room1) {

        }
    } //Unused for the time being. //TODO: Add graphics for each scene.

    public void lighstAreOff() {
        System.out.println("It's very dark in here! I can barely see anything.");
        System.out.println("Better look for a lightswitch or something somewhere.");
    }

    public void magicWord(){

        if (entangledRoom == room1){

        } else {
            if (currentRoom != room1) {
                entangledRoom = room1;
                currentRoom = entangledRoom;
                System.out.println("Woa! I'm back here again!");
            } else if (currentRoom == room1) {
                System.out.println("huh, nothing happened.");
            }
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
        System.out.println("""
                A tiny ray of light pierces through the heavy cloud-like smog which covers the sky and hits you in the face. 
                As you start gaining consciousness you notice that your surroundings are unfamiliar. 
                You find yourself in a room consisting of 4 walls with some doors and one big ceiling window.  
                You have no recollection of how you ended up here but you sense that something is off. 
                You get up on your feet and start dusting yourself off. As you look around you notice 2 doors - one to the east and one to the south. 
                Each wall has writing on them. You look closer: 
                ‘They are here’, ‘Judgement day has come’, ‘Connor’ and ‘Deus Ex Machina?’ are just some of the words written. 
                You don’t think much of it, it could just be kids blowing of some steam .
                """);
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
                            System.out.println("Seems like that door is locked.");
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

                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lighstAreOff();

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
                            if (currentRoom == room1) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorS(true);
                            currentRoom = currentRoom.getS();
                            currentRoom.setDiscoveredDoorN(true);
                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lighstAreOff();

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
                            if (currentRoom == room1) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorE(true);
                            currentRoom = currentRoom.getE();
                            currentRoom.setDiscoveredDoorW(true);
                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lighstAreOff();

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
                            if (currentRoom == room1) {
                                currentRoom.setVisited(true);
                            }
                            currentRoom.setDiscoveredDoorW(true);
                            currentRoom = currentRoom.getW();
                            currentRoom.setDiscoveredDoorE(true);
                            //Checks if the room is dark, if it is, it doesn't display any description or name.
                            if (currentRoom.isRoomDark()) {
                                lighstAreOff();

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
                        lighstAreOff();
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
                        }
                    } else {
                        System.out.println("I don't see anything to unlock!");
                    }
                    break;

                case "turn on light":
                    if (currentRoom.isRoomHasSwitch()) {
                        System.out.println("There's a lightswitch!");
                        if (currentRoom.isRoomDark()) {
                            currentRoom.setRoomDark(false);
                            System.out.println("""
                            You turn on the lightswitch next to you and as you turn on the lights you realize how big the room really is. 
                            It must be at least 200x200 meters with more than 20 meters to the ceiling. 
                            You see a lot of shelves, almost all of them are empty as if someone looted the place.
                                """);
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
                        if (currentRoom.isRoomDark()) {
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

                default:
                    System.out.println("Not a valid choice!");
                    break;
            }
        } while (true);
    }


    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.execute();
    }
}