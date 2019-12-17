package BinaryTree;

import Lists.UnorderedArray;
import Queue.LinkedQueue;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int size;
    protected T[] tree;
    protected final static int CAPACITY = 10;

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
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
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
        return (search(targetElement) != -1);
    }

    private int search(T targetElement) {
        int result = -1;

        for (int i = 0; i < size(); i++) {
            if (tree[i].equals(targetElement)) {
                result = i;
            }
        }

        return result;
    }

    @Override
    public T find(T targetElement) throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        int position = findAgain(targetElement, 0);

        if (position != -1) {
            return tree[position];
        }

        throw new BinaryTreeExceptions(BinaryTreeExceptions.ELEMENT_NOT_FOUND);
    }

    protected int findAgain(T targetElement, int next) {

        if (tree[next] == null) {
            return -1;
        }

        if (tree[next].equals(targetElement)) {
            return next;
        }

        int temp = findAgain(targetElement, (next * 2 + 1));

        if (temp == -1) {
            temp = findAgain(targetElement, (next * 2 + 2));
        }

        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        inOrder(0, list);

        return list.iterator();
    }

    private void inOrder(int position, UnorderedArray<T> list) {

        if (position < tree.length) {
            if (tree[position] != null) {
                inOrder(position * 2 + 1, list);
                list.addToRear(tree[position]);
                inOrder((position + 1) * 2, list);
            }
        }

    }

    @Override
    public Iterator<T> iteratorPreOrder() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        preOrder(0, list);

        return list.iterator();
    }

    private void preOrder(int position, UnorderedArray<T> list) {

        if (position < tree.length) {
            if (tree[position] != null) {
                list.addToRear(tree[position]);
                preOrder(position * 2 + 1, list);
                preOrder((position + 1) * 2, list);
            }
        }

    }

    @Override
    public Iterator<T> iteratorPostOrder() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        postOrder(0, list);

        return list.iterator();
    }

    private void postOrder(int position, UnorderedArray<T> list) {

        if (position < tree.length) {
            if (tree[position] != null) {
                postOrder(position * 2 + 1, list);
                postOrder((position + 1) * 2, list);
                list.addToRear(tree[position]);
            }
        }

    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(0);

        while (!queue.isEmpty()) {
            int position = queue.dequeue();
            if (tree[position] != null) {
                list.addToRear(tree[position]);
                if ((position * 2 + 1) < tree.length && tree[(position * 2 + 1)] != null) {
                    queue.enqueue((position * 2 + 1));
                }
                if (((position + 1) * 2) < tree.length && tree[((position + 1) * 2)] != null) {
                    queue.enqueue(((position + 1) * 2));
                }
            }
        }

        return list.iterator();
    }
}
