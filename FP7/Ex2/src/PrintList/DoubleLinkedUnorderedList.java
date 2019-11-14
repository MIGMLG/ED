package PrintList;

public class DoubleLinkedUnorderedList<T> extends DoubleLinkedList<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) {
        if(isEmpty()){
            head = new DoubleNode<>(element);
            tail = head;
        } else {
            DoubleNode<T> olderHead = head;
            head = new DoubleNode<>(element);
            head.setNext(olderHead);
            olderHead.setPrevious(head);
        }

        size++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if(isEmpty()){
            addToFront(element);
        } else {
            DoubleNode<T> olderTail = tail;
            tail = new DoubleNode<>(element);

            tail.setPrevious(olderTail);
            olderTail.setNext(tail);

            size++;
            modCount++;
        }
    }

    @Override
    public void addAfter(T element, T target) throws ListExceptions {
        if(!isEmpty()) {
            boolean found = false;
            DoubleNode<T> current = head;

            while (current != null && found == false) {
                if (current.getElement().equals(target)) {
                    found = true;
                } else {
                    current = current.getNext();
                }
            }

            if (found == true) {
                if (current == tail) {
                    addToRear(element);
                } else {
                    DoubleNode<T> next = current.getNext();
                    DoubleNode<T> newNode = new DoubleNode<>(element);

                    newNode.setNext(next);
                    newNode.setPrevious(current);

                    current.setNext(newNode);
                    next.setPrevious(newNode);
                }
                size++;
                modCount++;
            } else {
                throw new ListExceptions(ListExceptions.ELEMENT_NOT_FOUND);
            }
        } else {
            throw new ListExceptions(ListExceptions.EMPTY_LIST);
        }
    }
}
