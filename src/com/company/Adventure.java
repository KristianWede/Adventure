package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    public void execute() {
        // Part 1: The room.
        int currentRoom = 1;
        //Room room1 = new Room();
        System.out.println("""
                En meget lang
                beskriverlse på
                adskillige linjer""");

        recieveInputandGiveOutPut(userInput());
    }

    public void recieveInputandGiveOutPut(String input){



        switch (input){
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
        }

    }


    public String userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your next move?");
        System.out.println("Type 'help' for help.");
        String descesion = sc.nextLine().toLowerCase();

        return descesion;
    }


    public static void main(String[] args) {
        Adventure obj = new Adventure();
        obj.execute();
    }
}
