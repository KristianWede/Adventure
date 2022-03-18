package com.company;

import java.util.Scanner;

public class UserInterface {

    public void mainMenu() throws InterruptedException {
        gameTextPrinter("Welcome to Terminator Maze!");
        gameTextPrinter("You're about to go on an epic journey in a mysterious maze..");
        gameTextPrinter("In order to navigate the maze, you must type your desired direction." +
                "\nUseful commands: \n" +
                "                            You can go either north, east, west or south by: 'go (direction)'\n" +
                "                            'help' to repeat this message.\n" +
                "                            'look' to look around in current room.\n" +
                "                            'unlock' to try and unlock a door.\n" +
                "                            'turn on light' turns on light.\n" +
                "                            'turn off light' turns off light.\n" +
                "                            'exit' to exit game and end program \n");

        System.out.println("You can also during the game type 'help' to display the above commands again. \n");
        System.out.println("Press \"ENTER\" to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    //This printer can be used for all "souts" so that the text fits the aestetic.
    public void gameTextPrinter(String text) throws InterruptedException {

        for (int i = 0; i <= text.length()-1; i++){
            System.out.print(text.charAt(i));
            Thread.sleep(20);
        }
        System.out.println();
    }

    public void introduction() throws InterruptedException {
        //Adding main menu.


        gameTextPrinter
                ("""
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


        public void userInputCaseHelp() {
            System.out.println("""
                            You can go either north, east, west or south by: 'go (direction)'
                            'help' to repeat this message.
                            'look' to look around in current room.
                            'unlock' to try and unlock a door.
                            'turn on light' turns on light.
                            'turn off light' turns off light.
                            'exit' to exit game and end program.""");
        }
        public void userInputCaseExit() {
            System.out.println("Exiting game...");
            System.out.println("Hope you saved your progress, cause I didn't!");
        }

        public void errorMessageInvalidMove(){
            System.out.println("Not a valid choice!");
        }

        public void playerReactionDark(){
            System.out.println("It's very dark in here! I can barely see anything.");
            System.out.println("Better look for a lightswitch or something somewhere.");
        }

}
