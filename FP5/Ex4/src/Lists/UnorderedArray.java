package Lists;

public class UnorderedArray<T> extends ArrayList<T> implements UnorderedListADT<T> {

    @Override
    public void addToFront(T element) {
        if(rear == list.length){
            expandCapacity();
        }

        int first = 0;
        for (int i = rear - 1; i >= first; i--) {

            list[i + 1] = list[i];

        }
        list[first] = element;
        rear++;
        size++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if(rear == list.length){
            expandCapacity();
        }

        list[rear] = element;
        rear++;
        size++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) throws ListExceptions {
        if(rear == list.length){
            expandCapacity();
        }

        boolean found = false;
        int current = 0;

        while (current < size && found == false) {
            if (list[current].equals(target)) {
                found = true;
            } else {
                current++;
            }
        }

        if (found == true) {
            for (int i = rear - 1; i > current; i--) {
                list[i + 1] = list[i];
            }
            list[current + 1] = element;
            rear++;
            size++;
            modCount++;
        } else {
            throw new ListExceptions(ListExceptions.ELEMENT_NOT_FOUND);
        }
    }

}
