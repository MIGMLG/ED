package Queue;

public class CircularArrayQueue<T> implements QueueADT<T>{

    private final int DEFAULT_CAPACITY = 10;

    private T[] queue;
    private int front, rear;
    private int size = 0;

    public CircularArrayQueue() {
        queue = (T[])(new Object[DEFAULT_CAPACITY]);
        front = rear = 0;
    }

    @Override
    public void enqueue(T element) {
        if(size() == queue.length){
            myQueueResize();
            front = 0;
            rear = size();
            queue[rear] = element;
            rear = (rear +1) % queue.length;
            size++;
        }else{
            queue[rear] = element;
            rear = (rear +1) % queue.length;
            size++;
        }

    }

    @Override
    public T dequeue() {
        if(size() == 0){
            return null;
        }else if ( size() == 1){
            T tmp = queue[front];
            front = rear = 0;
            size--;
            return tmp;
        } else {
            T tmp = queue[front];
            queue[front] = null;
            front = (front + 1) % queue.length;
            size--;
            return tmp;
        }
    }

    @Override
    public T first() {
        if(size() == 0){
            return null;
        }else {
            return queue[front];
        }
    }

    @Override
    public boolean isEmpty() {
        return (size()==0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString(){
        String text = "";
        int start = front;
        while(start != rear){
            text += "\n" + queue[start].toString();
            start = (start + 1) % queue.length;
        }
        return text;
    }

    private void myQueueResize(){
        T[] tmp = (T[])(new Object[queue.length + DEFAULT_CAPACITY]);
        for(int i = 0; i < queue.length; i++){
            tmp[i] = queue[i];
        }
        queue = tmp;
    }

}
