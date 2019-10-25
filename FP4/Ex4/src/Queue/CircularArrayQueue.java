package Queue;

public class CircularArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_CAPACITY = 10;

    private T[] queue;
    private int front, rear;
    private int size = 0;

    public CircularArrayQueue() {
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
        front = rear = 0;
    }

    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            myQueueResize();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() {

        if (size() == 0) {
            return null;
        }

        T tmp = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return tmp;

    }

    @Override
    public T first() {
        if (size() == 0) {
            return null;
        }
        return queue[front];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String text = "";
        int start = front;

        while (start != rear) {
            text += "\n" + queue[start].toString();
            start = (start + 1) % queue.length;
        }

        return text;
    }

    private void myQueueResize() {
        T[] tmp = (T[]) (new Object[queue.length + DEFAULT_CAPACITY]);
        int tmpFront = front;

        for (int i = 0; i < queue.length; i++) {
            tmp[i] = queue[tmpFront];
            tmpFront = (tmpFront + 1) % queue.length;
        }
        front = 0;
        rear = size();

        queue = tmp;
    }

}
