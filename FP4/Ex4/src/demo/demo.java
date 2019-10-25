package demo;

import CifraCesar.Cifra;
import CifraCesar.WrongExpressionException;

public class demo {

    public static void main(String[] args) {
        Cifra test = new Cifra();
        String message = "knowledge is power";

        try {
            test.insertKey("3 1 7 4 2 5");
            System.out.println("Mensagem Original : " + message);
            System.out.println("Mensagem Cifrada : " + test.encodeMessage(message));
        } catch (WrongExpressionException e) {
            System.out.println(e.getMessage());
        }
    }

}
