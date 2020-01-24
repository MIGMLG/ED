package Network;

import BinaryTree.BinaryTreeExceptions;
import Graph.*;
import Lists.ListExceptions;
import Lists.UnorderedArray;
import Lists.UnorderedListADT;
import Queue.LinkedQueue;
import Stack.EmptyCollectionException;
import Stack.LinkedStack;

import java.util.Iterator;

public class NetworkInList<T> implements NetworkADT<T> {

    protected int numVertices;
    protected UnorderedListADT<NetworkNode<T>> nodesList;

    public NetworkInList() {
        this.numVertices = 0;
        this.nodesList = new UnorderedArray<>();
    }

    @Override
    public void addVertex(T vertex) {
        NetworkNode<T> node = new NetworkNode<>(vertex);
        nodesList.addToRear(node);
        numVertices++;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions, ListExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        NetworkNode<T> nodeToRemove = this.getNode(vertex);
        Iterator<NetworkNode<T>> itr = nodesList.iterator();

        while (itr.hasNext()) {
            NetworkNode<T> tmpNode = itr.next();
            Iterator<Edge<T>> itrEdge = tmpNode.edgeList.iterator();
            UnorderedListADT<Edge<T>> found = new UnorderedArray<>();

            while (itrEdge.hasNext()) {
                Edge<T> tmpEdge = itrEdge.next();
                if (tmpEdge.nodeTo.equals(nodeToRemove)) {
                    found.addToRear(tmpEdge);
                }
            }

            Iterator<Edge<T>> itrFound = found.iterator();
            while (itrFound.hasNext()) {
                tmpNode.edgeList.remove(itrFound.next());
            }
        }

        nodesList.remove(nodeToRemove);
        numVertices--;
    }

    protected NetworkNode<T> getNode(T targetVertex) throws GraphExceptions {
        boolean found = false;
        NetworkNode<T> node = null;
        Iterator<NetworkNode<T>> searchItr = nodesList.iterator();

        while (!found && searchItr.hasNext()) {
            NetworkNode<T> tmp = searchItr.next();
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
        this.addEdge(vertex1, vertex2, 0);
    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws GraphExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        NetworkNode<T> node1 = this.getNode(vertex1);
        NetworkNode<T> node2 = this.getNode(vertex2);
        Edge<T> edgeNode = new Edge<>(node2, weight);

        node1.edgeList.addToRear(edgeNode);
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) throws GraphExceptions, ListExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }
        NetworkNode<T> node1 = this.getNode(vertex1);
        NetworkNode<T> node2 = this.getNode(vertex2);

        Iterator<Edge<T>> itrEdge = node1.edgeList.iterator();
        Edge<T> found = null;

        while (itrEdge.hasNext()) {
            Edge<T> tmpEdge = itrEdge.next();
            if (tmpEdge.nodeTo.equals(node2)) {
                found = tmpEdge;
                break;
            }
        }

        node1.edgeList.remove(found);
    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        LinkedQueue<NetworkNode<T>> traversalQueue = new LinkedQueue<>();
        UnorderedArray<T> resultList = new UnorderedArray<>();
        NetworkNode<T> tmpNode;
        NetworkNode<T> startNode;

        try {
            startNode = this.getNode(startVertex);
        } catch (GraphExceptions graphExceptions) {
            return resultList.iterator();
        }

        UnorderedListADT<NetworkNode<T>> visited = new UnorderedArray<>();

        traversalQueue.enqueue(startNode);
        visited.addToRear(startNode);

        while (!traversalQueue.isEmpty()) {
            tmpNode = traversalQueue.dequeue();
            resultList.addToRear(tmpNode.element);

            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            Iterator<Edge<T>> itrEdges = tmpNode.edgeList.iterator();
            while (itrEdges.hasNext()) {
                Edge<T> nextNode = itrEdges.next();
                if (!visited.contains(nextNode.nodeTo)) {
                    traversalQueue.enqueue(nextNode.nodeTo);
                    visited.addToRear(nextNode.nodeTo);
                }
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException {
        LinkedStack<NetworkNode<T>> traversalStack = new LinkedStack();
        UnorderedArray<T> resultList = new UnorderedArray();
        NetworkNode<T> tmpNode;
        NetworkNode<T> startNode;
        boolean found;

        try {
            startNode = this.getNode(startVertex);
        } catch (GraphExceptions graphExceptions) {
            return resultList.iterator();
        }

        UnorderedListADT<NetworkNode<T>> visited = new UnorderedArray<>();

        traversalStack.push(startNode);
        resultList.addToRear(startNode.element);
        visited.addToRear(startNode);

        while (!traversalStack.isEmpty()) {
            tmpNode = traversalStack.peek();
            found = false;

            /** Find a vertex adjacent to x that has not been visited
             and push it on the stack */

            Iterator<Edge<T>> itrEdges = tmpNode.edgeList.iterator();
            while (itrEdges.hasNext() && !found) {
                Edge<T> nextNode = itrEdges.next();
                if (!visited.contains(nextNode.nodeTo)) {
                    traversalStack.push(nextNode.nodeTo);
                    resultList.addToRear(nextNode.nodeTo.element);
                    visited.addToRear(nextNode.nodeTo);
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
    public Iterator iteratorShortestPath(T startVertex, T targetVertex) throws GraphExceptions, ListExceptions {
        return null;
    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) throws BinaryTreeExceptions, GraphExceptions {

        return 0;
    }

    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    @Override
    public boolean isConnected() throws GraphExceptions, ListExceptions {
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
        Iterator<NetworkNode<T>> printItr = nodesList.iterator();
        while (printItr.hasNext()) {
            text += printItr.next().toString();
        }
        text += "\n";
        return text;
    }
}
