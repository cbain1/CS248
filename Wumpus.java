import java.io.*;
import java.util.*;

public class Wumpus {

    public static void main(String [] args) throws IOException {
        
        // Game Setup
        Scanner in = new Scanner(new FileReader("wumpusRooms.txt")); 

        int size = in.nextInt();
        int spiders = in.nextInt();
        int pits = in.nextInt();
        Boolean isPAlive = true;
        char action;
        Boolean isPossible;
        int choice;
        int arrows = 3;
        int location = 0;

        
        Rooms map[] = new Rooms[size];

        for (int x = 0; x <size; x++) { 
            map[x] = new Rooms(in);
        }
        int randomNumber;
        randomNumber = (int) Math.random()*(size-1)+1;
            map[randomNumber].isWumpus = true;

        assignSpiders(spiders, map);

        assignPits(pits, map);

        assignStorage(map);

        
        while (isPAlive) {
            map[location].printLocation();
            map[location].printDescription();
            map[location].printTunnels();
            System.out.println("You have "+arrows+" left.");
            if(map[map[location].ad1].isSpiders || map[map[location].ad2].isSpiders || map[map[location].ad3].isSpiders) 
                System.out.println("You hear clicking...");
            if(map[map[location].ad1].isPits || map[map[location].ad2].isPits || map[map[location].ad3].isPits) 
                System.out.println("You smell a muggy smell.");
            if(map[map[location].ad1].isWumpus || map[map[location].ad2].isWumpus || map[map[location].ad3].isWumpus) 
                System.out.println("You smell a smelly smell... that smells like Wumpus");

            System.out.println("(M)ove or (S)hoot?");


            //Scanner to obtain what the player wants to do?
            Scanner cin = new Scanner(System.in);
            action = cin.next().charAt(0);


            while (action == 'M' || action == 'S') {
                System.out.println("Which room?");
                choice = cin.nextInt();
                isPossible = map[location].check(choice);
                if (!isPossible) {
                    System.out.println("You can't do that! Can you not read?");
                    map[location].printTunnels();
                    System.out.println("(M)ove or (S)hoot?");
                    action = cin.next().charAt(0);
                }
                else if (isPossible) {
                    if (action == 'M') {
                        location=choice-1;
                        action='D';
                    }
                    //if they chose to shoot
                    else {
                        System.out.println("Which room do you want to shoot into to?");
                        choice = cin.nextInt();
                        arrows--; 
                        if(map[choice-1].isSpiders)
                            System.out.println("Congrats you killed some spiders.");
                        if(map[choice-1].isWumpus) {
                            System.out.println("Way to go! You killed the wumpus!");
                            break;
                        }
                        else 
                            System.out.println("Way to waste an arrow, that did nothing.");
                    }  
                        //this is where you need to tell the user if they missed or if they shot something ---- to do this you must firsr assign the monsters to rooms 
                        // if they win tell them they win and the game is over
                        // if they lose, tell them they lost an arrow and they hit nothing
                        System.out.println("You how have "+arrows+" arrows.");
                        action = cin.next().charAt(0);  
                }
            }
                cin.close();   
        }  
        System.out.println("Congrats you beat the game.");  
    }

        
      // = in.nextLine();
    public static int generateRandom(int size) {
        return (int) Math.random()*(size-1)+1;
    }

    public static void assignSpiders(int spiders, Rooms [] map) {
        for (int i=0;i<spiders;i++) {
            int assignment = generateRandom(map.length);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].isSpiders = true;  
        }
    }

    public static void assignPits(int pits, Rooms [] map) {
        for (int i=0;i<pits;i++) {
            int assignment = generateRandom(map.length);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].isPits = true;  
        }
    }

    public static void assignStorage(Rooms [] map) {
        for (int i=0;i<1;i++) {
            int assignment = generateRandom(map.length);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].isStorage = true;  
        }
    }


}