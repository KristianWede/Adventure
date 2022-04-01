package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserInterface {

    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_RESET = "\u001B[0m";

    public void mainMenu() throws InterruptedException {
        gameTextPrinter("Welcome to Terminator Maze!");
        gameTextPrinter("You're about to go on an epic journey in a mysterious maze..\nYour objective is to find a bomb and plant it in the Device Room.. Good luck!");
        gameTextPrinter("In order to navigate the maze, you must type your desired direction." +
                "\n Useful commands: \n" +
                "                            You can go either north, east, west or south by: 'go (direction)'\n" +
                "                            'help' to repeat this message.\n" +
                "                            'look' to look around in current room.\n" +
                "                            'unlock' to try and unlock a door.\n" +
                "                            'turn on light' turns on light.\n" +
                "                            'turn off light' turns off light.\n" +
                "                            'inventory' to to display your inventory. \n" +
                "                            'take' to pick up item in current room. \n" +
                "                            'drop' to drop item. Use drop + name of the item to drop specific item. \n" +
                "                            'inspect' will inspect item in your inventory.\n" +
                "                            'eat' to consume food in your inventory  \n" +
                "                            'equip' to equip weapon.\n" +
                "                            'plant' to plant the bomb.\n" +
                "                            'attack' to attack enemy.\n");

        gameTextPrinter("You can also during the game type 'help' to display the above commands again. \n");
        gameTextPrinter("Press \"ENTER\" to continue...");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

    public void clearScreen() throws InterruptedException {
        gameTextPrinter("\n\n\n\n\n\n\n\n\n\n\n");
    }

    //This printer can be used for all "souts" so that the text fits the aestetic.
    public void gameTextPrinter(String text) throws InterruptedException {
        for (int i = 0; i <= text.length() - 1; i++) {
            System.out.print(text.charAt(i));
            Thread.sleep(5);
        }
        System.out.println();
    }

    public String askPlayerForInput() throws InterruptedException {
        gameTextPrinter("What is your next move?");
        gameTextPrinter("Type 'help' for help.");
        return "";
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


    public void userInputCaseHelp() throws InterruptedException {
        gameTextPrinter("""
                You can go either north, east, west or south by: 'go (direction)'
                'help' to repeat this message.
                'look' to look around in current room.
                'unlock' to try and unlock a door.
                'turn on light' turns on light.
                'turn off light' turns off light.
                'exit' to exit game and end program.
                'inventory' to to display your inventory.
                'take' to pick up item in current room.
                'drop' to drop item. Use drop + name of the item to drop specific item. 
                'health' or 'hp' To display health left.
                'inspect' will inspect items in your inventory.
                'eat' to consume food in your inventory.
                'equip' to equip weapon.
                'unequip' to unequip weapon.
                'attack' to attack enemy.
                'plant' to plant the bomb.
                \n""");
    }

    public void userInputCaseExit() throws InterruptedException {
        gameTextPrinter("Exiting game...");
        gameTextPrinter("Hope you saved your progress, cause I didn't!");
    }

    public void errorMessageInvalidMove() throws InterruptedException {
        gameTextPrinter("Not a valid choice!");
    }

    public void printPlayerReactionDark() throws InterruptedException {
        gameTextPrinter("It's very dark in here! I can barely see anything.");
        gameTextPrinter("Better look for a lightswitch or something somewhere.");
    }

    public void printDoorNorthAvailable() throws InterruptedException {
        gameTextPrinter("There's a door to the North");
        System.out.println();
    }

    public void printDoorEastAvailable() throws InterruptedException {
        gameTextPrinter("There's a door to the East.");
        System.out.println();
    }

    public void printDoorWestAvailable() throws InterruptedException {
        gameTextPrinter("There's a door to the West.");
        System.out.println();
    }

    public void printDoorSouthAvailable() throws InterruptedException {
        gameTextPrinter("There's a door to the South.");
        System.out.println();
    }

    public void giveDescription(Room playerPos) throws InterruptedException {
        gameTextPrinter(playerPos.getDescription());
    }

    public void printPlayerReactionTeleNothing() throws InterruptedException {
        gameTextPrinter("huh, nothing happened.");
    }

    public void printPlayerReactionTeleFirstRoom() throws InterruptedException {
        gameTextPrinter("Poof! Seems like I teleported to the first room?");
    }

    public void printPlayerTeleported() throws InterruptedException {
        gameTextPrinter("Woosh! Seems like I teleported somewhere?");
    }

    public void printPathBlocked() throws InterruptedException {
        gameTextPrinter("Seems like that way is blocked.");
    }

    public void printDoorIsLocked() throws InterruptedException {
        gameTextPrinter("Seems like that door is locked.");
    }

    public void printPlayerGoesNorth() throws InterruptedException {
        gameTextPrinter("Going North.");
    }

    public void printPlayerGoesSouth() throws InterruptedException {
        gameTextPrinter("Going South.");
    }

    public void printPlayerGoesEast() throws InterruptedException {
        gameTextPrinter("Going East.");

    }

    public void printPlayerGoesWest() throws InterruptedException {
        gameTextPrinter("Going West.");
    }

    public void printPlayerLooksAround() throws InterruptedException {
        gameTextPrinter("Looking around.");

    }

    public void printDoorUnlocked() throws InterruptedException {
        gameTextPrinter("I unlocked the door!");
    }

    public void printNothingToUnlock() throws InterruptedException {
        gameTextPrinter("I don't see anything to unlock!");
    }

    public void printFoundLightswitch() throws InterruptedException {
        gameTextPrinter("There's a lightswitch!");
    }

    public void printLightIsOn() {
        System.out.println("Light is already on!");
    }

    public void printNoLightSwitch() {
        System.out.println("There is no lightswitch!");
    }

    public void printTurnOffLight() {
        System.out.println("You turn off the lightswitch next to you and it's pitch black.");
    }

    public void printLightIsOff() {
        System.out.println("The light is already off!");
    }

    public void printPlayerHasDied() {
        System.out.println("\u001B[31m" + "You are dead!" + "\u001B[0m");
    }

    public void grammarCheck(Room room) {
        char ch;
        String inventory = room.getRoomInventory().toString();
        ch = inventory.charAt(1);
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            System.out.print("an ");
        } else
            System.out.print("a ");
    }


    public void printReactionToFoundItem(Room room) throws InterruptedException {
        System.out.println("Wait, I see something!");
        System.out.print("I see ");
        grammarCheck(room);

        printOutItemInRoom(room);
    }

    public void printReactionPickUp(Item item) throws InterruptedException {
        System.out.print("You picked up the ");
        gameTextPrinter(TEXT_YELLOW + item + TEXT_RESET);
    }

    public void printInventory(ArrayList<Item> playerInventory) throws InterruptedException {
        gameTextPrinter("Your inventory:");
        System.out.println(TEXT_YELLOW + Arrays.toString(playerInventory.toArray()).replace("[", "").replace("]", "") + TEXT_RESET);
    }

    public void printPlayerHasNoItems() throws InterruptedException {
        gameTextPrinter("You don't have any items.");
    }

    public void printPlayerHasNoWeapon() throws InterruptedException {
        gameTextPrinter("This item cannot be equipped as a weapon.");
    }

    public void printNoItemsOnGround() throws InterruptedException {
        gameTextPrinter("There are no items to pick up.");
    }

    public void printOutItemInRoom(Room room) throws InterruptedException {
        gameTextPrinter("\u001B[33m" + Arrays.toString(room.getRoomInventory().toArray()).replace("[", "").replace("]", "") + "\u001B[0m");
    }

    public void printErrorCannotFindItem() throws InterruptedException {
        gameTextPrinter("Couldn't find any items with that name! Try again!");
    }

    public void printAddedItemRoom(Item item) throws InterruptedException {
        gameTextPrinter("You took " + "\u001B[33m" + item + "\u001B[0m" + " out of your bag and put it on the ground.");
    }

    public void MaxHP() throws InterruptedException {
        gameTextPrinter("You have max health!");
    }


    public void printNameAndDescriptionOfItem(Item item, int number) throws InterruptedException {
        gameTextPrinter("\t" + (number + 1) + ". " + item.getItemName() + "  -  " + item.getItemDescription());
    }

    public void printPlayerActionOpenInventory() {
        System.out.println("Your inventory:");
    }

    public void printWeaponEquipped(Weapon weapon) throws InterruptedException {
        gameTextPrinter(weapon + " has now been equipped!");
    }

    public void printUserNotDeclaringDirection() {
        System.out.println("Go exactly where?");
    }

    public void printUserNothingToTake() {
        System.out.println("Take what?");
    }

    public void printUserNothingToDrop() {
        System.out.println("Drop what?");
    }

    public void printWeaponAlreadyEquipped() throws InterruptedException {
        gameTextPrinter("You already have a weapon equipped.");
    }

    public void printUnEquip(Weapon weapon) {
        System.out.println(weapon + " has been unequipped.");
    }

    public void printUserNothingToEquip() {
        System.out.println("Nothing to be unequipped.");
    }

    public void printString(String text) throws InterruptedException {
        Thread.sleep(100);
        gameTextPrinter(text);
    }

    public void printPlayerPlantingBomb() throws InterruptedException {
        System.out.println(".");
        Thread.sleep(1000);
        System.out.println(". .");
        Thread.sleep(1000);
        System.out.println(". . .");
        Thread.sleep(1000);
        System.out.println("TAKE COVER!");
        Thread.sleep(1000);
        System.out.println("* boom *");
        Thread.sleep(1250);
        System.out.println("You destroyed the time machine! You saved humanity!");
    }

    public void printPlayerBeforePlant() throws InterruptedException {
        gameTextPrinter("This gives me deja vu, have I played a game about this before?");
        gameTextPrinter("Bomb has been planted...");
    }

    public void printPlayerCantPlant(){
        System.out.println("I can't plant it here!");
    }

    public void printPlayerCantFindBomb(){
        System.out.println("Plant what?");
    }

    public void printPlayerCantPlantItem(){
        System.out.println("I can't plant that");
    }
}