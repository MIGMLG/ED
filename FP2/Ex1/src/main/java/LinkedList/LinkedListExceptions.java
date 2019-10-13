package LinkedList;

public class LinkedListExceptions extends Exception {

    protected final static String EMPTYLIST = "Lista vazia.";
    protected final static String NOTFOUND = "Não encontrado Node.";

    public LinkedListExceptions() {
        super();
    }

    public LinkedListExceptions(String message) {
        super(message);
    }
}
