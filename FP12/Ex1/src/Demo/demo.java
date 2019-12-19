package Demo;

import Graph.Graph;

import java.util.Iterator;
import Graph.GraphExceptions;

public class demo {

    public static void tests(int test) throws GraphExceptions {
        Graph<Integer> graph = new Graph();
        Iterator<Integer> itr;

        switch (test) {
            // Teste para o add
            case 1:
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1,2);
                graph.addEdge(2,4);
                graph.addEdge(2,2);
                graph.addEdge(1,1);
                graph.addEdge(4,4);
                graph.addEdge(1,4);
                System.out.println(graph.toString());
                graph.removeVertex(3);
                System.out.println(graph.toString());
                itr = graph.iteratorBFS(1);
                while(itr.hasNext()){
                    System.out.println(itr.next());
                }
                System.out.println("\nExcepted: True. Result : " + graph.isConnected());
                break;

            default:
                break;
        }

    }

    public static void main(String[] args) throws GraphExceptions {
        tests(1);
    }
}
