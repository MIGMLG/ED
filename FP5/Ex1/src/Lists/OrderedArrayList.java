package Lists;

public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T> {

    @Override
    public void add(T element) {
        if (element instanceof Comparable) {
            if (isEmpty()) {
                list[0] = element;
            } else {
                boolean found = false;
                int current = 0;

                while (current < size && found == false) {
                    Comparable<T> tmp = (Comparable<T>) list[current];
                    if (tmp.compareTo(element) > 0) {
                        found = true;
                    } else {
                        current++;
                    }
                }

                if (found == true) {
                    for (int i = rear - 1; i >= current; i--) {
                        list[i + 1] = list[i];
                    }
                    list[current] = element;
                } else {
                    list[rear] = element;
                }
            }
            rear++;
            size++;
            modCount++;
        } else {
            System.out.println("Objecto não é instancia de Comparable.");
        }
    }

}
