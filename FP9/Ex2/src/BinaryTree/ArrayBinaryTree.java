package BinaryTree;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    private int size;
    private T[] tree;
    private final static int CAPACITY = 10;

    public ArrayBinaryTree() {
        tree = (T[]) new Object[CAPACITY];
        this.size = 0;
    }

    public ArrayBinaryTree(T element) {
        tree = (T[]) new Object[CAPACITY];
        tree[0] = element;
        this.size = 1;
    }

    @Override
    public T getRoot() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        return tree[0];
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
        return (search(targetElement) != 1);
    }

    private int search(T targetElement) {
        int result = -1;

        for (int i = 0; i < size(); i++) {
            if(tree[i].equals(targetElement)){
                result = i;
            }
        }

        return result;
    }

    @Override
    public T find(T targetElement) throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        int position = search(targetElement);

        if (position != -1){
            return tree[position];
        }

        throw new BinaryTreeExceptions(BinaryTreeExceptions.ELEMENT_NOT_FOUND);
    }

    @Override
    public Iterator<T> iteratorInOrder() throws BinaryTreeExceptions {
        return null;
    }

    @Override
    public Iterator<T> iteratorPreOrder() throws BinaryTreeExceptions {
        return null;
    }

    @Override
    public Iterator<T> iteratorPostOrder() throws BinaryTreeExceptions {
        return null;
    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws BinaryTreeExceptions {
        return null;
    }
}
