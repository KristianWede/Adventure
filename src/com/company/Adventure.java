package com.company;

import java.util.Scanner;

public class Adventure {

    public String userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your next move?");
        System.out.println("Type 'help' for help.");
        String descesion = sc.nextLine();

        return descesion;
    }


    public static void main(String[] args) {
        // Part 1: The room.
        int currentRoom = 1;
        Room room1 = new Room();
        Adventure main = new Adventure();



        System.out.println("This code works:");



    }
}
