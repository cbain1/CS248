import java.io.*;
import java.util.*;
import java.util.jar.Attributes.Name;

class CPMain {
	private static double totalCampers=0;
	private static double totalAge=0;
	private static int totalVegans=0;
	
	public static void main(String [] args) throws IOException {
		System.out.println("Welcome to Camp Posanivee!!\n");
		
		Scanner cin = new Scanner(new FileReader("camp.txt"));
		BST tree = new BST();
		String name, diet;
		int age;
		
		// this loop reads the file as long as there is another thing in the file to read
		while (cin.hasNext()) {
			char action = cin.next().charAt(0);
			System.out.println("Command: "+action);

			if (action == 'H') {
				help();
			}
			if (action == 'E') {
				CP camper = new CP(cin.next(), cin.nextInt(), cin.nextLine());
				tree.insert(camper);
				totalCampers++;
				if (camper.diet() == "Vegan")
					totalVegans++;
				totalAge += camper.age();

				// if(camper.diet() == "Vegan")
				System.out.println("New camper added\n");

			}
			if (action == 'W') {
				withdraw(cin, tree);
			}
			if (action == 'D') {
				camperInfo(cin, tree);
			}
			if (action == 'A') {
				average();
			}
			if (action == 'L') {
				tree.reset(BST.INORDER);
				while(tree.hasNext())
					printCamper((CP)tree.getNext());
				System.out.println("\n");
			}
			if (action == 'V') {
				System.out.println("There are "+totalVegans+ " vegans at camp.\n");
			
			}
			if (action == 'P') {
				tree.reset(BST.PREORDER);
				while(tree.hasNext())
					printCamper((CP)tree.getNext());
				System.out.println("\n");
			}
			//quit the program  
			if (action == 'Q') {
				System.out.println("Congrats, you made it to the end of the program without getting poison ivy.");
				System.exit(0);
			}
		}
		cin.close();
	}

	//prints the list of commands 
	private static void help() {
		System.out.println("H: Print the list of commands");
		System.out.println("E: Enroll a new camper");
		System.out.println("W: Withdraw a camper");
		System.out.println("D: Display the age and diet of a camper");
		System.out.println("A: Print the average age of the campers");
		System.out.println("L: List all campers names in alphabetical order");
		System.out.println("V: Print the number of vegan campers");
		System.out.println("P: List all campers names in preorder");
		System.out.println("Q: Quit");
	}
	//withdraws a camper 
	private static void withdraw(Scanner cin, BST tree) {

		CP found = (CP)tree.lookup(new CP(cin.next(), 0, ""));

		if(found!=null) {
			tree.delete(found);
			System.out.println("Camper "+ found.name()+ ", age "+found.age()+" has withdrawn\n");
			totalCampers--;
		}
		else
			System.out.println("That camper never enrolled");
	}

	// displays the age and diet of a camper 
	private static void camperInfo(Scanner cin, BST tree) {
		// String name = cin.next();
		CP found = (CP)tree.lookup(new CP(cin.next(),0,""));
		if(found!=null) {
			System.out.println(found.name()+ ", age "+ found.age()+" has diet of "+found.diet()+"\n");
		}
		else
			System.out.println("That camper never enrolled");
	}

	//print the average age of the campers 
	private static void average() {
		if (totalCampers == 0) 
			System.out.println("There are no campers yet! We don't have an average age with no campers!\n");
		else {
			double average;
			average = totalAge/totalCampers;
			System.out.println("The average age of campers is "+average+"\n");
		}
			
	}

	private static void printCamper(CP camper) {
		System.out.println(camper.name()+", "+camper.age()+", "+camper.diet);
	} 

}	