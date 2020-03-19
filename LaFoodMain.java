import java.io.*;
import java.util.*;

class LaFoodMain {
	
	public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
		System.out.println("Please enter the name of your file: ");
		String name = in.nextLine();
		System.out.println();

		Scanner cin = new Scanner(new FileReader(name));
		LaFoodQueue Q=new LaFoodQueue();

		double average;
		int timeSat;
		double totalParties = 0; 
		double totalWait = 0;

		
		// this loop reads the file as long as there is another thing in the file to read
		while (cin.hasNext()) {
			char action = cin.next().charAt(0);

			if (action == 'A') {
				//builds new LaFood object
				LaFood party = new LaFood(cin);
				Q.insert(party); 
				party.printArrival();
			}
			if (action == 'T') {
				LaFood party = (LaFood)Q.dequeue();
				timeSat = cin.nextInt();
				party.printReady(timeSat); 

				totalWait += party.size()*((int)timeSat-party.time());
				totalParties += party.size();
			}
			if (action == 'Q') {
				System.out.println();
				average = totalWait/totalParties;
				System.out.println("The average waiting time was: "+String.format("%.2f",average));
				System.out.println();
				System.out.println("The following parties were never sat: ");
				while(!Q.isEmpty())
					((LaFood)Q.dequeue()).print();
			}
		}


		in.close();
		cin.close();
	}
}