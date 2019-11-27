package demo;

import search.SortingandSearching;

import java.sql.SQLOutput;

public class Demo {


    public static void main(String[] args) {

        Car c1 = new Car("Subaru", "WRX STI", 2006);
        Car c5 = new Car("Ferrai", "LaFerrari", 2015);
        Car c4 = new Car("Porsche", "918", 2016);
        Car c2 = new Car("McLaren", "730S", 2018);
        Car c3 = new Car("Tesla", "Roadster", 2020);

        int test = 5;

        Car[] collection = new Car[5];
        collection[0] = c1;
        collection[1] = c2;
        collection[2] = c3;
        collection[3] = c4;
        collection[4] = c5;

        System.out.println("Before: ");
        for (int i = 0; i < collection.length; ++i) {
            System.out.println("\n" + i + " " + collection[i].toString());
        }

        switch (test) {
            case 1:
                SortingandSearching.selectionSort(collection);
                break;
            case 2:
                SortingandSearching.selectionSortMax(collection, 4);
                break;
            case 3:
                SortingandSearching.insertionSort(collection);
                break;
            case 4:
                SortingandSearching.bubbleSort(collection);
                break;
            case 5:
                SortingandSearching.quickSort(collection,0,4);
                break;
            case 6:
                SortingandSearching.bubbleSort(collection);
                break;
            default:
                break;
        }

        System.out.println("\nAfter: ");
        for (int i = 0; i < collection.length; ++i) {
            System.out.println("\n" + i + " " + collection[i].toString());
        }


    }

}
