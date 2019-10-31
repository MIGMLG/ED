package Lists;

import java.util.Iterator;

public class ArrayList<T> implements ListADT<T> {

    private class ArrayListIterator<T> implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            if (current < size) {
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            if(this.hasNext()){
                T tmp = (T) list [current];
                current ++;
                return tmp;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    protected T[] list;
    private final int DEFAULT_CAPACITY = 10;
    protected int size;
    protected int rear;

    public ArrayList() {
        list = (T[]) (new Object[DEFAULT_CAPACITY]);
        size = 0;
        rear = 0;
    }

    public ArrayList(int capacity) {
        list = (T[]) (new Object[capacity]);
        size = 0;
        rear = 0;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T tmp = list[0];
        list[0] = null;

        size--;
        rear--;

        for (int i = 0; i < size(); i++) {
            list[i] = list[i + 1];
        }

        return tmp;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T tmp = list[rear - 1];
        list[rear - 1] = null;

        size--;
        rear--;

        return tmp;
    }

    @Override
    public T remove(T element) {
        int position = search(element);

        if (position != -1) {
            size--;
            rear--;

            if (position == 0) {
                return removeFirst();
            } else if (position == rear - 1) {
                return removeLast();
            }

            T tmp = list[position];

            for (int i = position; i < size(); i++) {
                list[i] = list[i + 1];
            }
            return tmp;
        }
        return null;
    }

    @Override
    public T first() {
        if (isEmpty()) {
            return null;
        }
        return list[0];
    }

    @Override
    public T last() {
        if (isEmpty()) {
            return null;
        }
        return list[rear - 1];
    }

    @Override
    public boolean contains(T target) {
        return (search(target) > -1);
    }

    private int search(T target) {
        int position = -1;

        if (isEmpty()) {
            return position;
        }

        for (int i = 0; i < size(); i++) {
            if (target.equals(list[i])) {
                return i;
            }
        }

        return position;
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
    public Iterator<T> iterator() {
        ArrayListIterator<T> itr = new ArrayListIterator<T>();
        return itr;
    }

    @Override
    public String toString() {
        String text = "";
        Iterator<T> itr = iterator();

        while (itr.hasNext()) {
            text += "\n" + itr.next().toString();
        }

        return text;
    }

}
