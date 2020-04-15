
import java.util.*;
import java.io.*;

/**
 * @author Catherine Bain
 */

public class CP implements Comparable{
	String name;
    int age;
	String diet;

	public CP(String n, int a, String d) {
		name =n;
		age=a;
		if (d.length() > 1) {
			if (d.charAt(1) == 'V')
				diet="Vegan";
			else 
				diet = "Anything";
		}

		
	}
	
	public String name() {
		return name;
	}
	public int age() {
		return age;
	}
	public String diet() {
		return diet;
	}

	public int compareTo(Object x) {
		if (x instanceof CP) {
			CP c=(CP)x;
			if(name.compareTo(c.name())<0) return -1; 
			if(name.compareTo(c.name()) == 0) return 0;
			return 1; // if fins of first are > fins of second
		}
		else {//panic
			System.out.println("Error: that is not a camper!");
			System.exit(0);
			return 0;
		}

	}

}