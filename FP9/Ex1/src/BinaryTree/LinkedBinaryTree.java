package BinaryTree;

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

        if(found == null){
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
    public Iterator<T> iteratorInOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        return null;
    }
}
