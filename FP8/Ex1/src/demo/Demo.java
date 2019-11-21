package demo;

import search.SortingandSearching;

public class Demo {




    public static void main(String[] args) {
        Car c1 = new Car("Subaru", "WRX STI", 2006);
        Car c5 = new Car( "Ferrai", "LaFerrari", 2015);
        Car c4 = new Car("Porsche" , "918", 2016);
        Car c2 = new Car("McLaren", "730S", 2018);
        Car c3 = new Car("Tesla", "Roadster", 2020);


        Car[] collection = new Car[10];
        collection[0] = c1;
        collection[1] = c5;
        collection[2] = c4;
        collection[3] = c2;
        collection[4] = c3;

        System.out.println("Resultado: " + SortingandSearching.linearSearch(collection, 0 , 4, c3));
        System.out.println("Resultado: " + SortingandSearching.binarySearch(collection, 0 , 4 , c3));
    }

}
