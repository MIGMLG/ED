package search;

import list.LinkNode;
import list.LinkedList;

public class SortingandSearching {


    public static <T extends Comparable<? super T>> boolean linearSearch(LinkedList<T> data, T target) {

        LinkNode<T> current = data.getHead();

        while(current!=null){
            if( current.getData().compareTo(target) == 0){
                return true;
            }
            current= current.getNext();
        }

        return false;
    }

}
