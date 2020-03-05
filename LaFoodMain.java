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

		
		
		while (cin.hasNext()) {
			char action = cin.next().charAt(0);

			if (action == 'A') {
				// In order to make this a priority queue you would use the insert function comparing on bribe
				LaFood party = new LaFood(cin);
				Q.insert(party); //change this to insert instead of enqueue -- need to make comparable
				party.printWait();
			}
			if (action == 'T') {
				LaFood party = (LaFood)Q.dequeue();
				timeSat = cin.nextInt();
				party.printReady(timeSat); //this is wrong

				totalWait += party.size()*((int)timeSat-party.time());
				totalParties += party.size();
			}
			if (action == 'Q') {
				System.out.println();
				//Should total parties contain the parties that were never sat?
				average = totalWait/totalParties;
				System.out.println("The average waiting time was: "+String.format("%.2f",average));
				System.out.println();
				System.out.println("The following parties were never sat: ");
				while(!Q.isEmpty())
					((LaFood)Q.dequeue()).print();
			}
			// System.out.println(Q);
		}


		in.close();
		cin.close();
	}
}