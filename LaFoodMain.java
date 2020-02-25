import java.io.*;
import java.util.*;

class LaFoodMain {
	
	public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of your file: ");
        String name = in.nextLine();

        Scanner cin = new Scanner(new FileReader(name));
		
		String line = cin.nextLine();
		System.out.println(line);

		
		Queue Q=new LaFoodQueue();
		
		
		while(!Q.isEmpty())
			((Fish)Q.dequeue()).print();
		
		in.close();
		cin.close();
	}
}