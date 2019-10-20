package Calculadora;

public class WrongExpressionException extends Exception {

    public final static String WRONGEXCEPTION = "A expressão não foi definida ou está incorreta.";

    public WrongExpressionException() {
    }

    public WrongExpressionException(String message) {
        super(message);
    }
}
