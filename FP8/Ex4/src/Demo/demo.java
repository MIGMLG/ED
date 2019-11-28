package Demo;

import List.LinkedListForTest;
import Sort.sort;

import java.util.Iterator;

public class demo {

    public static void main(String[] args) {

        LinkedListForTest<Car> list = new LinkedListForTest<>();

        /*Car c1 = new Car("Subaru", "WRX STI", 2006);
        Car c2 = new Car("McLaren", "730S", 2018);
        Car c3 = new Car("Tesla", "Roadster", 2020);
        Car c5 = new Car("Ferrai", "LaFerrari", 2015);
        Car c4 = new Car("Porsche", "918", 2016);*/

        Car c1 = new Car("BMW", "M3 E46", 2005);
        Car c2 = new Car("Subaru", "WRX STI", 2006);
        Car c3 = new Car("McLaren", "730S", 2007);
        Car c4 = new Car("Chevrolet", "Camaro SS", 2008);
        Car c5 = new Car("Tesla", "model S", 2009);

        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);

        Iterator<Car> itr = list.iterator();

        /*while(itr.hasNext()){
            System.out.println("\n" + itr.next().toString());
        }*/

        System.out.println("Before : " + list.toString());

        //sort.selectionSort(list);

        //sort.insertionSort(list);

        System.out.println("After : " + list.toString());
    }

}
