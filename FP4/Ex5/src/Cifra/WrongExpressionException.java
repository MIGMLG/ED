package Cifra;

public class WrongExpressionException extends Exception {

    public final static String WRONGEXCEPTION = "A chave não foi definida ou está incorreta.";

    public WrongExpressionException() {
    }

    public WrongExpressionException(String message) {
        super(message);
    }
}
