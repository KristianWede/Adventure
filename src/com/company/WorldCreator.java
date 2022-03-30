package com.company;

import java.util.ArrayList;

public class WorldCreator {


    private Room starterRoom;

    protected ArrayList<Enemy> listOfEnemies = new ArrayList<>();


    public void createWorldMap() {

        Room room1 = new Room("Arrival", """
                A square room with writings on the wall. 
                The big ceiling windows reveals the sky, which is covered in the brown/black clouds. 
                Behind the clouds you can see small glimmers of light. The light is most definitely not the sun.
                """);
        Room room2 = new Room("Corridor", """
                You are standing in a long corridor. You can’t see the other end of the corridor. 
                Along the walls you notice big piles of what seems to be trash. 
                There is a faint sweet smell, almost as if something has started to rot. 
                At the other end you notice a flash of green light. You freeze and wait for another flash. 
                There! You see the flash one more time.
                """);
        Room room3 = new Room("Warehouse", """
                The door closes behind you. It is pitch black. 
                You cant even see your hand in front of you. 
                You have no idea how big the room is, but as you take your first steps inside the room, you notice a slight echo. 
                You are under the impression that you are inside a very big room.
                """);
        Room room4 = new Room("Prison Yard", """
                As you close the door behind you and look into the room, you find yourself in enormous yard-like area.
                Dirt and mud is covering the floor. You spot something that resembles tire tracks.
                On both sides you see a huge concrete wall - this reminds you of a prison yard.
                Along one of the walls you notice some burned out car wrecks.   
                """);
        Room room5 = new Room("Device room", """
                This room is nothing like you have ever seen before.
                The room is  illuminated by a strange blueish light emitting from a device in the middle of the room.
                The device looks otherworldly, almost alien. 
                You can hear a low buzzing sound.
                What is this device?
                """);
        Room room6 = new Room("'Medical' facility", """
                As soon as you enter the room, you hear a buzzing sound.
                Suddenly the whole room is lit up by the ceiling lights.
                You look around and notice the peculiar surroundings. 
                The floor is made of big white tiles, giving the room a very ‘clinical’ feeling. 
                In the far corner you see a few metal trolleys with what appears to be trays for medical equipment. 
                There are a few used instruments on the floor and some drops of what looks like blood. What is this place?
                """);
        Room room7 = new Room("Workshop", """
                As the door slams behind you, you start looking around.
                You spot a lot of chains hanging from the ceiling.
                On the floor you see huge piles of metal parts.
                Suddenly you notice something that resembles a human hand.
                You move closer to study your findings. It sure does look like a hand
                but where the elbow is supposed to be a weird metal part sticks out.
                You notice a few wires as well. What in the world is this? 
                                
                Opposite of the entrance you spot tables lined up alongside the wall. 
                A black puddle of something is dripping down from one of the tables. 
                You start to connect the dots. Is this some kind of factory? Perhaps a car shop?
                """);
        Room room8 = new Room("Throne Room", """
                WOAH! Completely stunned by the decorations on the walls and ceiling you enter the room.
                You look around. Is that.... The Mona Lisa? No it can't be?!
                And there? A Rembrandt, a Picasso, several van Gogh's. What is this? 
                Is this a museum? In the middle, you notice a red carpet. As if
                it is intended for someone special. And... is that a throne?
                                
                You walk around the room. You spot something next to the throne.
                Sitting on the floor, leaning against the throne is a... man?
                You run over... You noticed his chest moving - he's ALIVE!
                Quickly you put him down on his back. It is clear that he is struggling.
                You can't seem to find any injuries. You ask him: 'What happened here?!'
                With what seems to be his last bits of energy he lifts his right hand and
                points to towards a door going north. You can barely hear him breathing but
                you catch the last words coming from him: 'Them'.
                His hand drops to the floor. His breathing stops. Dead.
                You look up. What is this place. How did you end up here. What happened here?
                So many questions and you just lost your chance of getting any answers.
                """);
        Room room9 = new Room("Dungeon", """
                As you enter the room you instantly feel the change in temperature. 
                The room is hot with torches hanging from the walls, giving the room a very dungeon-like feeling. 
                 can’t see all the corners, but you can easily see the main part of the room. 
                 As you move towards the middle you hear a cracking noise from underneath your feet. 
                 It sounded almost as if you stepped on a twig. Looking down you realise what it is you stepped on - bones! 
                 You jump forward but lose you balance instantly. Luckily, your landing is softened by something piled up in front of you. 
                 You look up and find yourself staring into the lifeless eyes of middle aged man. You scream like a little girl. 
                 As you get your breathing under control you hear a noise. It sounded a lot like rubble being pushed around. 
                 What is lurking around in the shadows? Red eyes emerge from the shadows. 
                 ‘Clonk, clonk, clonk’. You look back towards the door you entered through. It is closed. 
                 What now?!              
                """);
        Room room10 = new Room("Anarchy", """
                Similar to the arrival room, this room has highly 'decorated' walls. 
                Most of the writing is unreadable or incomprehensible, but one thing quickly catches your eyes:
                In the ceiling a big 'A' for 'ANARCHY' has been painted with thick, red paint. 
                """);

        Room room11 = new Room("Doorway", """
                Small, narrow room. You could probably reach from one wall to the other
                if you extended your arms to the sides.""");

        Room room12 = new Room("Staircase", """
                As you enter, you find your self standing at the end of a staircase.
                You notice that the staircase bends a little towards west.
                You can easily see the other end of the staircase.""");

        Room room13 = new Room("The repos", """
                What a weird room. It feels out of balance, in a way.
                Towards the east there is a repos overlooking the rest
                of the room. In the center of the repos there is a 
                narrow staircase leading directly into a door.
                The ceiling is moist and sometimes you feel a drop of
                water falling on your head. There is a subtle smell
                of mold and rot.""");

        Room room14 = new Room("Ball Room", """
                You enter a magnificent room, decorated with beautiful paintings.
                The walls are painted red, chandeliers are hanging from the ceiling.
                 In the middle of the room there is a long table, set with
                 cutlery and plates, as if it was prepared for a dinner party.
                 Everything looks like it was carefully placed.""");

        Room room15 = new Room("Kitchen", """
                A traditional kitchen, like the ones you would expect at a restaurant.
                White tiles are covering the walls and several stoves are standing
                alongside the walls. The kitchen appears extremely clean. You detect
                a faint sweet smell. Perhaps something is rotten?""");

        listOfEnemies.add(new Enemy("Timmy The Terminator", room2, 100, new Weapon("Laser Blaster", "Pretty damn high tech", 8)));
        listOfEnemies.add(new Enemy("Hubert The Hungarian", room4, 100, new Weapon("Laser Canon", "Pretty damn high tech", 23)));
        listOfEnemies.add(new Enemy("Maxi Man", room6, 100, new Weapon("Laser Blaster3", "Pretty damn high tech", 40)));

        //Maps out what "fields" are available to each other, use the map for reference.
        //Room 1
        room1.setN(null);
        room1.setE(room2);
        room1.setS(room4);
        room1.setW(room10);

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
        room3.setRoomDarkIntro(true);

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

        //Room 10
        room10.setN(null);
        room10.setE(room1);
        room10.setS(room11);
        room10.setW(null);

        //Room 11
        room11.setN(room10);
        room11.setE(null);
        room11.setS(room12);
        room11.setW(room13);

        //Room 12
        room12.setN(room11);
        room12.setE(null);
        room12.setS(null);
        room12.setW(room15);

        //Room 13
        room13.setN(null);
        room13.setE(room11);
        room13.setS(null);
        room13.setW(room14);

        //Room 14
        room14.setN(null);
        room14.setE(room13);
        room14.setS(null);
        room14.setW(room15);

        //Room 15
        room15.setN(null);
        room15.setE(room14);
        room15.setS(room12);
        room15.setW(null);


        starterRoom = room1;

        //Initializing items & food.
        room3.addRoomInventory(new Item("Old Key", "A very old-looking key. I wonder where it belongs..."));
        room4.addRoomInventory(new Item("Bucket of Lava", "This probably breaks a few laws of physics..."));
        room3.addRoomInventory(new Item("Paint", "Pink paint"));
        room3.addRoomInventory(new Item("Papers", "Just blank paper, seems to be rather useless"));
        room3.addRoomInventory(new MeleeWeapon("Golf Club", "Could have been used by a pro but who knows", 10));
        room2.addRoomInventory(new Food("Rotten Banana", "Has probably been there for a while", -10));
        room1.addRoomInventory(new Food("Chips", "Classic potato chips", 3));
        room4.addRoomInventory(new Food("Can of tuna", "A small can of Tuna", 20));
        room12.addRoomInventory(new Food("Medkit", "This medkit will heal you to max!", 100));
        room4.addRoomInventory(new RangedWeapon("T-shirt Cannon", "Free T-shirts for EVERYONE", 5, 10));
        room6.addRoomInventory(new MeleeWeapon("Pipe", "Old rusty pipe", 15));
        room5.addRoomInventory(new Item("Sunglasses", "They look hella fresh."));
        room6.addRoomInventory(new RangedWeapon("Krummlauf", "The curved barrel might confuse the enemy?", 20, 30));
        room4.addRoomInventory(new MeleeWeapon("The Repellent Stick", "The Repellent stick is neither powerful, nor visually stunning appealing.", 1));
        room11.addRoomInventory(new MeleeWeapon("The Drill Bucket", "Place it on the head of your enemies and they will die instantly", 100));
        room1.addRoomInventory(new MeleeWeapon("Rubber Duck", "This little bastard has been filled with concrete, which makes it quite violent", 50));
        room2.addRoomInventory(new MeleeWeapon("Nunchaku", "Good luck using these!", -10));
        room6.addRoomInventory(new MeleeWeapon("Grandma's old flip-flop", "Getting hit by this will only hurt your pride", 3));
    }


    //Getters
    public Room getStarterRoom() {
        return starterRoom;
    }

    public ArrayList<Enemy> getListOfEnemies() {
        return listOfEnemies;
    }

    public String toString() {
        return " " + getListOfEnemies() + " ";
    }

}