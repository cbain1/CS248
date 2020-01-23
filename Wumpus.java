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
        int assignent;
        Boolean isPossible;
        int choice;
        int arrows = 3;
        int location = 0;

        
        Rooms map[] = new Rooms[size];

        for (int x = 0; x <size; x++) { 
            map[x] = new Rooms(in);
        }

        randomNumber = random.nextInt(1,size);
            map[randomNumber].wumpus = true;

        assignSpiders(spiders);

        assignPits(pits);

        
        
        while (isPAlive) {
            map[location].printLocation();
            map[location].printDescription();
            map[location].printTunnels();
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
                    else {
                        System.out.println("Which room do you want to shoot into to?");
                        choice = cin.nextnt();
                        arrows--; 
                        if(map[choice-1].isSpiders)
                            System.out.println("Congrats you killed some spiders.");
                        if(map[choice-1].isPits)
                            System.out.println("Way to waste an arrow, that did nothing");
                        if(map[choice-1].isWumpus) {
                            System.out.println("Way to go! You killed the wumpus! You win!")
                            break;
                        }
                        
                        //this is where you need to tell the user if they missed or if they shot something ---- to do this you must firsr assign the monsters to rooms 
                        // if they win tell them they win and the game is over
                        // if they lose, tell them they lost an arrow and they hit nothing
                        System.out.println("You how have "+arrows+" arrows.");
                        action = cin.next().charAt(0);  
                    }
                }
                    
            }
            System.out.println("Congrats you beat the game.")
        }



        
        // = in.nextLine();
        in.close();
    }
    public int generateRandom(size) {
        return random.nextInt(1,size);
    }

    public void assignSpiders(spiders) {
        for (int i=0;i<spiders;i++) {
            assignment = generateRandom(size);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].spiders = true;  
        }
    }

    public void assignPits(pits) {
        for (int i=0;i<pits;i++) {
            assignment = generateRandom(size);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].pits = true;  
        }
    }

    public void assignStorage(storage) {
        for (int i=0;i<1;i++) {
            assignment = generateRandom(size);
            if (map[assignment].hazard())
                i--;
            else
                map[assignment].storage = true;  
        }
    }


}