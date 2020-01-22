package Network;

import sun.security.provider.certpath.Vertex;

public class Pair<T> {

    protected Pair<T> previous;
    protected T vertex;
    protected double cost;

    public Pair(Pair<T> previous, T vertex, double cost) {
        this.previous = previous;
        this.vertex = vertex;
        this.cost = cost;
    }
}
