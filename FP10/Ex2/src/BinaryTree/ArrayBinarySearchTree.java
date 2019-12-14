package BinaryTree;

import Lists.UnorderedArray;

import java.util.Iterator;

public class ArrayBinarySearchTree<T> extends ArrayBinaryTree<T> implements BinarySearchTreeADT<T> {

    protected int height;
    protected int maxIndex;

    public ArrayBinarySearchTree() {
        this.height = 0;
        this.maxIndex = -1;
    }

    public ArrayBinarySearchTree(T element) {
        super(element);
        this.height = 1;
        this.maxIndex = 0;
    }

    @Override
    public void addElement(T element) {

        if (tree.length < maxIndex * 2 + 3) {
            expandCapacity();
        }
        Comparable<T> tempelement = (Comparable<T>) element;

        if (isEmpty()) {
            tree[0] = element;
            maxIndex = 0;
        } else {
            boolean added = false;
            int currentIndex = 0;

            while (!added) {
                if (tempelement.compareTo((tree[currentIndex])) < 0) {
                    /** go left */
                    if (tree[currentIndex * 2 + 1] == null) {
                        tree[currentIndex * 2 + 1] = element;
                        added = true;
                        if (currentIndex * 2 + 1 > maxIndex) {
                            maxIndex = currentIndex * 2 + 1;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 1;
                    }
                } else {
                    /** go right */
                    if (tree[currentIndex * 2 + 2] == null) {
                        tree[currentIndex * 2 + 2] = element;
                        added = true;
                        if (currentIndex * 2 + 2 > maxIndex) {
                            maxIndex = currentIndex * 2 + 2;
                        }
                    } else {
                        currentIndex = currentIndex * 2 + 2;
                    }
                }
            }

        }

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        size++;
    }

    private void expandCapacity() {
        T[] tmp = (T[]) (new Object[tree.length + CAPACITY]);
        for (int i = 0; i < tree.length; i++) {
            tmp[i] = tree[i];
        }
        tree = tmp;
    }

    @Override
    public T removeElement(T targetElement) throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        int position = findAgain(targetElement, 0);

        if (position == -1) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.ELEMENT_NOT_FOUND);
        }

        T tmp = tree[position];
        replacement(position);
        size--;

        int temp = maxIndex;
        maxIndex = -1;

        for (int i = 0; i <= temp; i++) {
            if (tree[i] != null) {
                maxIndex = i;
            }
        }

        height = (int) (Math.log(maxIndex + 1) / Math.log(2)) + 1;
        return tmp;

    }

    protected void replacement(int position) {
        if((position * 2 + 1) <= maxIndex && tree[(position * 2 + 1)] != null){
            UnorderedArray<T> list = new UnorderedArray<>();
            getOtherElementsAndClean(position, list);

            Iterator<T> tmpItr = list.iterator();
            tmpItr.next();

            tree[position] = tmpItr.next();

            while (tmpItr.hasNext()) {
                this.addElement(tmpItr.next());
            }
        } else if (((position + 1) * 2) <= maxIndex && tree[((position + 1) * 2)] != null){
            UnorderedArray<T> list = new UnorderedArray<>();
            getOtherElementsAndClean(position, list);

            Iterator<T> tmpItr = list.iterator();
            tmpItr.next();

            tree[position] = tmpItr.next();

            while (tmpItr.hasNext()) {
                this.addElement(tmpItr.next());
            }
        } else {
            tree[position] = null;
        }

    }

    private void getOtherElementsAndClean(int position, UnorderedArray<T> list) {

        if (position < tree.length) {
            if (tree[position] != null) {
                list.addToRear(tree[position]);
                tree[position] = null;
                getOtherElementsAndClean(position * 2 + 1, list);
                getOtherElementsAndClean((position + 1) * 2, list);
            }
        }

    }

    @Override
    public void removeAllOccurrences(T targetElement) throws BinaryTreeExceptions {
        removeElement(targetElement);

        try {
            while (true) {
                removeElement(targetElement);
            }

        } catch (Exception ex) {
        }
    }

    @Override
    public T removeMin() throws BinaryTreeExceptions {
        return removeElement(findMin());
    }

    @Override
    public T removeMax() throws BinaryTreeExceptions {
        return removeElement(findMax());
    }

    @Override
    public T findMin() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        int position = 0;

        while (tree[2 * position + 1] != null && (2 * position + 1) <= maxIndex) {
            position = 2 * position + 1;
        }
        return tree[position];
    }

    @Override
    public T findMax() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_LIST);
        }

        int position = 0;

        while (tree[2 * position + 2] != null && (2 * position + 2) <= maxIndex) {
            position = 2 * position + 2;
        }
        return tree[position];
    }
}
