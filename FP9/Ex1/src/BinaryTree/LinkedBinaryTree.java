package BinaryTree;

import Lists.UnorderedArray;
import Lists.UnorderedListADT;
import Queue.LinkedQueue;

import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {

    protected BinaryTreeNode<T> root;
    protected int size;

    public LinkedBinaryTree() {
        this.root = null;
        this.size = 0;
    }

    public LinkedBinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
        this.size = 1;
    }

    @Override
    public T getRoot() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        return root.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T targetElement) throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        return (findAgain(targetElement, root) != null);
    }

    @Override
    public T find(T targetElement) throws BinaryTreeExceptions {
        BinaryTreeNode<T> found = findAgain(targetElement, root);

        if (found == null) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.ELEMENT_NOT_FOUND);
        }

        return found.getElement();
    }

    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next) {

        if (next == null) {
            return null;
        }

        if (next.getElement().equals(targetElement)) {
            return next;
        }

        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());

        if (temp == null) {
            temp = findAgain(targetElement, next.getRight());
        }

        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();

        inOrder(root, list);

        return list.iterator();
    }

    private void inOrder(BinaryTreeNode<T> node, UnorderedArray<T> list) {

        if (node != null) {
            inOrder(node.getLeft(), list);
            list.addToRear(node.getElement());
            inOrder(node.getRight(), list);
        }

    }

    @Override
    public Iterator<T> iteratorPreOrder() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();

        preOrder(root, list);

        return list.iterator();
    }

    private void preOrder(BinaryTreeNode<T> node, UnorderedArray<T> list) {

        if (node != null) {
            list.addToRear(node.getElement());
            preOrder(node.getLeft(), list);
            preOrder(node.getRight(), list);
        }

    }

    @Override
    public Iterator<T> iteratorPostOrder() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();

        postOrder(root, list);

        return list.iterator();
    }

    private void postOrder(BinaryTreeNode<T> node, UnorderedArray<T> list) {

        if (node != null) {
            postOrder(node.getLeft(), list);
            postOrder(node.getRight(), list);
            list.addToRear(node.getElement());
        }

    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        LinkedQueue<BinaryTreeNode<T>> queue = new LinkedQueue<>();

        queue.enqueue(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode<T> tmpNode = queue.dequeue();
            if (tmpNode.getElement() != null) {
                list.addToRear(tmpNode.getElement());
                if (tmpNode.getLeft() != null) {
                    queue.enqueue(tmpNode.getLeft());
                }
                if (tmpNode.getRight() != null) {
                    queue.enqueue(tmpNode.getRight());
                }
            }
        }

        return list.iterator();
    }

}
