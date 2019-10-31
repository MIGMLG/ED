package Demo;

import Lists.OrderedArrayList;
import Lists.OrderedListADT;

public class demo {

    public static void main(String[] args) {
        OrderedListADT<Integer> tmp = new OrderedArrayList<>();

        tmp.add(4);
        tmp.add(2);
        tmp.add(1);
        tmp.add(3);

        System.out.println(tmp.toString());
    }

}
