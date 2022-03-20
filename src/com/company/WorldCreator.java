package com.company;

public class WorldCreator {


private Room starterRoom;
private Item key = new Item("Old Key", "A very old-looking key. Wonder where it belongs");
private Item bucketOfLava = new Item("A bucket of lava(?)", "This probably breaks a few laws of physics...");

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

        starterRoom = room1;

        //Initializing items.
        Item key = new Item("Old Key", "A very old-looking key. Wonder where it belongs");
        Item bucketOfLava = new Item("A bucket of lava(?)", "This probably breaks a few laws of physics...");

        //Set rooms to have items.
        room3.addRoomInventory(key);
        room3.setItemPresent(true);//

        room3.addRoomInventory(bucketOfLava);
        room3.setItemPresent(true);
    }
    //Getters



    public Room getStarterRoom() {
        return starterRoom;
    }

}
