class LaFoodQueue implements Queue {
	
	public class node {
		private Object data;
		private node next;
	}
	node front,back;
	int count;
	node head;

	// makes a new queue
	public void QueueLL() {
		makeEmpty();
	}
	// this function takes in the LaFood object and enqueues it -- this function is not used 
	public void enqueue(Object x) {
		node newnode = new node();
		newnode.data = x;
		newnode.next = null;
		count++;
		if (back==null) //we can only do if back is null here becuase we were careful in deque to make sure we set it back to null
			front=newnode; 
		else 
			back.next = newnode;
		back=newnode;

	}

	// this function inserts a LaFood object into the queue based on the amount of the bribe
	public void insert(Comparable x) {
		node before,after;
		after=front; before=null;

		while(after!=null && ((Comparable)after.data).compareTo(x)>0)
		{
			before=after;
			after=after.next;
		}
		node newnode=new node();
		newnode.data=x;
		newnode.next=after;
		if(before==null) // we're inserting at the front
			front=newnode;
		else
			before.next=newnode;
		count++;
	}

	// this function dequeues the first item in the queue
	public Object dequeue() {
		if(isEmpty()) return null;
		Object savedItem=front.data;
		count--;
		front=front.next;
		if(front==null) back=null;
		return savedItem;
	}

	//get the front of the queue
	public Object getFront() {
		if(isEmpty()) return null;
		else return front.data;
	}

	public int size() {return count;}
	public boolean isEmpty() {return count<=0;}
	public boolean isFull() {return false;}
	public void makeEmpty() {
		front=back=null;
		count=0;
	}
	// public String toString() {
	// 	((LaFood) (front.data)).print();
	// 	return ";";
	// }
}