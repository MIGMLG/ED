package Demo;


import BinaryTree.BinaryTreeExceptions;
import Graph.GraphExceptions;
import Lists.ListExceptions;
import Network.*;
import Stack.EmptyCollectionException;

import java.util.Iterator;

public class demo {

    public static void tests(int test) throws GraphExceptions, EmptyCollectionException, ListExceptions, BinaryTreeExceptions {
        NetworkADT<Integer> graph;
        Iterator<Integer> itr;

        switch (test) {
            // Add Test
            case 1:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3.0);
                graph.addEdge(2, 4, 4.0);
                graph.addEdge(2, 2, 5.0);
                graph.addEdge(1, 1, 2.0);
                graph.addEdge(4, 4, 1.0);
                graph.addEdge(1, 4, 10.0);
                System.out.print(graph.toString());
                break;
            //ShortestPath Not Found Test
            case 2:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 10.0);
                graph.addEdge(2, 4, 5.0);
                graph.addEdge(2, 2, 6.0);
                graph.addEdge(1, 1, 3.0);
                graph.addEdge(4, 4, 20.0);
                graph.addEdge(1, 4, 1.0);
                Iterator itrSP = graph.iteratorShortestPath(1, 3);
                while (itrSP.hasNext()) {
                    System.out.print("->");
                    System.out.print(itrSP.next());
                }
                break;
            //ShortestPath Found Test
            case 3:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 3, 15.0);
                graph.addEdge(1, 2, 15.0);
                graph.addEdge(1, 1, 7.0);
                graph.addEdge(2, 4, 5.0);
                graph.addEdge(2, 2, 6.0);
                graph.addEdge(3, 4, 15.0);
                graph.addEdge(4, 4, 14.0);
                graph.addEdge(4, 3, 20.0);
                graph.addEdge(4, 2, 20.0);
                Iterator itrSPFound = graph.iteratorShortestPath(1, 4);
                while (itrSPFound.hasNext()) {
                    System.out.print("->");
                    System.out.print(itrSPFound.next());
                }
                System.out.print("\nCusto: " + graph.shortestPathWeight(1, 4) + "\n");
                break;
            // Remove Test
            case 4:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 7.0);
                graph.addEdge(2, 4, 5.0);
                graph.addEdge(2, 2, 4.0);
                graph.addEdge(1, 1, 10.0);
                graph.addEdge(4, 3, 8.0);
                graph.addEdge(3, 1, 15.0);
                graph.addEdge(3, 3, 1.0);
                graph.addEdge(4, 4, 1.0);
                graph.addEdge(1, 4, 5.0);
                System.out.println(graph.toString());
                graph.removeVertex(3);
                System.out.println(graph.toString());
                break;
            // BFS Itr Test
            case 5:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 3, 15.0);
                graph.addEdge(1, 2, 15.0);
                graph.addEdge(1, 1, 7.0);
                graph.addEdge(2, 4, 5.0);
                graph.addEdge(2, 2, 6.0);
                graph.addEdge(3, 4, 15.0);
                graph.addEdge(4, 4, 14.0);
                graph.addEdge(4, 3, 20.0);
                graph.addEdge(4, 2, 20.0);
                System.out.println(graph.toString());
                itr = graph.iteratorBFS(1);
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            // Connected Test
            case 6:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2);
                graph.addEdge(2, 4);
                graph.addEdge(2, 2);
                graph.addEdge(1, 1);
                graph.addEdge(4, 4);
                graph.addEdge(4, 3);
                graph.addEdge(1, 4);
                System.out.println(graph.toString());
                System.out.println("\nExcepted: True. Result : " + graph.isConnected());
                break;
            //Remove Edge Test
            case 7:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 15.0);
                graph.addEdge(2, 4, 5.0);
                graph.addEdge(2, 2, 6.0);
                graph.addEdge(1, 1, 7.0);
                graph.addEdge(4, 4, 14.0);
                graph.addEdge(4, 3, 20.0);
                graph.addEdge(1, 4, 21.0);
                System.out.println(graph.toString());
                graph.removeEdge(1, 4);
                System.out.println(graph.toString());
                break;
            // DFS Itr Test
            case 8:
                graph = new NetworkInList<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 3, 15.0);
                graph.addEdge(1, 2, 15.0);
                graph.addEdge(1, 1, 7.0);
                graph.addEdge(2, 4, 5.0);
                graph.addEdge(2, 2, 6.0);
                graph.addEdge(3, 4, 15.0);
                graph.addEdge(4, 4, 14.0);
                graph.addEdge(4, 3, 20.0);
                graph.addEdge(4, 2, 20.0);
                System.out.println(graph.toString());
                itr = graph.iteratorDFS(1);
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) throws GraphExceptions, EmptyCollectionException, ListExceptions, BinaryTreeExceptions {
        System.out.println("----------------------------------");
        for (int i = 1; i <= 8; ++i) {
            System.out.println("Teste " + i + ": ");
            tests(i);
            System.out.println("----------------------------------");
        }
    }
}
