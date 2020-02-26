import java.util.*;

public class Rooms {

    
    int room;
    int ad1;
    int ad2;
    int ad3;
    int assignment;
    String description;
    Boolean isTuskenRaider;
    Boolean isQuicksand;
    Boolean isBountyHunter;
    Boolean isStorage;
    Boolean isJawa;
    /** generates room objects  */
    public Rooms(Scanner in) {
        room = in.nextInt();
        ad1 = in.nextInt();
        ad2 = in.nextInt();
        ad3 = in.nextInt();
        in.nextLine();
        description = in.nextLine();
        isTuskenRaider = false;
        isQuicksand = false;
        isBountyHunter = false;
        isStorage = false;
        isJawa = false;
    }

    /** prints location */
    public void printLocation() {
        System.out.println("You are currently in room "+room);
    }
     /** prints if they can go in that room or not  */
    public void printCheck () {
        System.out.println(room);
    }
     /** prints description of the room */
    public void printDescription() {
        System.out.println(description);
    }
     /** prints the tunnels they have access to */
    public void printTunnels () {
        System.out.println("There are tunnels to rooms "+ad1+","+ad2+", and "+ad3);
    }

     /** checks to see if the user can move/shoot to the choice they made */
    public Boolean check(int choice) {
        return choice == ad1 || choice == ad2 || choice == ad3;
    }
     /** checks to see if a hazard already exists in a given room */
    public Boolean hazard() {
        return isBountyHunter || isTuskenRaider || isQuicksand|| isStorage;
    }
}
