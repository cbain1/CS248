import java.util.*;
/** @author Catherine  */
class Fish {
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

        //now we shall write a mutator
        public void sharkAttack() {
            if (fins>0) 
                fins--;
        }
        public void toxicWaste() {fins++;}

}