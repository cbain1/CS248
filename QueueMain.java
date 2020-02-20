import java.io.*;
import java.util.*;

class QueueMain
{
	
	public static void main(String [] args) throws IOException
	{
		Scanner ff=new Scanner(new FileReader("fishfile.txt"));
		int fishcount;
		fishcount=ff.nextInt();
		
		Queue Q=new QueueDonut();
		
		for(int i=0; i<fishcount; i++)
		{
			Q.enqueue(new Fish(ff));
		}
		
		while(!Q.isEmpty())
			((Fish)Q.dequeue()).print();
	}
}