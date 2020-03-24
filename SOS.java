import java.util.*;

public class SOS  {

	public static void main (String [] args) {
		Scanner in = new java.util.Scanner(System.in);

		Integer [] list = createList(in);
		System.out.println("\n");

		for (int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
		System.out.println("\n");

		Sorts.bubble(list); // figure out how to use this function but with integers instead of comparable objects -- this seems dumb 

		for (int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}

		in.close();
	}

	public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

	public static Integer [] createList(Scanner in) {
		System.out.println("How long would you like your list to be?");
		Integer length = in.nextInt();
		Integer [] list = new Integer[length];

		for (int i=0;i<length;i++) {
			list[i] = getRandomInteger(length+1, 1);
		}
		return list;
	}


}