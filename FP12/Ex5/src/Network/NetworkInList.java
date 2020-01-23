package Network;

import BinaryTree.BinaryTreeExceptions;
import Graph.*;

import java.util.Iterator;

public class NetworkInList<T> extends GraphInLists<T> implements NetworkADT<T> {

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws GraphExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        GraphNode<T> node1 = this.getGraph(vertex1);
        GraphNode<T> node2 = this.getGraph(vertex2);

        NetworkNode<T> netNode1 = new NetworkNode<>(vertex1, weight);
        NetworkNode<T> netNode2 = new NetworkNode<>(vertex2, weight);

        if (vertex1.equals(vertex2)) {
            node1.getEdgeList().addToRear(netNode1);
        } else {
            node1.getEdgeList().addToRear(netNode2);
            node2.getEdgeList().addToRear(netNode1);
        }
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) throws BinaryTreeExceptions, GraphExceptions {
        return 0;
    }

    @Override
    public String toString() {
        String text = "";
        Iterator<GraphNode<T>> printItr = nodesList.iterator();
        while (printItr.hasNext()) {
            GraphNode<T> tmpGraphNode = printItr.next();
            text += "\nElement " + tmpGraphNode.getElement() + ":";
            Iterator<GraphNode<T>> printItrNet = tmpGraphNode.getEdgeList().iterator();
            while (printItrNet.hasNext()) {
                NetworkNode<T> tmpNode = (NetworkNode<T>) printItrNet.next();
                text += "\nEdge: " + tmpGraphNode.getElement() + "->" + tmpNode.getElement() + " Weight: " + tmpNode.weight;
            }
        }
        return text;
    }
}
