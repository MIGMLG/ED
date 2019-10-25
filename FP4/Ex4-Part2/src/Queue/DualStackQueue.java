package Queue;

import Stack.LinkedStack;

public class DualStackQueue<T> implements QueueADT<T> {

    private LinkedStack<T> front;
    private LinkedStack<T> rear;
    private int size;

    public DualStackQueue() {
        front = new LinkedStack<>();
        rear = new LinkedStack<>();
        this.size = 0;
    }

    @Override
    public void enqueue(T element) {
        rear.push(element);

        if (size() == 0) {
            front.push(element);
        } else {
            T[] tmp = (T[]) (new Object[front.size()]);

            for (int i = 0; i < tmp.length; i++) {
                try {
                    tmp[i] = front.pop();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }

            front.push(element);

            for (int i = (tmp.length - 1); i >= 0; i--) {
                try {
                    front.push(tmp[i]);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        size++;
    }

    @Override
    public T dequeue() {
        if (size() == 0) {
            return null;
        }
        try {
            T[] tmp = (T[]) (new Object[rear.size()]);
            int sizeWithoutFirstElement = tmp.length - 1; //Takes out the element that just got poped

            for (int i = 0; i < sizeWithoutFirstElement; i++) {
                tmp[i] = rear.pop();
            }

            for (int i = sizeWithoutFirstElement; i >= 0; i--) {
                rear.push(tmp[i]);
            }

            size--;
            return front.pop();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }

    }

    @Override
    public T first() {
        if (size() == 0) {
            return null;
        }
        try {
            return front.peek();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
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
        return front.toString();
    }
}
