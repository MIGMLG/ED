package Demo;

import BinaryTree.BinaryTreeExceptions;
import BinaryTree.LinkedBinaryAVLTree;

import java.util.Iterator;

public class demo {

    public static void tests(int test) throws BinaryTreeExceptions {
        LinkedBinaryAVLTree<Integer> tree = new LinkedBinaryAVLTree<>();
        Iterator<Integer> itr;

        switch (test) {
            // Teste para o add
            case 1:
                tree.addElement(3);
                tree.addElement(2);
                tree.addElement(1);
                itr = tree.iteratorPreOrder();
                while(itr.hasNext()){
                    System.out.println(itr.next());
                }
                break;
            case 2:
                tree.addElement(1);
                tree.addElement(2);
                tree.addElement(3);
                itr = tree.iteratorPreOrder();
                while(itr.hasNext()){
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
                tree.removeAllOccurrences(5);
                Iterator<Integer> it = tree.iteratorLevelOrder();
                while(it.hasNext()){
                    System.out.println(it.next());
                }
                System.out.println("Excepted : 1. Result : " + tree.findMin());
                System.out.println("Excepted : 6. Result : " + tree.findMax());
            default:
                break;
        }

    }

    public static void main(String[] args) throws BinaryTreeExceptions {
        demo.tests(2);
    }

}
