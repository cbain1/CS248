class LaFoodQueue implements Queue {
	
	public class node {
		private Object data;
		private node next;
	}
	node front,back;
	int count;

	public void QueueLL() {
		makeEmpty();
	}
	
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
	public Object dequeue() {
		if(isEmpty()) return null;
		Object savedItem=front.data;
		count--;
		front=front.next;
		if(front==null) back=null;
		return savedItem;
	}
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
}