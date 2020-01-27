import java.io.*;
import java.util.*;

public class fishMain2 {

    public static Comparable max(Comparable [] list) {
        Comparable maxsofar=list[0];
        for (int i=0; i<list.length; i++) {
            if(list[i].compareTo(maxsofar)>0)
                maxsofar=list[i];
        }
        return maxsofar;

    }
    // so... what does this statement here mean?
    // public means it is usable outside the class
    // static means shared among all objects in a given class AND it exists no matter how many objects of that class exist - inlcuding 0
    // aka static ALWAYS exists
    public static final int frenzySize = 20;
    static void feedingFrenzy(Fish [] A) {
        for (int i=0; i<frenzySize; i++) {
            int target=(int)(A.length*Math.random());
            A[target].sharkAttack();
        }
    }

    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(new FileReader("fish.txt"));
        int fishcount = in.nextInt();

        Fish [] school = new Fish[fishcount];

        for (int i=0; i<school.length;i++) {
            // this Fish is a new constructor
            school[i] = new Fish(in);
        }

        System.out.println("Oh no! Sharks!");
        feedingFrenzy(school);
        for(int i=0; i<school.length; i++) {
            school[i].print();
        }

        in.close();
    }
}