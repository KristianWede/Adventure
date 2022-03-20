package com.company;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
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
                "                            'inventory' to to display your inventory. \n" +
                "                            'take' to pick up item in current room. \n" +
                "                            'drop' to drop item. Use drop + name of the item to drop specific item. \n");

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
            Thread.sleep(0);
        }
        System.out.println();
    }

    public void askPlayerForInput(){
        System.out.println("What is your next move?");
        System.out.println("Type 'help' for help.");
    }

    public void introduction() throws InterruptedException {
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
                            'exit' to exit game and end program.
                            'inventory' to to display your inventory.
                            'take' to pick up item in current room.
                            'drop' to drop item. Use drop + name of the item to drop specific item. \n""");
        }
        public void userInputCaseExit() {
            System.out.println("Exiting game...");
            System.out.println("Hope you saved your progress, cause I didn't!");
        }

        public void errorMessageInvalidMove(){
            System.out.println("Not a valid choice!");
        }

        public void printPlayerReactionDark(){
            System.out.println("It's very dark in here! I can barely see anything.");
            System.out.println("Better look for a lightswitch or something somewhere.");
        }

        public void printDoorNorthAvailable(){
            System.out.println("There's a door to the North");
            System.out.println();
        }

        public void printDoorEastAvailable(){
            System.out.println("There's a door to the East.");
            System.out.println();
        }

        public void printDoorWestAvailable(){
            System.out.println("There's a door to the West.");
            System.out.println();
        }

        public void printDoorSouthAvailable(){
            System.out.println("There's a door to the South.");
            System.out.println();
        }

        public void giveDescription(Room playerPos){
        System.out.println(playerPos.getDescription());
        }

        public void printPlayerReactionTeleNothing(){
            System.out.println("huh, nothing happened.");
        }

        public void printPlayerReactionTeleFirstRoom() {
            System.out.println("Poof! Seems like I teleported to the first room?");
        }

        public void printPlayerTeleported() {
            System.out.println("Woosh! Seems like I teleported somewhere?");
        }

        public void printPathBlocked(){
            System.out.println("Seems like that way is blocked.");
        }

        public void printMessage(String message){
            System.out.println(message);
        }
        
        public void printDoorIsLocked() {
            System.out.println("Seems like that door is locked.");
        }
        
        public void printPlayerGoesNorth(){
            System.out.println("Going North.");
        }

        public void printPlayerGoesSouth(){
            System.out.println("Going South.");
        }

        public void printPlayerGoesEast(){
            System.out.println("Going East.");

        }

        public void printPlayerGoesWest(){
            System.out.println("Going West.");
        }

        public void printPlayerLooksAround(){
            System.out.println("Looking around.");

        }

        public void printDoorUnlocked(){
            System.out.println("I unlocked the door!");
        }

        public void printNothingToUnlock(){
            System.out.println("I don't see anything to unlock!");
        }

        public void printFoundLightswitch(){
            System.out.println("There's a lightswitch!");
        }

        public void printLightIsOn(){
            System.out.println("Light is already on!");
        }
        public void printNoLightSwitch(){
            System.out.println("There is no lightswitch!");
        }

        public void printTurnOffLight(){
            System.out.println("You turn off the lightswitch next to you and it's pitch black.");
        }

        public void printLightIsOff(){
            System.out.println("The light is already off!");
        }

        public void giveName(Room playerPos){
            System.out.println(playerPos.getName());
        }

        public void printReactionToFoundItem(Room room){
            System.out.println("Wait, I see something!");
            System.out.print("I see a/an:");
            System.out.println();
            System.out.println(Arrays.toString(room.getRoomInventory().toArray()).replace("[", "").replace("]", ""));
        }

        public void printReactionPickUp(Room room){
            System.out.println("You picked up:");
            System.out.println(room.getRoomInventory());
        }

}
