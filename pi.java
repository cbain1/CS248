
import java.util.*;

class pi {

    static int getLimit (){

        int limit; // declare integer variable 
        System.out.print("Please enter a limit: ");

        //make a scanner and connect to the keyboard 
        // cin here is just the name of the scanner, you can call it whatever you want
        Scanner cin=new Scanner(System.in);

         // do the read 
        limit=cin.nextInt();
        cin.close();

        return limit;
    }
    public static void main(String [] args) {
        int limit = getLimit();

        while (limit <= 0) {
            System.out.println("Input must be larger than 0, please input a new number ");
            limit=getLimit();
        }
        // this is basically just a cout statement - it will print to the
        System.out.println(limit);

        double sum=0; 

        for (int x=1; x<=limit; x++) {
            sum=sum+1.0/(1.0*x*x);
        }

        System.out.println("Sum = " + sum);

        double Pi; 
        Pi=Math.sqrt(6*sum);
        System.out.println("Pi = "+Pi);
    }

}



/* What we are doing tomororw (1/15):
strings 
arrays 
file I/O
*/