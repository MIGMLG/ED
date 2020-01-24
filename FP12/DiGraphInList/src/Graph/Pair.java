package Graph;

public class Pair<T> {

    protected GraphNode<T> node;
    protected Pair<T> previous;

    public Pair(GraphNode<T> node, Pair<T> previous) {
        this.node = node;
        this.previous = previous;
    }

}
