class QueueDonut implements Queue {
    int front, back, count;
    Object [] donut;

    public Queue(int maxSize) {
        donut = new Object[maxSize];
        front=0; 
        back=maxSize-1;
        count=0;
    }
    public int size() {return count;}
    public boolean isEmpty() {return count <=0;}
    public boolean isFull() {return count>donut.length;}
    public void makeEmpty() {count=0;front=0;back=donut.length-1;}

    public void enqueue(Object x) {
        if(isFull()) return;
        back++; 
        if(back>=donut.length) 
            back =0; 
        donut[back]=x;
        count++;
    }
    public Object dequeue() {
        if(isEmpty()) return null;
        int oldFront = front;
        front++;
        if(front >=donut.length) front=0;
        return oldFront;
    }
    public Object getFront() {
        if(isEmpty()) return null;
        else return donut[front];

        //return isEmpty()?null:donut[front];
        // if before ? is true use before colon
        // if before ? is false use after colon
    }
}