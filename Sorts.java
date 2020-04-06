public class Sorts{
	public static void selection(Comparable [] list) { // call this via Sorts.selection, passed by reference
		//find max, move to end
		for(int last=list.length-1;last>0;last--) {
			int maxPos = findMax(list,last);
			swap(list,maxPos,last);
		}
	}
	//selection helper function
	private static void swap(Object [] list, int x, int y) {
		Object temp = list[x];
		list[x]=list[y];
		list[y]=temp;
	}
	// selection helper function
	private static int findMax(Comparable [] list, int last) {
		int maxpos=0;
		for (int i=1;i<=last;i++)
			if (list[maxpos].compareTo(list[i]) < 0) maxpos=i;
		return maxpos;
	}

	public static void bubble(Comparable [] list) {
		//find first, compare to next, move 
		for (int pass=0;pass<list.length;pass++) {
			boolean isSorted=true;
			for(int i=0; i<list.length-1;i++) {
				if (list[i].compareTo(list[i+1])>0) {
					isSorted=false;
					swap(list,i,i+1);
				}
			}
			if(isSorted) return;
		}
	}

	public static void insertion(Comparable [] list) {
		for (int toInsert=1;toInsert<list.length;toInsert++) {
			Comparable savedItem = list[toInsert];
			int i;
			for (i=toInsert-1;i>=0;i--) {
				//bigger than the savedItem
				if(savedItem.compareTo(list[i])<0) 
					list[i+1] = list[i];
				//if smaller than savedItem
				else {
					list[i+1] = savedItem;
					break; // this happens if i>0
				}
			}
			if(i<0)
				list[0]=savedItem;
			//printing to show how it sorts 
			// System.out.println();
			// for (int j=0;j<=toInsert;j++) System.out.println(list[j]);
		}
	}
	public static void shellInsertion(Comparable [] list, int offset, int gap) {
		for (int toInsert=offset+gap;toInsert<list.length;toInsert+=gap) {
			Comparable savedItem = list[toInsert];
			int i;
			for (i=toInsert-gap;i>=0;i-=gap) {
				//bigger than the savedItem
				if(savedItem.compareTo(list[i])<0) 
					list[i+gap] = list[i];
				//if smaller than savedItem
				else {
					list[i+gap] = savedItem;
					break; // this happens if i>0
				}
			}
			if(i<0)
				list[offset]=savedItem;

		}
	}
	public static void shell(Comparable [] list) {
		int gap =list.length/5;
		while (gap>1) {
			for(int offset=0;offset<gap;offset++)
				shellInsertion(list,offset,gap);
			gap = (int) (gap/2.2);
		}	
		insertion(list); // we just run normal insertion once the gap is 1
	}

	public static void quick(Comparable [] list) {
		quickHelp(list,0,list.length-1);
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
	//we need to keep track of the beginning of the big function
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


	public static void merge(Comparable [] list) {
		mergeHelp(list,0, list.length-1);

	}
	private static void mergeHelp(Comparable [] list, int start, int stop) {
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
		mergeHelp(list, start, midpoint);
		mergeHelp(list, midpoint+1,stop);
		domerge(list, start, midpoint, stop);
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

}
