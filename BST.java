import java.io.*;

class BST implements Collection {

	private class treenode {
	private Comparable data;
	public treenode left;
	public treenode right;
	}

	treenode root;
	int count;

	public BST() {
		root=null;count=0;
		Q=new QueueLL(); 
	}

	public void insert(Comparable x){
		root=insertHelp(root,x);
		count++;
	}
	private treenode insertHelp(treenode r, Comparable x) {
		if (r==null) {
			treenode newnode = new treenode();
			newnode.data=x;
			newnode.left=newnode.right=null;
			return newnode;
		}
		if (x.compareTo(r.data)<0) 
			r.left=insertHelp(r.left,x);
		else
			r.right=insertHelp(r.right,x);
		return r;
	}

	public Comparable lookup(Comparable x) {
		return luh(root,x);
	}
	private Comparable luh(treenode r, Comparable x) {
		if (r==null) {return null;}
		if (x.compareTo(r.data)==0) return r.data;
		if (x.compareTo(r.data)<0) return luh(r.left,x);
		return luh(r.right,x);
	}

	public static final int PREORDER=-1;
	public static final int INORDER=0;
	public static final int POSTORDER=1;

	private Queue Q; 

	public void reset(int order) {
		Q.makeEmpty();
		traversal(root, order);
	}

	private void traversal(treenode r, int order) {
		if (r==null) return;
		if(order==PREORDER) {Q.enqueue(r.data);}
		traversal(r.left,order);
		if(order==INORDER) {Q.enqueue(r.data);}
		traversal(r.right,order);
		if(order==POSTORDER) {Q.enqueue(r.data);}
	}

	public Comparable getNext() {return (Comparable)Q.dequeue();}

	public boolean hasNext() {return !Q.isEmpty();}

	public void print() {printHelp(root);}
	private void printHelp(treenode r) {
		if (r==null) return;
		// these come out in sorted order because this is written as inorder
		printHelp(r.left);
		System.out.println(r.data);
		printHelp(r.right);
	}

	public int size() {return count;}
	public boolean isEmpty() {return root==null;}
	public boolean isFull() {return false;}
	public void makeEmpty() {root=null;count=0;}
}