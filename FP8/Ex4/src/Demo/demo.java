package Demo;

import List.LinkedListForTest;
import Sort.sort;

import java.util.Iterator;

public class demo {

    public static void main(String[] args) {

        LinkedListForTest<Car> list = new LinkedListForTest<>();
        int test = 2;

        Car c1 = new Car("Subaru", "WRX STI", 2006);
        Car c2 = new Car("McLaren", "730S", 2018);
        Car c3 = new Car("Tesla", "Roadster", 2020);
        Car c5 = new Car("Ferrai", "LaFerrari", 2015);
        Car c4 = new Car("Porsche", "918", 2016);

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);

        System.out.println("Before : " + list.toString());

        switch (test) {
            case 1:
                sort.selectionSort(list);
                break;
            case 2:
                sort.insertionSort(list);
                break;
            default:
                break;
        }

        System.out.println("After : " + list.toString());
    }

}
