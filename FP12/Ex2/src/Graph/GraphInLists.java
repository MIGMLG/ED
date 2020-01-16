package Graph;

import Lists.UnorderedArray;
import Lists.UnorderedListADT;
import Stack.EmptyCollectionException;

import java.util.Iterator;

public class GraphInLists<T> implements GraphADT<T> {

    protected int numVertices;
    protected UnorderedListADT<GraphNode<T>> nodesList;

    public GraphInLists() {
        this.numVertices = 0;
        this.nodesList = new UnorderedArray<GraphNode<T>>();
    }

    @Override
    public void addVertex(T vertex) {
        GraphNode<T> node = new GraphNode(vertex);
        nodesList.addToRear(node);
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        GraphNode<T> nodeToRemove = this.getGraph(vertex);

        for (GraphNode<T> tGraphNode : nodeToRemove.edgeList) {
            if (!tGraphNode.equals(nodeToRemove)) {
                tGraphNode.edgeList.remove(nodeToRemove);
            }
        }

        nodesList.remove(nodeToRemove);
        numVertices--;
    }

    private GraphNode<T> getGraph(T targetVertex) throws GraphExceptions {
        boolean found = false;
        GraphNode<T> node = null;
        Iterator<GraphNode<T>> searchItr = nodesList.iterator();

        while (!found && searchItr.hasNext()) {
            GraphNode<T> tmp = searchItr.next();
            if (tmp.element.equals(targetVertex)) {
                node = tmp;
                found = true;
            }
        }

        if (found == false) {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }

        return node;
    }

    @Override
    public void addEdge(T vertex1, T vertex2) throws GraphExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        GraphNode<T> node1 = this.getGraph(vertex1);
        GraphNode<T> node2 = this.getGraph(vertex2);

        if (vertex1.equals(vertex2)) {
            node1.edgeList.addToRear(node2);
        } else {
            node1.edgeList.addToRear(node2);
            node2.edgeList.addToRear(node1);
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws GraphExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        GraphNode<T> node1 = this.getGraph(vertex1);
        GraphNode<T> node2 = this.getGraph(vertex2);

        if (vertex1.equals(vertex2)) {
            node1.edgeList.remove(node2);
        } else {
            node1.edgeList.remove(node2);
            node2.edgeList.remove(node1);
        }

    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        return null;
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException {
        return null;
    }

    @Override
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (nodesList.isEmpty());
    }

    @Override
    public boolean isConnected() throws GraphExceptions {
        return false;
    }

    @Override
    public int size() {
        return numVertices;
    }

    @Override
    public String toString() {
        String text = "";
        Iterator<GraphNode<T>> printItr = nodesList.iterator();
        while (printItr.hasNext()) {
            text += "\n" + printItr.next().toString();
        }
        return text;
    }
}
