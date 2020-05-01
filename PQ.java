public interface PQ extends Collection {
	public void enqueue(Comparable x);
	public Comparable dequeue();
	public Comparable getFront();
	
}