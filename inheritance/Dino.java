public class Dino extends Fish {

    int horns;

    //int horns uses fins variable
    public Dino(String n, String s, String c, int h) {
        super(n,s,c,h);
    }

    public int getHorns() {return fins;}
    public int getFins() {return 0;}

    public String toString() {
        return ((Animal)this).toString()+" # of horns: "+fins;
    }

}