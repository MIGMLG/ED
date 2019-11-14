package Demo;

import PrintList.DoubleLinkedUnorderedList;

public class demo {

    public static void main(String[] args) {
        DoubleLinkedUnorderedList<Integer> tmp = new DoubleLinkedUnorderedList<>();
        tmp.addToFront(1);
        tmp.addToRear(2);
        tmp.addToRear(3);
        System.out.println(tmp.toString());
        System.out.println(tmp.toStringReversed());
    }

}
