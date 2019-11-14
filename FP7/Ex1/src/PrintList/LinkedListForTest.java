package PrintList;

public class LinkedListForTest<T> implements LinkedListForTestInterface<T> {

    private LinkNode<T> head, tail;
    private int size;

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

    @Override
    public String toString(){
        return printListRecursive(head);
    }

    private String printListRecursive(LinkNode<T> current) {
        if (current.getNext() == null) {
            return "\n" + current.toString();
        }
        return "\n" + current.toString() + printListRecursive(current.getNext());
    }
}
