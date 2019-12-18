package BinaryTree;

import java.util.Iterator;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {


    public LinkedBinarySearchTree() {
    }

    public LinkedBinarySearchTree(BinaryTreeNode<T> root) {
        super(root);
    }

    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;

        if (isEmpty()) {
            root = temp;
        } else {
            BinaryTreeNode<T> current = root;
            boolean added = false;
            while (!added) {
                if (comparableElement.compareTo(current.getElement()) < 0) {
                    if (current.getLeft() == null) {
                        current.setLeft(temp);
                        added = true;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(temp);
                        added = true;
                    } else {
                        current = current.getRight();
                    }

                }
            }
        }
        size++;
    }

    @Override
    public T removeElement(T targetElement) throws BinaryTreeExceptions {
        T result = null;

        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.getElement())) {
                result = root.getElement();
                root = replacement(root);
                size--;
            } else {

                BinaryTreeNode<T> current, parent = root;
                boolean found = false;
                if (((Comparable) targetElement).compareTo(root.getElement()) < 0) {
                    current = root.getLeft();
                } else {
                    current = root.getRight();
                }

                while (current != null && !found) {
                    if (targetElement.equals(current.getElement())) {

                        found = true;
                        size--;
                        result = current.getElement();

                        if (current == parent.getLeft()) {
                            parent.setLeft(replacement(current));
                        } else {
                            parent.setRight(replacement(current));
                        }


                    } else {
                        parent = current;

                        if (((Comparable) targetElement).compareTo(current.getElement()) < 0) {
                            current = current.getLeft();
                        } else {
                            current = current.getRight();
                        }
                    }
                }
                if (!found) {
                    throw new BinaryTreeExceptions(BinaryTreeExceptions.ELEMENT_NOT_FOUND);
                }
            }
        } else {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        return result;
    }

    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
        BinaryTreeNode<T> result = null;

        if ((node.getLeft() == null) && (node.getRight() == null)) { // Quando o node é uma folha
            result = null;
        } else if ((node.getLeft() != null) && (node.getRight() == null)) { // Quando o node só tem um filho á esquerda, o node é subtituido pelo seu filho
            result = node.getLeft();
        } else if ((node.getLeft() == null) && (node.getRight() != null)) { // Quando o node só tem um filho á direita, o node é subtituido pelo seu filho
            result = node.getRight();
        } else { //
            BinaryTreeNode<T> current = node.getRight();
            BinaryTreeNode<T> parent = node;
            while (current.getLeft() != null) { // Chegar ao final do filho direito do lado esquerdo
                parent = current;
                current = current.getLeft();
            }
            if (node.getRight() == current) {// se o node sem filho á esquerda for o igual ao filho direito do node a remover o filho esquerdo passa a ser filho esquerdo do filho direito
                current.setLeft(node.getLeft());
            } else {// se o node filho da direita tiver nodes á esquerda, esse node substituirá o node removido e o node pai dele passará a ser seu filho á direita
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
                current.setLeft(node.getLeft());
            }
            result = current;
        }
        return result;
    }

    @Override
    public void removeAllOccurrences(T targetElement) throws BinaryTreeExceptions {

        removeElement(targetElement);

        try{
            while(true){
                removeElement(targetElement);
            }

        } catch (Exception ex){}

    }

    @Override
    public T removeMin() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        return removeElement(findMin());
    }

    @Override
    public T removeMax() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        return removeElement(findMax());
    }

    @Override
    public T findMin() throws BinaryTreeExceptions {

        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        BinaryTreeNode<T> found = root;

        while (found.getLeft() != null) {
            found = found.getLeft();
        }

        return found.getElement();
    }

    @Override
    public T findMax() throws BinaryTreeExceptions {
        if (isEmpty()) {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        BinaryTreeNode<T> found = root;

        while (found.getRight() != null) {
            found = found.getRight();
        }

        return found.getElement();
    }
}
