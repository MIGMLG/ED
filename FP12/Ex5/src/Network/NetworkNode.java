package Network;

import Graph.GraphNode;

import java.util.Iterator;

public class NetworkNode<T> extends GraphNode<T> {

    protected double weight;

    public NetworkNode(T element, double weight) {
        super(element);
        this.weight = weight;
    }

    @Override
    public String toString() {
        String text = "Element: " + element + "";
        Iterator<GraphNode<T>> printItr = edgeList.iterator();
        while (printItr.hasNext()) {
            NetworkNode<T> tmpNode = (NetworkNode<T>) printItr.next();
            text += "\nEdge: " + element + "->" + tmpNode.element + " Weight :" + tmpNode.weight;
        }
        return text;
    }

}
