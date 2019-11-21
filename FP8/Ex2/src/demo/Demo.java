package demo;

import list.LinkedList;
import search.SortingandSearching;

public class Demo {




    public static void main(String[] args) {
        Car c1 = new Car("Subaru", "WRX STI", 2006);
        Car c5 = new Car( "Ferrai", "LaFerrari", 2015);
        Car c4 = new Car("Porsche" , "918", 2016);
        Car c2 = new Car("McLaren", "730S", 2018);
        Car c3 = new Car("Tesla", "Roadster", 2020);

        LinkedList<Car> tmp = new LinkedList<>();
        System.out.println("Add c1: " + tmp.add(c1));
        System.out.println("Add c5: " + tmp.add(c5));
        System.out.println("Add c4: " + tmp.add(c4));
        System.out.println("Add c2: " + tmp.add(c2));
        System.out.println("Add c3: " + tmp.add(c3));


        System.out.println("\nResultado: " + SortingandSearching.linearSearch(tmp, c3));
        //System.out.println("Resultado: " + SortingandSearching.binarySearch(collection, 0 , 4 , c3));
    }

}
