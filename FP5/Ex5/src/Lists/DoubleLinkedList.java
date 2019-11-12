package Lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DoubleLinkedList<T> implements ListADT<T> {

    private class DoubleLinkedListIterator<T> implements Iterator<T> {

        private DoubleNode<T> current = (DoubleNode<T>) head;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (expectedModCount == modCount) {
                if (current != null) {
                    return true;
                }
                return false;
            }
            throw new ConcurrentModificationException();
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                T tmp = current.getElement();
                current = current.getNext();
                return tmp;
            }
            throw new NullPointerException();
        }
    }


    protected DoubleNode<T> head, tail;
    protected int size;
    protected int modCount;

    public DoubleLinkedList() {
        this.head = this.tail = null;
        this.size = 0;
        this.modCount = 0;
    }

    @Override
    public T removeFirst() throws ListExceptions {
        if (isEmpty()) {
            throw new ListExceptions(ListExceptions.EMPTY_LIST);
        }

        DoubleNode<T> tmp = head;

        if (size() == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.getNext();
            this.head.setPrevious(null);
        }

        size--;
        modCount++;
        return tmp.getElement();
    }

    @Override
    public T removeLast() throws ListExceptions {
        if (isEmpty()) {
            throw new ListExceptions(ListExceptions.EMPTY_LIST);
        }

        DoubleNode<T> tmp = tail;

        if (size() == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
        }

        size--;
        modCount++;
        return tmp.getElement();
    }

    @Override
    public T remove(T element) throws ListExceptions {
        if (isEmpty()) {
            throw new ListExceptions(ListExceptions.EMPTY_LIST);
        }

        DoubleNode<T> current = search(element);

        if (current != null) {
            if (current == head || size() == 1) {
                removeFirst();
            } else if (current == tail) {
                removeLast();
            } else {
                DoubleNode<T> previous = current.getPrevious();
                DoubleNode<T> next = current.getNext();
                previous.setNext(current.getNext());
                next.setPrevious(current.getPrevious());
            }
            size--;
            modCount++;
            return current.getElement();
        }

        throw new ListExceptions(ListExceptions.ELEMENT_NOT_FOUND);
    }

    @Override
    public T first() throws ListExceptions {
        if (isEmpty()) {
            throw new ListExceptions(ListExceptions.EMPTY_LIST);
        }
        return head.getElement();
    }

    @Override
    public T last() throws ListExceptions {
        if (isEmpty()) {
            throw new ListExceptions(ListExceptions.EMPTY_LIST);
        }
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        return (search(target) != null);
    }

    /**
     * @param target
     * @return
     */
    private DoubleNode<T> search(T target) {
        if (isEmpty()) {
            return null;
        }

        DoubleNode<T> current = head;

        while (current != null) {
            if (target.equals(current.getElement())) {
                return current;
            }
            current = current.getNext();
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> itr = new DoubleLinkedListIterator<>();
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
