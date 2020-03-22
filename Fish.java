import java.util.*;
/** @author Catherine  */
public class Fish implements Comparable {
    // first we will add our data members
    String name;
    String color;
    String species;
    int fins;

    static int count=0;

    // now we will add our members 

        //first our constructor -- public means it is usable outside of the given class
    /** @param n The fish name
        @param c is color
        @param s is species
        @param f is fins
     */
    public Fish(String n, String c, String s, int f) {
        name = n;
        color = c;
        species = s;
        fins = f;
        count++;
    }
    public Fish(Scanner in) {
        name = in.next();
        color = in.next();
        species = in.next();
        fins = in.nextInt();
        count++;
    }
        //now we add an observer
        public void print() {
            System.out.println("fish: "+name+", species= "+species+", color= "+color+", #fins= "+fins);
        }
        /** @return the name of the fish */
        public String getName() {return name;}
        public String getSpecies() {return species;}
        public String getColor() {return color;}
        public int getFins() {return fins;}

        public int compareTo(Object x) {
            // but is it a fish thought?
            if (x instanceof Fish) {
                Fish f=(Fish)x;
                // lets compare by name
                // return name.compareTo(f.getName());
                //by fins
                if(fins<f.getFins()) return -1; //if fins of first are < fins of second
                if(fins==f.getFins()) return 0;
                return 1; // if fins of first are > fins of second
            }
            else {//panic
                System.out.println("Error: You can only compare fish to fish, duh!");
                System.exit(1);
            }
            return 0;
        }

        //now we shall write a mutator
        public void sharkAttack() {
            if (fins>0) 
                fins--;
        }
        public void toxicWaste() {fins++;}

}