package demo;

import Calculadora.Calculadora;

public class demo {

    public static void main(String[] args) {

        Calculadora test = new Calculadora();
        String exp = "7 4 -3 * 1 5 + / * ";

        test.setExpression(exp);

        try {
            System.out.println("Resultado: " + test.execute());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
