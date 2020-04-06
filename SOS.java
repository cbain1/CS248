import java.util.*;

public class SOS  {

	public static void main (String [] args) {
		Scanner in = new java.util.Scanner(System.in);

		Integer [] selectionlist = createList(in);
		System.out.println("\n");

		if (selectionlist.length<100) {
			for (int i=0;i<selectionlist.length;i++)
				System.out.print(selectionlist[i]+ " ");
			System.out.println("\n");
		}

		Integer [] bubblelist = copyList(selectionlist);

		doSelection(selectionlist);

		Integer [] insertionlist = copyList(bubblelist);

		doBubble(bubblelist);
		
		Integer [] shellList = copyList(insertionlist);

		doInsertion(insertionlist);

		Integer [] quicklist = copyList(shellList);

		doShell(shellList);

		Integer [] mergelist = copyList(quicklist);

		doQuick(quicklist);

		Integer [] ownlist = copyList(mergelist);

		doMerge(mergelist);

		doOwn(ownlist);

		in.close();
	}

	public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }

	public static Integer [] createList(Scanner in) {
		System.out.println("How long would you like your list to be?");
		Integer length = in.nextInt();
		Integer [] list = new Integer[length];

		for (int i=0;i<length;i++)
			list[i] = getRandomInteger(length+1, 1);
		return list;
	}

	public static Integer [] copyList(Integer [] oldList) {
		Integer [] newList = new Integer[oldList.length];
		for (int i=0;i<oldList.length;i++)
			newList[i]=oldList[i];
		return newList;
	}

	public static void doSelection(Integer [] list) {
		double begin = System.currentTimeMillis();
		Sorts.selection(list); 
		double end = System.currentTimeMillis();
		if (list.length<100) {
			for (int i=0;i<list.length;i++) {
				System.out.print(list[i]+" ");
			}
			System.out.println("\n");
		}
		System.out.print("Selection sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");
	}

	public static void doBubble(Integer [] list) {
		double begin = System.currentTimeMillis();
		Sorts.bubble(list); 
		double end = System.currentTimeMillis();
		if (list.length<100) {
			for (int i=0;i<list.length;i++)
				System.out.print(list[i]+" ");
		}
		System.out.println("\n");
		System.out.print("Bubble sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");
	}

	public static void doInsertion(Integer [] list) {
		double begin = System.currentTimeMillis();
		Sorts.insertion(list); 
		double end = System.currentTimeMillis();
		if (list.length<100) {
			for (int i=0;i<list.length;i++)
				System.out.print(list[i]+" ");
		}
		System.out.println("\n");
		System.out.print("Insertion sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");
	}

	public static void doShell(Integer [] list) {
		double begin = System.currentTimeMillis();
		Sorts.shell(list); 
		double end = System.currentTimeMillis();
		if (list.length<100) {
			for (int i=0;i<list.length;i++)
				System.out.print(list[i]+" ");
		}
		System.out.println("\n");
		System.out.print("Shell sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");
	}

	public static void doQuick(Integer [] list) {
		double begin = System.currentTimeMillis();
		Sorts.quick(list); 
		double end = System.currentTimeMillis();
		if (list.length<100) {
			for (int i=0;i<list.length;i++)
				System.out.print(list[i]+" ");
		}
		System.out.println("\n");
		System.out.print("Quick sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");
	}

	public static void doMerge(Integer [] list) {
		double begin = System.currentTimeMillis();
		Sorts.merge(list); 
		double end = System.currentTimeMillis();
		if (list.length<100) {
			for (int i=0;i<list.length;i++)
				System.out.print(list[i]+" ");
		}
		System.out.println("\n");
		System.out.print("Merge sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");
	}

	public static void doOwn(Integer [] list) {
		double begin = System.currentTimeMillis();
		ownHelp(list,0, list.length-1);
		double end = System.currentTimeMillis();
		System.out.println("\n");
		System.out.print("Merge sort took ");
		System.out.print(end-begin);
		System.out.println(" millisecond(s).");

	}
	private static void ownHelp(Integer [] list, int start, int stop) {
		//base cases
		if (stop<=start)
			return;
		if (start+1==stop) {// length 2
			if (list[start].compareTo(list[stop])>0) // if out of order
				swap(list,start,stop);
			return; // if in order 
		}
		//recursive case 
		int midpoint = (start+stop)/2;
		quickHelp(list, start, midpoint);
		quickHelp(list, midpoint+1,stop);
		domerge(list, start, midpoint, stop);
	}
	private static void swap(Object [] list, int x, int y) {
		Object temp = list[x];
		list[x]=list[y];
		list[y]=temp;
	}
	private static void quickHelp(Comparable [] list, int start, int stop) {
		if (stop<=start) // this occurs when the length is 0 or 1 aka already sorted
			return;
		if (start+1==stop) {// length 2
			if (list[start].compareTo(list[stop])>0) // if out of order
				swap(list,start,stop);
			return; // if in order 
		}
		//recursive case
		int pivotPos=partition(list,start,stop);
		quickHelp(list,start,pivotPos-1);
		quickHelp(list,pivotPos+1,stop);
	}
	private static void domerge(Comparable [] list, int start, int mid, int stop) {
		Comparable [] A = new Comparable[stop-start+1];
		int left=start;
		int right=mid+1;
		for(int i=0;i<A.length;i++) {
			//pull from the left if [1] the right is empty or [2] the left is not empty and the left item is smaller
			if(right>stop || (left<=mid && list[left].compareTo(list[right])<=0)) 
				A[i]=list[left++];
			else 
				A[i] = list[right++];
		}
		for (int i=0;i<A.length;i++)
			list[start+1]=A[i];
	}
	private static int partition(Comparable [] list, int start, int stop){
		Comparable pivot = list[stop];
		int beginBig=start;
		for(int i=start;i<stop;i++) {
			if(list[i].compareTo(pivot)<0) { // if list[i] is smaller than the pivot
				swap(list,beginBig,i); // swap the object with where big began to move it to the small section 
				beginBig++; // big now begins one more to the right
			}
		}
		swap(list,stop,beginBig); // moves big to the pivot
		return beginBig; // this is now the pivot position
	}

}