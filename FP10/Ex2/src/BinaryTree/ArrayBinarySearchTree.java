package BinaryTree;

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


        return null;
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
