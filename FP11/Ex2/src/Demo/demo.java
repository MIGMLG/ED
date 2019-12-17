package Demo;

import BinaryTree.ArrayMinHeap;
import BinaryTree.BinaryTreeExceptions;
import PriorityQueue.PriorityQueue;

import java.util.Iterator;

public class demo {
    public static void tests(int test) throws BinaryTreeExceptions {
        PriorityQueue<Integer> tree = new PriorityQueue<Integer>();
        Iterator itr;

        switch (test) {
            // Teste para o add
            case 1:
                tree.addElement(3,1);
                tree.addElement(2,1);
                tree.addElement(1,2);
                tree.addElement(6, 2);
                tree.addElement(5,3);
                tree.addElement(4, 3);
                itr = tree.iteratorLevelOrder();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            case 2:
                tree.addElement(3,1);
                tree.addElement(2,1);
                tree.addElement(1,2);
                tree.addElement(6, 2);
                tree.addElement(5,3);
                tree.addElement(4, 3);
                itr = tree.iteratorLevelOrder();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                System.out.println("Excpeted 3. Result : " + tree.removeNext());
                System.out.println("Excpeted 3. Result : " + tree.removeNext());
                itr = tree.iteratorLevelOrder();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) throws BinaryTreeExceptions {
        demo.tests(2);
    }
}
