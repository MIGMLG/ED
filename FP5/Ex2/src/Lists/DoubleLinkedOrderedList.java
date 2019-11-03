package Lists;

public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {

        if (element instanceof Comparable) {
            if (isEmpty()) {
                head = new DoubleNode<>(element);
                tail = head;
            } else {
                boolean found = false;
                DoubleNode<T> current = head;

                while (current != null && found == false) {
                    Comparable<T> tmp = (Comparable<T>) current.getElement();
                    if (tmp.compareTo(element) > 0) {
                        found = true;
                    } else {
                        current = current.getNext();
                    }
                }

                if (found == true) {
                    if (current == head) {
                        DoubleNode<T> olderHead = head;
                        head = new DoubleNode<>(element);
                        head.setNext(olderHead);
                        olderHead.setPrevious(head);
                    } else {
                        DoubleNode<T> previous = current.getPrevious();
                        DoubleNode<T> newNode = new DoubleNode<>(element);

                        previous.setNext(newNode);
                        current.setPrevious(newNode);

                        newNode.setPrevious(previous);
                        newNode.setNext(current);
                    }
                } else {
                    DoubleNode<T> olderTail = tail;
                    tail = new DoubleNode<>(element);
                    tail.setPrevious(olderTail);
                    olderTail.setNext(tail);
                }

            }
            size++;
            modCount++;
        } else {
            System.out.println("Objecto não é instancia de Comparable.");
        }

    }

}
