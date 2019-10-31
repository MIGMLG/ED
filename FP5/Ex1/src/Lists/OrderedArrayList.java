package Lists;

import java.util.Comparator;

public class OrderedArrayList<T> extends ArrayList<T> implements OrderedListADT<T>{

    @Override
    public void add(T element) {
        if(isEmpty()){
            list[0] = element;
            rear++;
            size++;
        }

    }

}
