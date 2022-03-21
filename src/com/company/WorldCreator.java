package com.company;

public class WorldCreator {


private Room starterRoom;

    Item key = new Item("Old Key", "A very old-looking key. Wonder where it belongs");
    Item bucketOfLava = new Item("A bucket of lava(?)", "This probably breaks a few laws of physics...");

    public void createWorldMap() {

        Room room1 = new Room("Arrival", """
                A square room with writings on the wall. 
                This big ceiling windows reveals the sky, which is covered in the brown/black clouds. 
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
        Room room10 = new Room("This is room 10 ", """
            Short description here 10""");

        Room room11 = new Room("This is room 11 ", """
            Short description here 11""");

        Room room12 = new Room("This is room 12", """
            Short description here 12""");

        Room room13 = new Room("This is room 13", """
            Short description here 13""");

        Room room14 = new Room("This is room 14", """
            Short description here 14""");

        Room room15 = new Room("This is room 15 ", """
            Short description here 15""");

        Room room16 = new Room("This is room 16 ", """
            Short description here 16""");

        Room room17 = new Room("This is room 17", """
            Short description here 17""");

        Room room18 = new Room("This is room 18", """
            Short description here 18""");

        Room room19 = new Room("This is room 19", """
            Short description here 19""");

        Room room20 = new Room("This is room 20", """
            Short description here 20""");

        Room room21 = new Room("This is room 21", """
            Short description here 21""");

        Room room22 = new Room("This is room 22", """
            Short description here 22""");

        Room room23 = new Room("This is room 23", """
            Short description here 23""");



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
        room15.setN(room16);
        room15.setE(room14);
        room15.setS(room12);
        room15.setW(null);

        //Room 16
        room16.setN(null);
        room16.setE(room17);
        room16.setS(room15);
        room16.setW(null);

        //Room 17
        room17.setN(null);
        room17.setE(room18);
        room17.setS(null);
        room17.setW(room16);

        //Room 18
        room18.setN(null);
        room18.setE(null);
        room18.setS(null);
        room18.setW(room17);

        //Room 19
        room19.setN(room20);
        room19.setE(null);
        room19.setS(null);
        room19.setW(room9);

        //Room 20
        room20.setN(null);
        room20.setE(room21);
        room20.setS(room19);
        room20.setW(null);

        //Room 21
        room21.setN(null);
        room21.setE(room22);
        room21.setS(null);
        room21.setW(room20);

        //Room 22
        room9.setN(room23);
        room9.setE(null);
        room9.setS(null);
        room9.setW(room21);

        //Room 23
        room9.setN(null);
        room9.setE(null);
        room9.setS(room22);
        room9.setW(null);

        starterRoom = room1;

        //Initializing items.
        Item key = new Item("Old Key", "A very old-looking key. Wonder where it belongs");
        Item bucketOfLava = new Item("A bucket of lava(?)", "This probably breaks a few laws of physics...");

        //Set rooms to have items.
        room3.addRoomInventory(key);
        room3.setItemPresent(true);

        room3.addRoomInventory(bucketOfLava);
        room3.setItemPresent(true);
    }




    //Getters
    public Room getStarterRoom() {
        return starterRoom;
    }


}
