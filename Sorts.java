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
}