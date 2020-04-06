import java.io.*;
import java.util.*;

class SLMain
{
	
	public static void main(String [] args) throws IOException
	{
		Scanner ff=new Scanner(new FileReader("fishfile.txt"));
		int fishcount;
		fishcount=ff.nextInt();
		
		SortedList fist=new SortedListLL();
		
		for(int i=0; i<fishcount; i++)
		{
			fist.insert(new Fish(ff));
		}
		//print before deletion
		for(int i=0; i<fist.size(); i++)
			((Fish)fist.get(i)).print();
		
		System.out.println("\n");
		
		// Fish sad=(Fish)fist.delete(3);
		// System.out.println("We deleted this fish:");
		// sad.print();
		// System.out.println("\n");
		
		// for(int i=0; i<fist.size(); i++)
		// 	((Fish)fist.get(i)).print();
		
		fist.reset();
		//print after deletion?
		while(fist.hasNext()){
			Fish f= (Fish)fist.getNext();
			f.print();
		}

	}
}