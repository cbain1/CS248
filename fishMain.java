public class fishMain {
    // so... what does this statement here mean?
    // public means it is usable outside the class
    // static means shared among all objects in a given class AND it exists no matter how many objects of that class exist - inlcuding 0
    // aka static ALWAYS exists
    
    public static void main(String [] args) {
        Fish f;
        Fish g;
        f = new Fish("Nemo","orange","clownfish",7); 
        System.out.println("count="+Fish.count);
        g= new Fish("Angela","blue","angelfish",7);
        Fish s = new Fish("Spongebob","yellow","sponge",0);
        System.out.println("count="+Fish.count);

        f.print();

        System.out.println(f.getSpecies());
        f.sharkAttack();
        g.sharkAttack();
        s.sharkAttack();
        System.out.println("oh no! a shark");
        f.print();
        g.print();
        s.print();
    }
}