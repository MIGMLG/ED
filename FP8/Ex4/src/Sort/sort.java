package Sort;

import List.LinkNode;
import List.LinkedListForTest;

public class sort {

    public static <T extends Comparable<? super T>> void selectionSort(LinkedListForTest<T> data) {

        LinkNode<T> current = data.getHead();
        LinkNode<T> min;
        LinkNode<T> tmp;
        T tmpData;

        while (current != null) {
            tmp = current.getNext();
            min = current;

            while (tmp != null) {
                if (tmp.getData().compareTo(min.getData()) < 0) {
                    min = tmp;
                }
                tmp = tmp.getNext();
            }

            if (min != current) {
                tmpData = current.getData();
                current.setData(min.getData());
                min.setData(tmpData);
            }

            current = current.getNext();
        }

    }

    public static <T extends Comparable<? super T>> void insertionSort(LinkedListForTest<T> data) {

        LinkNode<T> max = data.getHead().getNext();
        LinkNode<T> current;
        T tmpData;

        while (max != null) {
            current = data.getHead();

            while (current.getData() != max.getData()) {
                if (max.getData().compareTo(current.getData()) < 0){
                    tmpData = current.getData();
                    current.setData(max.getData());
                    max.setData(tmpData);
                }
                current = current.getNext();
            }

            max = max.getNext();
        }
    }
}
