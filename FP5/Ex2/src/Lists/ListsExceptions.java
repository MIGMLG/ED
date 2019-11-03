package Lists;

public class ListsExceptions extends Exception {

    public final static String NEXTELEMENTNULL = "Não existem mais elementos na lista.";

    public ListsExceptions() {
    }

    public ListsExceptions(String message) {
        super(message);
    }

}
