package List;

public class LinkNode<T> {
    T data;
    LinkNode<T> next;

    public LinkNode(T data, LinkNode<T> next) {
        this.data = data;
        this.next = next;
    }

    public LinkNode<T> getNext() {
        return next;
    }

    public void setNext(LinkNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LinkNode{" +
                "data=" + data +
                '}';
    }
}
