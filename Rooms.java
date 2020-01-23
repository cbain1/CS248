import java.util.*;

public class Rooms {

    
    int room;
    int ad1;
    int ad2;
    int ad3;
    int assignment;
    String description;
    Boolean isSpiders;
    Boolean isPits;
    Boolean isWumpus;
    Boolean isStorage;

    public Rooms(Scanner in) {
        room = in.nextInt();
        ad1 = in.nextInt();
        ad2 = in.nextInt();
        ad3 = in.nextInt();
        in.nextLine();
        description = in.nextLine();
        isSpiders = false;
        isPits = false;
        isWumpus= false;
        isStorage = false;
    }

    public void printLocation() {
         System.out.println("You are currently in room "+room);
    }
    public void printDescription() {
         System.out.println(description);
    }
    public void printTunnels () {
         System.out.println("There are tunnels to rooms "+ad1+","+ad2+", and "+ad3);
    }

    public Boolean check(int choice) {
        return choice == ad1 || choice == ad2 || choice == ad3;
    }

    public Boolean hazard() {
        return isWumpus || isSpiders || isPits || isStorage;
    }
    
    


}
