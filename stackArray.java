public class stackArray implements Stack, Collection{

    int top;
    Object [] items;

    public stackArray(int maxSize) {
        top=-1;
        items=new Object[maxSize];
    }
    public stackArray() {
        this(100);
        // this is a pointer to yourself, so it calls the first constructor giving you a default size for the array if you didn't give a max size
    }

    public void push(Object x) {
        if (isFull())
            return;
        items[++top] = x;
    }
    public Object pop(){
        if (isEmpty())
            return "The stack is empty.";
        else
            return items[top--];
    }
    public Object getTop(){
        if (isEmpty()) 
            return "The stack is empty.";
        else 
            return items[top];
    } 
    public int size() {return top+1;}
    public boolean isEmpty() {return size()<=0;}
    public boolean isFull(){return top>=items.length-1;}
    public void makeEmpty() {top=-1;}
}