package com.company;

import java.util.Scanner;

public class Adventure {
    public void worldMap() {
        Room room1 = new Room("Room1", "Something something story here");
        Room room2 = new Room("Room2", "Something something story here");
        Room room3 = new Room("Room3", "Something something story here");
        Room room4 = new Room("Room4", "Something something story here");
        Room room5 = new Room("Room5", "Something something story here");
        Room room6 = new Room("Room6", "Something something story here");
        Room room7 = new Room("Room7", "Something something story here");
        Room room8 = new Room("Room8", "Something something story here");
        Room room9 = new Room("Room9", "Something something story here");

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

    }

    public void execute() {

        // Part 1: The room.
        int currentRoom = 1;
        System.out.println("Dit nuværende rum er " + currentRoom);
        userInput();
    }

    public String userInput(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("What is your next move?");
            System.out.println("Type 'help' for help.");
            String descesion = sc.nextLine().toLowerCase();
            switch (descesion) {
                case "go north":
                    System.out.println("Going North.");
                    break;

                case "go south":
                    System.out.println("Going South.");
                    break;

                case "go east":
                    System.out.println("Going East.");
                    break;

                case "go west":
                    System.out.println("Going West.");
                    break;

                case "look":
                    System.out.println("Looking around.");

                    break;

                case "help":
                    System.out.println("You can say cheese.");
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
        } while(true);

    }



    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.execute();
    }
}
