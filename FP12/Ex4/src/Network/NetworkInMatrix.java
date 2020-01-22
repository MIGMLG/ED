package Network;

import Graph.*;

import java.util.Arrays;

public class NetworkInMatrix<T> extends GraphInMatrix<T> implements NetworkADT<T> {

    private double[][] weightMatrix;

    public NetworkInMatrix() {
        this.weightMatrix = new double[DEFAULT_CAPACITY][DEFAULT_CAPACITY];
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

        boolean[][] tmpAdjMatrix = new boolean[vertices.length + DEFAULT_CAPACITY][vertices.length + DEFAULT_CAPACITY];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                tmpAdjMatrix[i][j] = adjMatrix[i][j];
            }
        }

        adjMatrix = tmpAdjMatrix;

        double[][] tmpWeightMatrix = new double[vertices.length + DEFAULT_CAPACITY][vertices.length + DEFAULT_CAPACITY];
        for (int i = 0; i < weightMatrix.length; i++) {
            for (int j = 0; j < weightMatrix.length; j++) {
                tmpWeightMatrix[i][j] = weightMatrix[i][j];
            }
        }

        weightMatrix = tmpWeightMatrix;
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
                weightMatrix[j][i] = weightMatrix[j][i + 1];
            }

        }

        for (int i = index; i < numVertices - 1; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjMatrix[i][j] = adjMatrix[i + 1][j];
                weightMatrix[i][j] = weightMatrix[i + 1][j];
            }

        }

        for (int h = index; h < numVertices - 1; h++) {
            vertices[h] = vertices[h + 1];
        }

        numVertices--;

    }

    @Override
    public void addEdge(T vertex1, T vertex2, double weight) throws GraphExceptions {
        int indexVertex1 = getIndex(vertex1);
        int indexVertex2 = getIndex(vertex2);

        if (indexIsValid(indexVertex1) && indexIsValid(indexVertex2)) {
            addEdge(vertex1, vertex2);
            weightMatrix[indexVertex1][indexVertex2] = weight;
            weightMatrix[indexVertex2][indexVertex1] = weight;
        } else {
            throw new GraphExceptions(GraphExceptions.ELEMENT_NOT_FOUND);
        }
    }

    @Override
    public void removeEdge(T vertex1, T vertex2) {
        int indexVertex1 = getIndex(vertex1);
        int indexVertex2 = getIndex(vertex2);

        if (indexIsValid(indexVertex1) && indexIsValid(indexVertex2)) {
            adjMatrix[indexVertex1][indexVertex2] = false;
            adjMatrix[indexVertex2][indexVertex1] = false;
            weightMatrix[indexVertex1][indexVertex2] = 0;
            weightMatrix[indexVertex2][indexVertex1] = 0;
        }

    }

    @Override
    public double shortestPathWeight(T vertex1, T vertex2) {
        return 0;
    }

    @Override
    public String toString() {
        String text = "";

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                text += "|";
                text += weightMatrix[i][j];
                text += "|";
            }
            text += "\n";
        }

        return text;
    }
}
