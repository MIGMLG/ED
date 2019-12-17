package Demo;

import BinaryTree.ArrayMinHeap;
import BinaryTree.BinaryTreeExceptions;

import java.util.Iterator;

public class demo {
    public static void tests(int test) throws BinaryTreeExceptions {
        ArrayMinHeap<Integer> tree = new ArrayMinHeap();
        Iterator<Integer> itr;

        switch (test) {
            // Teste para o add
            case 1:
                tree.addElement(3);
                tree.addElement(2);
                tree.addElement(1);
                tree.addElement(6);
                tree.addElement(5);
                tree.addElement(4);
                itr = tree.iteratorLevelOrder();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            case 2:
                tree.addElement(6);
                tree.addElement(4);
                tree.addElement(5);
                tree.addElement(3);
                tree.addElement(2);
                tree.addElement(1);
                System.out.println("Excpeted 1. Result : " + tree.removeMin());
                itr = tree.iteratorLevelOrder();
                while (itr.hasNext()) {
                    System.out.println(itr.next());
                }
                break;
            case 3:
                tree.addElement(6);
                tree.addElement(4);
                tree.addElement(5);
                tree.addElement(3);
                tree.addElement(2);
                tree.addElement(1);
                tree.addElement(5);
                tree.addElement(4);
                tree.addElement(6);
                tree.addElement(5);
                tree.addElement(4);
                tree.addElement(6);
                System.out.println("Excpeted 1. Result : " + tree.removeMin());
                Iterator<Integer> it = tree.iteratorLevelOrder();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
                System.out.println("Excepted : 2. Result : " + tree.findMin());
            default:
                break;
        }

    }

    public static void main(String[] args) throws BinaryTreeExceptions {
        demo.tests(3);
    }
}
