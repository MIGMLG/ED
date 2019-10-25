package Demo;

import Queue.LinkedQueue;

public class demo {

    public static void main(String[] args) {

        LinkedQueue<Integer> tmp = new LinkedQueue<>();
        int test = 1;

        switch (test) {
            // Teste para o enqueue
            case 1:
                tmp.enqueue(3);
                tmp.enqueue(2);
                tmp.enqueue(1);
                tmp.enqueue(6);
                tmp.enqueue(5);
                tmp.enqueue(4);
                System.out.println(tmp.toString());
                break;
            case 2: // Teste para isEmpty
                System.out.println("Deve ser true. Resultado : " + tmp.isEmpty());
                break;
            case 3: // Teste para first quando está empty
                System.out.println("Imprimir null. Resultado: " + tmp.first());
                break;
            case 4: // Teste para dequeue sem elementos
                System.out.println("Return null. Resultado : " + tmp.dequeue());
                System.out.println(tmp.toString());
                break;
            case 5: // Teste para dequeue 1 elemento
                tmp.enqueue(3);
                System.out.println("Return Hello World! Resultado : " + tmp.dequeue());
                System.out.println(tmp.toString());
                break;
            case 6: // Teste para dequeue 3 elementos
                tmp.enqueue(3);
                tmp.enqueue(2);
                tmp.enqueue(1);
                System.out.printf("Return Hello Wolrd. Resultado : " + tmp.dequeue());
                System.out.println("\n" + tmp.toString());
                break;
            default:
                break;
        }
    }

}
