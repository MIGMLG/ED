package List;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class LinkedListForTest<T> implements LinkedListForTestInterface<T> {

    private class LinkedListIterator<T> implements Iterator<T> {

        private LinkNode<T> current = (LinkNode<T>) head;

        @Override
        public boolean hasNext() {
            if (current != null) {
                return true;
            }
            return false;

        }

        @Override
        public T next() {
            if (this.hasNext()) {
                T tmp = current.getData();
                current = current.getNext();
                return tmp;
            }
            throw new NullPointerException();
        }
    }

    private LinkNode<T> head, tail;
    private int size;

    public LinkNode<T> getHead() {
        return head;
    }

    @Override
    public void add(T data) {
        if (size == 0) {
            head = new LinkNode<>(data, null);
            tail = head;
        } else {
            LinkNode<T> olderTail = tail;
            tail = new LinkNode<>(data, null);
            olderTail.setNext(tail);
        }
        size++;
    }

    public Iterator<T> iterator() {
        Iterator<T> itr = new LinkedListIterator<>();
        return itr;
    }

    @Override
    public String toString() {
        return printListRecursive(head);
    }

    private String printListRecursive(LinkNode<T> current) {
        if (current.getNext() == null) {
            return "\n" + current.toString();
        }
        return "\n" + current.toString() + printListRecursive(current.getNext());
    }
}
