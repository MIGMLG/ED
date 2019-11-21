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

}
