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

    protected void replacement(int targetIndex) {
        int currentIndex, parentIndex, temp, oldIndex, newIndex;
        UnorderedArray<Integer> oldlist = new UnorderedArray();
        UnorderedArray<Integer> newlist = new UnorderedArray();
        UnorderedArray<Integer> templist = new UnorderedArray();
        Iterator<Integer> oldIt, newIt;

        // if target node has no children
        if ((targetIndex * 2 + 1 >= tree.length) || (targetIndex * 2 + 2 >= tree.length)) {
            tree[targetIndex] = null;
        }

        // if target node has no children
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] == null)) {
            tree[targetIndex] = null;
        }
        // if target node only has a left child
        else if ((tree[targetIndex * 2 + 1] != null) && (tree[targetIndex * 2 + 2] == null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex * 2 + 1;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }

            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // if target node only has a right child
        else if ((tree[targetIndex * 2 + 1] == null) && (tree[targetIndex * 2 + 2] != null)) {

            // fill newlist with indices of nodes that will replace
            // the corresponding indices in oldlist

            // fill newlist
            currentIndex = targetIndex * 2 + 2;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                newlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }

            // fill oldlist
            currentIndex = targetIndex;
            templist.addToRear(new Integer(currentIndex));
            while (!templist.isEmpty()) {
                currentIndex = ((Integer) templist.removeFirst()).intValue();
                oldlist.addToRear(new Integer(currentIndex));
                if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                    templist.addToRear(new Integer(currentIndex * 2 + 1));
                    templist.addToRear(new Integer(currentIndex * 2 + 2));
                }
            }

            // do replacement
            oldIt = oldlist.iterator();
            newIt = newlist.iterator();
            while (newIt.hasNext()) {
                oldIndex = oldIt.next();
                newIndex = newIt.next();
                tree[oldIndex] = tree[newIndex];
                tree[newIndex] = null;
            }
        }

        // target node has two children
        else {
            currentIndex = targetIndex * 2 + 2;

            while (tree[currentIndex * 2 + 1] != null) {
                currentIndex = currentIndex * 2 + 1;
            }

            tree[targetIndex] = tree[currentIndex];

            // the index of the root of the subtree to be replaced
            int currentRoot = currentIndex;

            // if currentIndex has a right child
            if (tree[currentRoot * 2 + 2] != null) {

                // fill newlist with indices of nodes that will replace
                // the corresponding indices in oldlist

                // fill newlist
                currentIndex = currentRoot * 2 + 2;
                templist.addToRear(new Integer(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer) templist.removeFirst()).intValue();
                    newlist.addToRear(new Integer(currentIndex));
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        templist.addToRear(new Integer(currentIndex * 2 + 1));
                        templist.addToRear(new Integer(currentIndex * 2 + 2));
                    }
                }

                // fill oldlist
                currentIndex = currentRoot;
                templist.addToRear(new Integer(currentIndex));
                while (!templist.isEmpty()) {
                    currentIndex = ((Integer) templist.removeFirst()).intValue();
                    oldlist.addToRear(new Integer(currentIndex));
                    if ((currentIndex * 2 + 2) <= (Math.pow(2, height) - 2)) {
                        templist.addToRear(new Integer(currentIndex * 2 + 1));
                        templist.addToRear(new Integer(currentIndex * 2 + 2));
                    }
                }

                // do replacement
                oldIt = oldlist.iterator();
                newIt = newlist.iterator();
                while (newIt.hasNext()) {
                    oldIndex = oldIt.next();
                    newIndex = newIt.next();
                    tree[oldIndex] = tree[newIndex];
                    tree[newIndex] = null;
                }
            } else {
                tree[currentRoot] = null;
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

        while (tree[2 * position + 1] != null) {
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

        while (tree[2 * position + 2] != null) {
            position = 2 * position + 1;
        }
        return tree[position];
    }
}
