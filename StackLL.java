class StackLL implements Stack {
    private class node {
        public Object data;
        public node next;
    }
    node top;
    int count;

    public StackLL() {
        count = 0; 
        top = null;
    }

    public void push(Object x) {
        node newNode = new node ();
        newNode.data=x;
        newNode.next=top;
        top=newNode;
        count++;
    }
    public Object pop() {
        if(isEmpty())
            return null;
        Object oldTop = top.data;
        top = top.next;
        count--;
        return oldTop;
    }
    public Object getTop() {
        if(isEmpty())
            return null;
        return top.data;
    }
    public int size() {return count;}
    public boolean isEmpty() {return count<=0;}
    public boolean isFull() {return false;} // this is not a concern bc you just add more nodes 
    public void makeEmpty() {top=null; count=0;}
}
