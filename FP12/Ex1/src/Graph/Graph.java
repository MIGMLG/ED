package Graph;

import Lists.UnorderedArray;
import Queue.LinkedQueue;
import Stack.EmptyCollectionException;
import Stack.LinkedStack;

import java.util.Iterator;

public class Graph<T> implements GraphADT<T> {

    protected final int DEFAULT_CAPACITY = 4;
    protected int numVertices; // number of vertices in the graph
    protected boolean[][] adjMatrix; // adjacency matrix
    protected T[] vertices; // values of vertices

    /**
     * Creates an empty graph.
     */
    public Graph() {
        numVertices = 0;
        this.adjMatrix = new boolean[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
        this.vertices = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    @Override
    public void addVertex(T vertex) {
        if (numVertices == vertices.length) {
            expandCapacity();
        }

        vertices[numVertices] = vertex;
        for (int i = 0; i < adjMatrix.length; i++) {
            adjMatrix[numVertices][i] = false;
            adjMatrix[i][numVertices] = false;
        }
        numVertices++;
    }

    private void expandCapacity() {
        T[] tmp = (T[]) (new Object[vertices.length + DEFAULT_CAPACITY]);
        for (int i = 0; i < vertices.length; i++) {
            tmp[i] = vertices[i];
        }
        vertices = tmp;
    }

    @Override
    public void removeVertex(T vertex) throws GraphExceptions {

        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        int index = getIndex(vertex);

        if (index == -1) {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }

        for (int i = index; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[j][i] = adjMatrix[j][i + 1];
            }

        }

        for (int i = index; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
            }

        }

        for (int h = index; h < numVertices - 1; h++) {
            vertices[h] = vertices[h + 1];
        }

        numVertices--;

    }

    private int getIndex(T vertex) {
        int position = -1;
        int current = 0;
        boolean found = false;

        while (!found && current < numVertices) {
            if (vertex.equals(vertices[current])) {
                found = true;
                position = current;
            }
            current++;
        }

        return position;
    }

    @Override
    public void addEdge(T vertex1, T vertex2) {
        addEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private void addEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = true;
            adjMatrix[index2][index1] = true;
        }
    }

    public boolean indexIsValid(int index) {
        if (index >= 0 && index < numVertices) {
            return true;
        }
        return false;
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        removeEdge(getIndex(vertex1), getIndex(vertex2));
    }

    private void removeEdge(int index1, int index2) {
        if (indexIsValid(index1) && indexIsValid(index2)) {
            adjMatrix[index1][index2] = false;
            adjMatrix[index2][index1] = false;
        }
    }

    @Override
    public Iterator iteratorBFS(T startVertex) {
        return iteratorBFS(getIndex(startVertex));
    }

    private Iterator iteratorBFS(int startIndex) {
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedArray<T> resultList = new UnorderedArray<>();

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        visited[startIndex] = true;

        while (!traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            resultList.addToRear(vertices[x.intValue()]);
            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    visited[i] = true;
                }
            }
        }

        return resultList.iterator();
    }

    @Override
    public Iterator iteratorDFS(T startVertex) throws EmptyCollectionException {
        return iteratorDFS(getIndex(startVertex));
    }

    private Iterator iteratorDFS(int startIndex) throws EmptyCollectionException {
        Integer x;
        boolean found;
        LinkedStack<Integer> traversalStack = new LinkedStack();
        UnorderedArray<T> resultList = new UnorderedArray();
        boolean[] visited = new boolean[numVertices];

        if (!indexIsValid(startIndex)) {
            return resultList.iterator();
        }

        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalStack.push(new Integer(startIndex));
        resultList.addToRear(vertices[startIndex]);
        visited[startIndex] = true;

        while (!traversalStack.isEmpty()) {
            x = traversalStack.peek();
            found = false;
            /** Find a vertex adjacent to x that has not been visited
             and push it on the stack */
            for (int i = 0; (i < numVertices) && !found; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalStack.push(new Integer(i));
                    resultList.addToRear(vertices[i]);
                    visited[i] = true;
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
        Integer x;
        LinkedQueue<Integer> traversalQueue = new LinkedQueue<Integer>();
        UnorderedArray<T> resultList = new UnorderedArray<>();
        int startIndex = getIndex(startVertex);
        int targetIndex = getIndex(targetVertex);
        int[][] info = new int[vertices.length][3];
        boolean found = false;
        int counter = 0;

        if (!indexIsValid(startIndex) || !indexIsValid(targetIndex)) {
            return resultList.iterator();
        }

        boolean[] visited = new boolean[numVertices];
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        traversalQueue.enqueue(new Integer(startIndex));
        //Index of Vertex
        info[counter][0] = startIndex;
        //PathLength
        info[counter][1] = 0;
        //LastVertex
        info[counter][2] = -1;
        visited[startIndex] = true;

        while (!found && !traversalQueue.isEmpty()) {
            x = traversalQueue.dequeue();
            /** Find all vertices adjacent to x that have
             not been visited and queue them up */
            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[x.intValue()][i] && !visited[i]) {
                    traversalQueue.enqueue(new Integer(i));
                    counter++;
                    info[counter][0] = i;
                    info[counter][1] = info[x.intValue()][1] + 1;
                    info[counter][2] = info[x.intValue()][0];
                    visited[i] = true;
                    if (i == targetIndex) {
                        found = true;
                    }
                }
            }
        }

        if (found) {
            resultList.addToFront(vertices[info[counter][0]]);
            int lastIndex = info[counter][2];
            while (lastIndex != -1){
                resultList.addToFront(vertices[info[lastIndex][0]]);
                lastIndex = info[lastIndex][2];
            }

        }
        return resultList.iterator();
    }

    @Override
    public boolean isEmpty() {
        return (numVertices == 0);
    }

    @Override
    public boolean isConnected() throws GraphExceptions {
        if (isEmpty()) {
            throw new GraphExceptions(GraphExceptions.EMPTY_GRAPH);
        }

        Iterator itr = iteratorBFS(0);
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
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                text += "|";
                if (adjMatrix[i][j] == true) {
                    text += "T";
                } else {
                    text += "F";
                }
                text += "|";
            }
            text += "\n";
        }
        return text;
    }
}
