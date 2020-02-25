
public class People {
    String action;
    int time;
    int size;
    String name;

    public People(String a, int t, int s, String n) {
        action = a;
        time = t;
        size = s;
        name = n;
    }
    public void printPeople () {
        System.out.println("Name: "+name+", size: "+size+", wait time: "+time+"action: "+action);
    }
}