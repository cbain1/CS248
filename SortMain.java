import java.io.*;
import java.util.*;

public class SortMain {

    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(new FileReader("fishfile.txt"));
        int fishcount = in.nextInt();

        Fish [] school = new Fish[fishcount];

        for (int i=0; i<school.length;i++) {
            // this Fish is a new constructor
            school[i] = new Fish(in);
		}
		
		Sorts.bubble(school);
		System.out.println("\nSorting...\n");

		for (int i=0; i<school.length;i++) {
            // this Fish is a new constructor
            school[i].print();
		}


        in.close();
    }
}
