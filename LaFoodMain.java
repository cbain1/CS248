import java.io.*;
import java.util.*;

class LaFoodMain {
	
	public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of your file: ");
        String name = in.nextLine();

		Scanner cin = new Scanner(new FileReader(name));
		Queue Q=new LaFoodQueue();
		
		while (cin.hasNext()) {
			String action = cin.next();

			if (action == "A") {
				enqueue 
			}
		}


		
		in.close();
		cin.close();
	}
}