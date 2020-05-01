
public class Heap implements PQ{

	Comparable [] h; 
	int last; 

	public Heap(int maxSize) {
		h = new Comparable[maxSize+1]; 
		last=0;
	}

	public Heap() {this(100);}

	private int parent(int pos) {return pos/2;}
	private int left(int pos) {return 2*pos;}
	private int right(int pos) {return 2*pos+1;}
	private void swap(int a, int b) {
		Comparable tmp=h[a];
		h[a]=h[b];
		h[b]=tmp;
	}

	public void enqueue(Comparable x){
		if(isFull()) return;
		h[++last]=x;
		bubbleup(last);
	}
	private void bubbleup(int pos) {
		if(pos==1) return;
		if(h[parent(pos)].compareTo(h[pos])<=0) return;
		swap(pos, parent(pos));
		bubbleup(parent(pos));
	}

	public Comparable dequeue(){
		if(isEmpty()) return null;
		Comparable root = h[1];
		h[1]=h[last--];	
		bubbledown(1);
		return root;
	}
	private void bubbledown(int pos) {
		if(left(pos)>last) return;
		int runt = left(pos);
		if (right(pos)<=last) {
			if (h[right(pos)].compareTo(h[left(pos)])<0)
				runt=right(pos);
		}
		if(h[pos].compareTo(h[runt])<=0) return; 
		swap(pos, runt);
		bubbledown(runt);
	}

	public Comparable getFront(){
		if (isEmpty()) return null;
		else return h[1];
	}

	public int size() {return last;}
    public boolean isEmpty() {return (last<=0);}
    public boolean isFull() {return (last>=h.length-1);}
    public void makeEmpty() {last=0;} 
}