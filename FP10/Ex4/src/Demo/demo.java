package Demo;

import BinaryTree.BinaryTreeExceptions;
import BinaryTree.LinkedBinaryAVLTree;

import java.util.Iterator;

public class demo {

    public static void tests(int test) throws BinaryTreeExceptions {
        LinkedBinaryAVLTree<Integer> tree = new LinkedBinaryAVLTree<>();
        Iterator<Integer> itr;

        switch (test) {
            // Teste para rotation direita esquerda
            case 1:
                tree.addElement(10);
                tree.addElement(5);
                tree.addElement(15);
                tree.addElement(3);
                tree.addElement(13);
                tree.addElement(17);
                tree.addElement(11);
                tree.removeElement(3);
                itr = tree.iteratorPreOrder();
                while(itr.hasNext()){
                    System.out.println(itr.next());
                }
                break;
            // Teste para rotation esquerda direita
            case 2:
                tree.addElement(13);
                tree.addElement(5);
                tree.addElement(15);
                tree.addElement(3);
                tree.addElement(7);
                tree.addElement(10);
                itr = tree.iteratorPreOrder();
                while(itr.hasNext()){
                    System.out.println(itr.next());
                }
                break;
            default:
                break;
        }

    }

    public static void main(String[] args) throws BinaryTreeExceptions {
        demo.tests(1);
    }

}
