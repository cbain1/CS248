import java.io.*;
import java.util.*;

public class Wumpus {

    public static void main(String [] args) throws IOException {
        
        // Game Setup
        Scanner in = new Scanner(new FileReader("wumpusRooms.txt")); 

        int size = in.nextInt();
        int spiders = in.nextInt();
        int pits = in.nextInt();
        Boolean isAlive = true;
        char action;
        Boolean isPossible;
        int choice;
        int arrows = 3;
        int location = 0;
        
        Rooms map[] = new Rooms[size];

        for (int x = 0; x <size; x++) { 
            map[x] = new Rooms(in);
        }
        
        while (isAlive) {
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
                        arrows--; 
                        //this is where you need to tell the user if they missed or if they shot something ---- to do this you must firsr assign the monsters to rooms 
                        // if they win tell them they win and the game is over
                        // if they lose, tell them they lost an arrow and they hit nothing
                        System.out.println("You how have "+arrows+" arrows.");

                        
                    }
                }
                    
            }
        }



        
        // = in.nextLine();
        in.close();
    }
}