package Demo;

import Lists.OrderedArrayList;
import Lists.OrderedListADT;

public class demo {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        OrderedListADT<Integer> tmp = new OrderedArrayList<>();
        tmp.add(1);
        tmp.add(2);
        System.out.println(tmp.toString());
    }

}
