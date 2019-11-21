package list;

public class LinkedList<T> {

    private LinkNode<T> head, tail;
    private long size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean add(T data){
        if(head == null){
            LinkNode<T> current = new LinkNode<T>(data, null);
            this.head = current;
            this.tail = current;
            this.size++;
            return true;
        }else{
            LinkNode<T> current = this.tail;
            LinkNode<T> next = new LinkNode<>(data, null);
            current.setNext(next);
            this.tail = next;
            this.size++;
            return true;
        }

    }

    public T remove(T data) throws LinkedListExceptions {
        if(this.head == null){
            throw new LinkedListExceptions(LinkedListExceptions.EMPTYLIST);
        }
        else{
            LinkNode<T> current = head;
            LinkNode<T> previous = null;

            boolean found = false;
            while(current!=null && found == false){
                if(current.getData().equals(data)){
                    found = true;
                }else{
                    previous = current;
                    current = current.getNext();
                }
            }

            if(found == true){
                if(this.size == 1){
                    this.head = null;
                    this.tail = null;
                }else if(current.getData().equals(head.getData())){
                    head = head.getNext();
                }else if(current.getData().equals(tail.getData())){
                    previous.setNext(null);
                    tail = previous;
                }else {
                    previous.setNext(current.getNext());
                }
                this.size--;
                return current.getData();
            }else {
                throw new LinkedListExceptions(LinkedListExceptions.NOTFOUND);
            }
        }
    }

    public LinkNode<T> getHead() {
        return head;
    }

    public LinkNode<T> getTail() {
        return tail;
    }

    public long getSize() {
        return size;
    }

    public void printList(){
        LinkNode<T> current = head;
        while(current!=null){
            System.out.println(current.toString());
            current= current.getNext();
        }
    }
}
