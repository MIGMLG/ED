package Demo;

import PrintList.LinkedListForTest;

public class demo {

    public static void main(String[] args) {
        LinkedListForTest<Integer> list = new LinkedListForTest<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
    }
}
