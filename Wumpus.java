import java.io.*;
import java.util.*;

public class Wumpus {

    public static void main(String [] args) throws IOException {
        
        // Game Setup
        Scanner in = new Scanner(new FileReader("wumpusRooms.txt")); 

        int size = in.nextInt();
        int TuskenRaider = in.nextInt();
        int quicksand = in.nextInt();
        Boolean isPAlive = true;
        char action;
        Boolean isPossible;
        int choice;
        int ammo = 3;
        int location = 0;

        //Scanner to obtain what the player wants to do?
        Scanner cin = new Scanner(System.in);

        
        Rooms map[] = new Rooms[size];

        for (int x = 0; x <size; x++) { 
            map[x] = new Rooms(in);
        }

        assignHazards(TuskenRaider, quicksand, map);

        while (isPAlive) {
            map[location].printLocation();
            map[location].printDescription();
            map[location].printTunnels();
            System.out.println("You have "+ammo+" blasts left.");
            if(map[map[location].ad1-1].isTuskenRaider || map[map[location].ad2-1].isTuskenRaider || map[map[location].ad3-1].isTuskenRaider) 
                System.out.println("You hear braying...");
            if(map[map[location].ad1-1].isQuicksand || map[map[location].ad2-1].isQuicksand || map[map[location].ad3-1].isQuicksand) 
                System.out.println("You sense the ground may not be so stable.");
            if(map[map[location].ad1-1].isBountyHunter || map[map[location].ad2-1].isBountyHunter|| map[map[location].ad3-1].isBountyHunter) 
                System.out.println("You hear the faint beeping of a tracker");
            
            System.out.println("(M)ove or (S)hoot?");

            action = cin.next().charAt(0);


            while (action == 'M' || action == 'S') {
                if (action == 'S' && ammo == 0) {
                    System.out.println("You can't do that! Can you not read?"); 
                    System.out.println("You have "+ammo+" blasts left.");
                    map[location].printTunnels();
                    System.out.println("(M)ove or (S)hoot?");
                    action = cin.next().charAt(0);
                }
                System.out.println("Which room?");
                choice = cin.nextInt();
                isPossible = map[location].check(choice);
                if (!isPossible) {
                    System.out.println("You can't do that! Can you not read?");
                    map[location].printTunnels();
                    System.out.println("(M)ove or (S)hoot?");
                    action = cin.next().charAt(0);
                }
                else {
                    if (action == 'M') {
                        location=choice-1;
                        if(map[location].isBountyHunter) {
                            System.out.println("You encountered the Bounty Hunter and been killed. Sorry.");
                            System.exit(0);
                        }
                        if(map[location].isTuskenRaider) {
                            System.out.println("You encountered some Tusken Raiders and were killed. Sorry");
                            System.exit(0);
                        }
                        if(map[location].isQuicksand) {
                            System.out.println("You got sucked into some quicksand and died. Sorry");
                            System.exit(0);
                        }
                        if(map[location].isStorage) {
                            System.out.println("Congrats, you found the storage room.");
                            ammo = 3;
                        }
                        if(map[location].isJawa) {
                            System.out.println("Looks like you encountered the Jawa. They took you in their sandcrawler and then threw you out.");
                            location = getRandomInteger(map.length-1, 0);
                            if(map[location].isBountyHunter) {
                                System.out.println("You encountered the Bounty Hunter and were killed. Sorry.");
                                System.exit(0);
                            }
                            if(map[location].isTuskenRaider) {
                                System.out.println("You encountered some Tusken Raiders and were killed. Sorry");
                                System.exit(0);
                            }
                            if(map[location].isQuicksand) {
                                System.out.println("You got sucked into some quicksand and died. Sorry");
                                System.exit(0);
                            }
                            if(map[location].isStorage) {
                                System.out.println("Congrats, you found the storage room.");
                                ammo = 3;
                            }
                        }
                        action='D';
                    }
                    //if they chose to shoot
                    else {
                        ammo--; 
                        if(map[choice-1].isTuskenRaider)
                            System.out.println("Your blaster found itself in the leg of a Tusken Raider... he is not so happy with you.");
                        else if(map[choice-1].isBountyHunter) {
                            System.out.println("Way to go! You surprised the Bounty Hunter and killed him!");
                            System.out.println("Congrats you beat the game.");
                            System.exit(0);
                        }
                        else 
                            System.out.println("Way to waist a shot, that did nothing.");
                    }  
                        action = 'D';
                }
            }  
        }  
    }

        
      // = in.nextLine();

    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

    public static void move(int location, int choice, Rooms [] map, int ammo) {
        
    }

    public static void assignHazards(int spiders, int pits, Rooms [] map) {
        int assignment = getRandomInteger(map.length-1,1);
        map[assignment].isBountyHunter = true;
        for (int i=0;i<spiders;i++) {
            assignment = getRandomInteger(map.length-1,1);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].isTuskenRaider = true;
        }
        for (int i=0;i<pits;i++) {
            assignment = getRandomInteger(map.length-1,1);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].isQuicksand = true;  
        }
        for (int i=0;i<1;i++) {
            assignment = getRandomInteger(map.length-1,1);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].isStorage = true;  
        }
        for (int i=0;i<1; i++) {
            assignment = getRandomInteger(map.length-1,1);
            if(map[assignment].hazard())
                i--;
            else
                map[assignment].isJawa = true;
        }
    }
}