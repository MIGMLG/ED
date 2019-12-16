package BinaryTree;

public class BinaryAVLTreeNode<T> {

    private T element;
    private BinaryAVLTreeNode<T> left, right;
    private int balance;

    public BinaryAVLTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
        this.balance = 0;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryAVLTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryAVLTreeNode<T> left) {
        this.left = left;
    }

    public BinaryAVLTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryAVLTreeNode<T> right) {
        this.right = right;
    }

    public int numChildren() {
        int children = 0;

        if (left != null) {
            children = 1 + left.numChildren();
        }
        if (right != null) {
            children = children + 1 + right.numChildren();
        }

        return children;
    }

    public int getBalance() {
        return balance;
    }

    public void updateBalance() {
        this.balance = findHeight(right) - findHeight(left);
    }

    private int findHeight(BinaryAVLTreeNode<T> root) {
        if (root == null) {
            return -1;
        }

        int lefth = findHeight(root.getLeft());
        int righth = findHeight(root.getRight());

        if (lefth > righth) {
            return lefth + 1;
        } else {
            return righth + 1;
        }
    }
}
