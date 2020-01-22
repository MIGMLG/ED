package Demo;

import BinaryTree.BinaryTreeExceptions;
import Graph.GraphInMatrix;

import java.util.Iterator;

import Graph.GraphExceptions;
import Network.NetworkADT;
import Network.NetworkInMatrix;
import Stack.EmptyCollectionException;

public class demo {

    public static void tests(int test) throws GraphExceptions, EmptyCollectionException, BinaryTreeExceptions {
        NetworkADT<Integer> graph;
        Iterator<Integer> itr;

        switch (test) {
            // Add Test
            case 1:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                System.out.println(graph.toString());
                break;
            //ShortestPath Not Found Test
            case 2:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                Iterator itrSP = graph.iteratorShortestPath(1, 3);
                while (itrSP.hasNext()) {
                    System.out.print("->");
                    System.out.print(itrSP.next());
                }
                System.out.println("");
                break;
            //ShortestPath Found Test
            case 3:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                Iterator itrSPFound = graph.iteratorShortestPath(1, 4);
                while (itrSPFound.hasNext()) {
                    System.out.print("->");
                    System.out.print(itrSPFound.next());
                }
                System.out.println("");
                break;
            // Remove Test
            case 4:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                System.out.println(graph.toString());
                graph.removeVertex(3);
                System.out.println(graph.toString());
                break;
            // BFS Itr Test
            case 5:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 3, 3);
                graph.addEdge(1, 4, 8);
                System.out.println(graph.toString());
                itr = graph.iteratorBFS(1);
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            // Connected Test
            case 6:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                graph.addEdge(4, 3, 6);
                System.out.println(graph.toString());
                System.out.println("\nExcepted: True. Result : " + graph.isConnected());
                break;
            case 7:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                graph.addEdge(4, 3, 6);
                System.out.println(graph.toString());
                graph.addVertex(5);
                System.out.println(graph.toString());
                graph.addEdge(1, 5, 9);
                System.out.println(graph.toString());
                break;
            case 8:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                System.out.println(graph.toString());
                graph.removeEdge(1, 1);
                System.out.println(graph.toString());
                break;
            case 9:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                graph.addEdge(4, 3, 6);
                System.out.println(graph.toString());
                System.out.println(graph.toString());
                itr = graph.iteratorDFS(1);
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            case 10:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 4);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                graph.addEdge(4, 3, 6);
                System.out.println(graph.toString());
                System.out.println(graph.shortestPathWeight(1,3));
                break;
            case 11:
                graph = new NetworkInMatrix<>();
                graph.addVertex(1);
                graph.addVertex(2);
                graph.addVertex(3);
                graph.addVertex(4);
                graph.addEdge(1, 2, 3);
                graph.addEdge(2, 4, 20);
                graph.addEdge(2, 2, 5);
                graph.addEdge(1, 1, 6);
                graph.addEdge(4, 4, 7);
                graph.addEdge(1, 4, 8);
                graph.addEdge(4, 3, 6);
                System.out.println(graph.toString());
                itr = graph.iteratorShortestPath(1,3);
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) throws GraphExceptions, EmptyCollectionException, BinaryTreeExceptions {
        System.out.println("----------------------------------");
        for (int i = 1; i <= 11; ++i) {
            tests(i);
            System.out.println("----------------------------------");
        }
    }
}
