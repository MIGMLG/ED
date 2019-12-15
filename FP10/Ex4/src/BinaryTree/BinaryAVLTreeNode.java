package BinaryTree;

public class BinaryAVLTreeNode<T> {

    private T element;
    private BinaryAVLTreeNode<T> left, right;
    protected int balance;

    public BinaryAVLTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
        this.balance = 0;
    }

    public T getElement() {
        return element;
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
}
