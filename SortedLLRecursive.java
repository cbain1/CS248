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
		head=insertHelp(head, x); // sets the head value equal to the return value from insertHelp
		count++;
	}
	public node insertHelp(node head, Comparable x) {
		//base cases 
		//empty list or head.data is bigger than x aka we insert at the front
		if (head==null || x.compareTo(head.data)<0) {
			node newnode = new node();
			newnode.data = x;
			newnode.next = head;
			return newnode; //returns new node as the value of the head node 
		}
		else //recursive case
			head.next=insertHelp(head.next,x);
			return head;
	}

	public Comparable get(int pos) {
		if(!(pos>=0 && pos<count)) return null;
		return getHelp(head,pos);
	}
	private Comparable getHelp(node head, int pos) {
		if(pos==0) return head.data;
		else return getHelp(head.next,pos-1);
	}
	private	Comparable savedinfo;

	public Comparable delete(int pos) {
		if(pos<0 || pos>=count) return null;
		head = deleteHelp(head, pos);
		count--;
		return savedinfo;
	}

	public node deleteHelp(node head, int pos) {
		//base case: delete head node
		if (pos == 0) {
			savedinfo = head.data;
			return head.next;
		}
		else { //recursive case
			head.next = deleteHelp(head.next,pos-1);
			return head;
		}

	}

	public int size() { return count; }
	public boolean isEmpty() { return count<=0; }
	public boolean isFull() { return false; }
	public void makeEmpty()
	{
		head=null; count=0;
	}
	
	private node here;
	
	public void reset() {here=head;}
	public Comparable getNext() {
		if(here==null) return null;
		Comparable item=here.data;
		here=here.next;
		return item;
	}
	public boolean hasNext(){return here!=null;}

	public Comparable last() {
		node isLast = head;
		while(isLast!=null) {
			isLast=isLast.next;
		}
		return isLast.data;
	}
}