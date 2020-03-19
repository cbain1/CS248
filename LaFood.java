import java.util.*;

public class LaFood implements Comparable{
	String name;
    int time;
    int size;
	int bribe;
	
	static int count=0;

	// builds new LaFood object from file
	public LaFood(Scanner in) {
		time = in.nextInt();
        size = in.nextInt();
        bribe = in.nextInt();
        name = in.nextLine();
        count+=size;
	}

	// prints the time of arrival for the party 
	public void printArrival() {
		System.out.println("Please wait at the bar,"+name+" (party of "+size+") (time = "+time+")");
	}

	// prints time when the party is sat
	public void printReady(int time) {
		System.out.println("Table for"+name+"! (time= "+time+")");
	}

	// prints parties that were not sat
	public void print() {
		System.out.println(name+", party of size "+size);
	}
	public int size() {
		return size;
	}
	public int  time() {
		return time;
	}
	public int bribe() {
		return bribe;
	}

	// allows parties to be compared based on bribe size
	public int compareTo(Object x) {
		if (x instanceof LaFood) {
			LaFood party=(LaFood)x;

			if(bribe<party.bribe()) return -1;
			if(bribe==party.bribe()) return 0;
			return 1;
		}
		else {
			System.out.println("Error: You can only compare parties to parties, duh!");
			System.exit(1);
		}
		return 0;
	}
}