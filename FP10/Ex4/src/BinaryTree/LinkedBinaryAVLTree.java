package BinaryTree;

import ArrayList.UnorderedArray;

import java.util.Iterator;

public class LinkedBinaryAVLTree<T> extends LinkedBinaryTree<T> implements BinaryAVLTreeADT<T> {


    public LinkedBinaryAVLTree() {
    }

    public LinkedBinaryAVLTree(BinaryAVLTreeNode<T> root) {
        super(root);
    }

    @Override
    public void addElement(T element) {
        BinaryAVLTreeNode<T> temp = new BinaryAVLTreeNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>) element;
        UnorderedArray<BinaryAVLTreeNode<T>> visitedNodes = new UnorderedArray();

        if (isEmpty()) {
            root = temp;
        } else {
            BinaryAVLTreeNode<T> current = root;
            boolean added = false;
            while (!added) {
                visitedNodes.addToRear(current);
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
        updateBalanceOfNodes(visitedNodes.iterator());
        root = checkAllNodesBalance(root);
    }

    private void updateBalanceOfNodes(Iterator itr) {
        while (itr.hasNext()) {
            BinaryAVLTreeNode<T> tmpNode = (BinaryAVLTreeNode<T>) itr.next();
            tmpNode.updateBalance();
        }
    }

    private void updateBalanceOfNodes(BinaryAVLTreeNode<T> root) {
        if (root != null) {
            root.updateBalance();
            updateBalanceOfNodes(root.getLeft());
            updateBalanceOfNodes(root.getRight());
        }
    }

    @Override
    public T removeElement(T targetElement) throws BinaryTreeExceptions {
        T result = null;

        if (!isEmpty()) {
            if (((Comparable) targetElement).equals(root.getElement())) {
                result = root.getElement();
                root = replacement(root);
                size--;
                updateBalanceOfNodes(root);
                root = checkAllNodesBalance(root);
            } else {

                BinaryAVLTreeNode<T> current, parent = root;
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
                updateBalanceOfNodes(root);
                root = checkAllNodesBalance(root);
            }
        } else {
            throw new BinaryTreeExceptions(BinaryTreeExceptions.EMPTY_TREE);
        }

        return result;
    }

    protected BinaryAVLTreeNode<T> replacement(BinaryAVLTreeNode<T> node) {
        BinaryAVLTreeNode<T> result = null;

        if ((node.getLeft() == null) && (node.getRight() == null)) { // Quando o node é uma folha
            result = null;
        } else if ((node.getLeft() != null) && (node.getRight() == null)) { // Quando o node só tem um filho á esquerda, o node é subtituido pelo seu filho
            result = node.getLeft();
        } else if ((node.getLeft() == null) && (node.getRight() != null)) { // Quando o node só tem um filho á direita, o node é subtituido pelo seu filho
            result = node.getRight();
        } else { //
            BinaryAVLTreeNode<T> current = node.getRight();
            BinaryAVLTreeNode<T> parent = node;
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

        try {
            while (true) {
                removeElement(targetElement);
            }

        } catch (Exception ex) {
        }

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

        BinaryAVLTreeNode<T> found = root;

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

        BinaryAVLTreeNode<T> found = root;

        while (found.getRight() != null) {
            found = found.getRight();
        }

        return found.getElement();
    }

    private BinaryAVLTreeNode<T> checkAllNodesBalance(BinaryAVLTreeNode<T> node) {

        if (node != null) {
            node = checkBalance(node);
            node.setLeft(checkAllNodesBalance(node.getLeft()));
            node.setRight(checkAllNodesBalance(node.getRight()));
        }

        return node;
    }

    private BinaryAVLTreeNode<T> checkBalance(BinaryAVLTreeNode<T> current) {
        int balance = current.getBalance();

        if (balance < -1) {
            if (current.getLeft().getBalance() == -1) {
                current = rotationRight(current);
                updateBalanceOfNodes(current); //sem necessidade só para teste
            } else if (current.getLeft().getBalance() == 1) {// dá para simplificar
                current = rotationLeftRight(current);
            }
        } else if (balance > 1) {
            if (current.getRight().getBalance() == 1) {
                current = rotationLeft(current);
                updateBalanceOfNodes(current); //sem necessidade só para teste
            } else if (current.getRight().getBalance() == -1) { // dá para simplificar
                current = rotationRightLeft(current);
            }
        }

        return current;
    }


    private BinaryAVLTreeNode<T> rotationRight(BinaryAVLTreeNode<T> oldRoot) {
        BinaryAVLTreeNode<T> newRoot = new BinaryAVLTreeNode<>(oldRoot.getLeft().getElement());
        newRoot.setLeft(oldRoot.getLeft().getLeft());

        newRoot.setRight(new BinaryAVLTreeNode<>(oldRoot.getElement()));
        newRoot.getRight().setRight(oldRoot.getRight());

        if (oldRoot.getLeft().getRight() != null) {
            newRoot.getRight().setLeft(oldRoot.getLeft().getRight());
        }
        updateBalanceOfNodes(newRoot);
        return newRoot;
    }

    private BinaryAVLTreeNode<T> rotationLeft(BinaryAVLTreeNode<T> oldRoot) {
        BinaryAVLTreeNode<T> newRoot = new BinaryAVLTreeNode<>(oldRoot.getRight().getElement());
        newRoot.setRight(oldRoot.getRight().getRight());

        newRoot.setLeft(new BinaryAVLTreeNode<>((oldRoot.getElement())));
        newRoot.getLeft().setLeft(oldRoot.getLeft());

        if (oldRoot.getRight().getLeft() != null) {
            newRoot.getLeft().setRight(oldRoot.getRight().getLeft());
        }
        updateBalanceOfNodes(newRoot);
        return newRoot;
    }

    private BinaryAVLTreeNode<T> rotationRightLeft(BinaryAVLTreeNode<T> oldRoot) {
        oldRoot.setRight(rotationRight(oldRoot.getRight()));
        oldRoot = rotationLeft(oldRoot);
        return oldRoot;
    }

    private BinaryAVLTreeNode<T> rotationLeftRight(BinaryAVLTreeNode<T> oldRoot) {
        oldRoot.setLeft(rotationLeft(oldRoot.getLeft()));
        oldRoot = rotationRight(oldRoot);
        return oldRoot;
    }
}
