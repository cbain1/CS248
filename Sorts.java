class Sorts {
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
}