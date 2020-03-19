class SortedListLL implements SortedList
{
	private class node
	{
		public Comparable data;
		public node next;
	}
	node head;
	int count;
	
	public SortedListLL()
	{
		head=null; count=0;
	}
	
	public void insert(Comparable x)
	{
		node before,after;
		after=head; before=null;
		//while(after.data<x)
		while(after!=null && after.data.compareTo(x)<0)
		{
			before=after;
			after=after.next;
		}
		node newnode=new node();
		newnode.data=x;
		newnode.next=after;
		if(before==null) // we're inserting at the front
			head=newnode;
		else
			before.next=newnode;
		count++;
	}

	public Comparable get(int pos)
	{
		if(!(pos>=0 && pos<count)) return null;
		return getHelp(head,pos);
	}
	private Comparable getHelp(node head, int pos) {
		if(pos==0) return head.data;
		else return getHelp(head.next,pos-1);
	}

	public Comparable delete(int pos)
	{ 
		if(!(pos>=0 && pos<count)) return null; // if they try to have a position that is negative or larger than the list that exists
		node before=head; // create a before node and have it set to the front of the list
		for(int i=0; i<pos-1; i++) // continue moving along the list until you reach the position requested 
			before=before.next; 
		Comparable saveditem; // create this thing 
		if(pos==0) // deleting the first item
		{
			saveditem=head.data; // save the data from the head node
			head=head.next; // set head to the next node 
		}
		else
		{
			saveditem=before.next.data; //saving data from the next node
			before.next=before.next.next; // setting the before pointer to be the pointer of the following node
		}
		count--; 
		return saveditem;
	}
	
	public int size() { return count; }
	public boolean isEmpty() { return count<=0; }
	public boolean isFull() { return false; }
	public void makeEmpty()
	{
		head=null; count=0;
	}
	
	public node here;
	
	public void reset() {here=head;}
	public Comparable getNext() {
		if(here==null) return null;
		Comparable item=here.data;
		here=here.next;
		return item;
	}
	public boolean hasNext(){return here!=null;}
	
}