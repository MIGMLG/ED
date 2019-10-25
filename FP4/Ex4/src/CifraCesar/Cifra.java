package CifraCesar;

import Queue.CircularArrayQueue;
import Queue.QueueADT;

public class Cifra {

    QueueADT<Integer> queue = new CircularArrayQueue<>();

    public void insertKey(String Key) throws WrongExpressionException {
        String[] numbers = Key.split(" ");

        for (int i = 0; i < numbers.length; i++) {
            try {
                int result = Integer.parseInt(numbers[i]);
                queue.enqueue(result);
            } catch (Exception ex) {
                throw new WrongExpressionException(WrongExpressionException.WRONGEXCEPTION);
            }
        }

    }

    public String encodeMessage(String message) throws WrongExpressionException {
        String tmpString = new String();

        if (queue.size() != 0) {

            for (int i = 0; i < message.length(); i++) {
                if (message.charAt(i) != ' ') {
                    int numberKey = queue.dequeue();
                    char tmpChar;

                    if (Character.isUpperCase(message.charAt(i))) {
                        tmpChar = (char) (((int) message.charAt(i) + numberKey - 65) % 26 + 65);
                    } else {
                        tmpChar = (char) (((int) message.charAt(i) + numberKey - 97) % 26 + 97);
                    }

                    tmpString += tmpChar;
                    queue.enqueue(numberKey);
                } else {
                    tmpString += " ";
                }
            }

            return tmpString;
        }

        throw new WrongExpressionException(WrongExpressionException.WRONGEXCEPTION);
    }

}
