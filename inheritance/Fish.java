public class Fish extends Animal {
    int fins;

    public Fish(String n, String s, String c, int f) {
        // again using super to access the parent 
        super(n,s,c);
        fins=f;
    }
    public int getFins() {return fins;}

    public String toString() {
        // super here accesses the parent version of the function... can also be used to access data
        return super.toString()+" # of fins: "+fins;
    }

}