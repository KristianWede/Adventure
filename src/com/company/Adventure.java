package com.company;

import java.util.Scanner;

public class Adventure {
    Room room1 = new Room("Room1","Something something story here", null,null,null,null);
    Room room2 = new Room("Room1","Something something story here", null,null,null,null);
    Room room3 = new Room("Room1","Something something story here", null,null,null,null);
    Room room4 = new Room("Room1","Something something story here", null,null,null,null);
    Room room5 = new Room("Room1","Something something story here", null,null,null,null);
    Room room6 = new Room("Room1","Something something story here", null,null,null,null);
    Room room7 = new Room("Room1","Something something story here", null,null,null,null);

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
                    lookAction();
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


    public void lookAction(){
        System.out.println(room1.getDescription());
    }


    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.execute();
    }
}
