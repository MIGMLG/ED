package BinaryTree;

public class BinaryAVLTreeNode<T> {

    private T element;
    private BinaryAVLTreeNode<T> left, right;

    public BinaryAVLTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
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
        return findRightHeight(this) - findLeftHeight(this);
    }

    private int findLeftHeight(BinaryAVLTreeNode<T> treeRoot) {
        if (treeRoot == null) {
            return 0;
        }

        int left = 1 + findLeftHeight(treeRoot.getLeft());

        return left;
    }

    private int findRightHeight(BinaryAVLTreeNode<T> treeRoot) {
        if (treeRoot == null) {
            return 0;
        }

        int right = 1 + findRightHeight(treeRoot.getRight());

        return right;
    }
}
