import java.io.*;
import java.util.*;

class PQMain
{
	
	public static void main(String [] args) throws IOException
	{
		Scanner ff=new Scanner(new FileReader("fishfile.txt"));
		int fishcount;
		fishcount=ff.nextInt();
		
		PQ hof=new Heap();
		
		for(int i=0; i<fishcount; i++)
		{
			hof.enqueue(new Fish(ff));
		}

		while(!hof.isEmpty()) {
			System.out.println(hof.dequeue());
		}
		
	}	
}