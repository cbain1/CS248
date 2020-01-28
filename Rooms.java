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

    public void printLocation() {
        System.out.println("You are currently in room "+room);
    }
    public void printCheck () {
        System.out.println(room);
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
        return isBountyHunter || isTuskenRaider || isQuicksand|| isStorage;
    }
}
