class SortedLLRecursive implements SortedList {
	private class node {
		public Comparable data;
		public node next;
	}
	node head;
	int count;

	public SortedLLRecursive() {
		head=null;
		count=0;
	}
	public void insert(Comparable x) {
		node before,after;
		after=head;
		before=null;
	}

	private node inserthelp(node h, Comparable x) {
		//base case
		// empty list or h.data>x
		if (h==null || x.compareTo(h.data)<0) {
			
		}
	}
}