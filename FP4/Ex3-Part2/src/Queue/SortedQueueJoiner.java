package Queue;

public class SortedQueueJoiner<T extends Comparable> {

    private LinkedSortedQueue<T> result = new LinkedSortedQueue<>();
    private LinkedSortedQueue<T> first;
    private LinkedSortedQueue<T> second;

    public SortedQueueJoiner(LinkedSortedQueue<T> first, LinkedSortedQueue<T> second) {
        this.first = first;
        this.second = second;
    }

    public LinkedSortedQueue<T> returnFinalQueue() {
        while (!first.isEmpty()){
            result.enqueue(first.dequeue());
        }
        while (!second.isEmpty()){
            result.enqueue(second.dequeue());
        }
        return result;
    }

}
