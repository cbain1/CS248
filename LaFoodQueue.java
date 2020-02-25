public class LaFoodQueue implements Queue {
	int front, back;
	int count;
	Object [] donut;
	
	public LaFoodQueue(int maxsize) {
		donut = new Object[maxsize];
		front=0;
		back=maxsize-1;
		count=0;
	}
	public LaFoodQueue()	{ this(100); }
	
	public void enqueue(Object x) {
		if(isFull()) return; // do nothing
		back++; if(back>=donut.length) back=0;
		donut[back]=x;
		count++;
	}
	public Object dequeue() {
		if(isEmpty()) return null;
		int oldfront=front;
		front++; if(front>=donut.length) front=0;
		count--;
		return donut[oldfront];
	}
	public Object getFront() {
		if(isEmpty()) return null;
		else return donut[front];
		
		// return isEmpty()?null:donut[front];
	}
	
	public int size() { return count; }
	public boolean isEmpty() { return count<=0; }
	public boolean isFull() { return count>=donut.length; }
	public void makeEmpty() {
        count=0; 
        front=0; 
        back=donut.length-1; 
    }
}