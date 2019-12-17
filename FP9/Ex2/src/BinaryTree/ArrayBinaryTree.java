package BinaryTree;

import Lists.UnorderedArray;
import Queue.LinkedQueue;

import java.util.Iterator;

public class ArrayBinaryTree<T> implements BinaryTreeADT<T> {

    protected int size;
    protected T[] tree;
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
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        int position = search(targetElement);

        if (position != -1) {
            return tree[position];
        }

        throw new BinaryTreeExceptions(BinaryTreeExceptions.ELEMENT_NOT_FOUND);
    }

    @Override
    public Iterator<T> iteratorInOrder() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        inOrder(0, list);

        return list.iterator();
    }

    private void inOrder(int node, UnorderedArray<T> list) {

        if (node < tree.length) {
            if (tree[node] != null) {
                inOrder(node * 2 + 1, list);
                list.addToRear(tree[node]);
                inOrder((node + 1) * 2, list);
            }
        }

    }

    @Override
    public Iterator<T> iteratorPreOrder() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        preOrder(0, list);

        return list.iterator();
    }

    private void preOrder(int node, UnorderedArray<T> list) {

        if (node < tree.length) {
            if (tree[node] != null) {
                list.addToRear(tree[node]);
                preOrder(node * 2 + 1, list);
                preOrder((node + 1) * 2, list);
            }
        }

    }

    @Override
    public Iterator<T> iteratorPostOrder() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        postOrder(0, list);

        return list.iterator();
    }

    private void postOrder(int node, UnorderedArray<T> list) {

        if (node < tree.length) {
            if (tree[node] != null) {
                postOrder(node * 2 + 1, list);
                postOrder((node + 1) * 2, list);
                list.addToRear(tree[node]);
            }
        }

    }

    @Override
    public Iterator<T> iteratorLevelOrder() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        UnorderedArray<T> list = new UnorderedArray<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        queue.enqueue(0);

        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            if (tree[node] != null) {
                list.addToRear(tree[node]);
                if (tree[(node * 2 + 1)] != null) {
                    queue.enqueue((node * 2 + 1));
                }
                if (tree[((node + 1) * 2)] != null) {
                    queue.enqueue(((node + 1) * 2));
                }
            }
        }

        return list.iterator();
    }
}
