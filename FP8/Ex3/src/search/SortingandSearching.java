package search;

public class SortingandSearching {


    public static <T extends Comparable<? super T>> boolean linearSearch(T[] data, int min, int max, T target) {

        for (int i = min; i <= max; ++i) {
            if (data[i].compareTo(target) == 0) {
                return true;
            }
        }

        return false;
    }

    public static <T extends Comparable<? super T>> boolean binarySearch(T[] data, int min, int max, T target) {
        boolean found = false;
        int midpoint = (min + max) / 2;

        if (data[midpoint].compareTo(target) == 0) {
            found = true;
        } else if (data[midpoint].compareTo(target) > 0) {
            if (midpoint - 1 >= min) {
                found = binarySearch(data, min, midpoint, target);
            }
        } else if (midpoint + 1 <= max) {
            found = binarySearch(data, midpoint + 1, max, target);
        }

        return found;
    }

    /**
     * Sorts the specified array of integers using the selection    * sort algorithm.    *    * @param data  the array to be sorted
     */
    public static <T extends Comparable<? super T>> void selectionSort(T[] data) {
        int min;
        T temp;

        for (int index = 0; index < data.length - 1; index++) {
            min = index;

            for (int scan = index + 1; scan < data.length; scan++) {
                if (data[scan].compareTo(data[min]) < 0) {
                    min = scan;/** Swap the values */
                }
            }

            temp = data[min];
            data[min] = data[index];
            data[index] = temp;
        }
    }

    public static <T extends Comparable<? super T>> void selectionSortMax(T[] data, int lastPosition){
        int max;
        T temp;

        for (int index = lastPosition; index > 0; index--) {
            max = index;

            for (int scan = index -1; scan >= 0; scan--) {
                if (data[scan].compareTo(data[max]) > 0) {
                    max = scan;
                }
            }

            temp = data[max];
            data[max] = data[index];
            data[index] = temp;
        }
    }

}
