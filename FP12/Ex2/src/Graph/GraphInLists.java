package Graph;

import Lists.UnorderedArray;
import Lists.UnorderedListADT;
import Queue.LinkedQueue;
import Stack.EmptyCollectionException;
import Stack.LinkedStack;

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
        LinkedQueue<GraphNode<T>> traversalQueue = new LinkedQueue<GraphNode<T>>();
        UnorderedArray<T> resultList = new UnorderedArray<>();
        GraphNode<T> tmpNode;
        GraphNode<T> startNode;

        try {
            startNode = this.getGraph(startVertex);
        } catch (GraphExceptions graphExceptions) {
            return resultList.iterator();
        }

        UnorderedListADT<GraphNode<T>> visited = new UnorderedArray<>();

        traversalQueue.enqueue(startNode);
        visited.addToRear(startNode);

        while (!traversalQueue.isEmpty()) {
            tmpNode = traversalQueue.dequeue();
            resultList.addToRear(tmpNode.element);

            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            Iterator<GraphNode<T>> itrEdges = tmpNode.edgeList.iterator();
            while (itrEdges.hasNext()) {
                GraphNode<T> nextNode = itrEdges.next();
                if (!visited.contains(nextNode)) {
                    traversalQueue.enqueue(nextNode);
                    visited.addToRear(nextNode);
                }
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException {
        LinkedStack<GraphNode<T>> traversalStack = new LinkedStack();
        UnorderedArray<T> resultList = new UnorderedArray();
        GraphNode<T> tmpNode;
        GraphNode<T> startNode;
        boolean found;

        try {
            startNode = this.getGraph(startVertex);
        } catch (GraphExceptions graphExceptions) {
            return resultList.iterator();
        }

        UnorderedListADT<GraphNode<T>> visited = new UnorderedArray<>();

        traversalStack.push(startNode);
        resultList.addToRear(startNode.element);
        visited.addToRear(startNode);

        while (!traversalStack.isEmpty()) {
            tmpNode = traversalStack.peek();
            found = false;

            /** Find a vertex adjacent to x that has not been visited
             and push it on the stack */

            Iterator<GraphNode<T>> itrEdges = tmpNode.edgeList.iterator();
            while (itrEdges.hasNext() && !found) {
                GraphNode<T> nextNode = itrEdges.next();
                if (!visited.contains(nextNode)) {
                    traversalStack.push(nextNode);
                    resultList.addToRear(nextNode.element);
                    visited.addToRear(nextNode);
                    found = true;
                }
            }
            if (!found && !traversalStack.isEmpty()) {
                traversalStack.pop();
            }
        }

        return resultList.iterator();
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
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        Iterator itr = iteratorBFS(nodesList.first().element);
        int counter = 0;

        while (itr.hasNext()) {
            itr.next();
            counter++;
        }

        return (counter == numVertices);
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
