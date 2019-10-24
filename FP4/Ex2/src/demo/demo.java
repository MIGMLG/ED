package demo;

import Queue.CircularArrayQueue;

public class demo {

    public static void main(String[] args) {

        CircularArrayQueue<String> tmp = new CircularArrayQueue<>();
        int test = 7;

        switch (test){
            // Teste para o enqueue
            case 1 :
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                System.out.println(tmp.toString());
                break;
            case 2 : // Teste para isEmpty
                System.out.println("Deve ser true. Resultado : " + tmp.isEmpty());
                break;
            case 3 : // Teste para first quando está empty
                System.out.println("Imprimir null. Resultado: " + tmp.first());
                break;
            case 4 : // Teste para dequeue sem elementos
                System.out.println("Return null. Resultado : " + tmp.dequeue());
                System.out.println(tmp.toString());
                break;
            case 5 : // Teste para dequeue 1 elemento
                tmp.enqueue("Hello World!");
                System.out.println("Return Hello World! Resultado : " + tmp.dequeue());
                System.out.println(tmp.toString());
                break;
            case 6 : // Teste para dequeue 3 elementos
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                System.out.printf("Return Hello Wolrd. Resultado : " + tmp.dequeue());
                System.out.println("\n" + tmp.toString());
                break;
            case 7 : // Teste para expandir capacidade
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                tmp.enqueue("Hello World!1");
                tmp.enqueue("GoodBye World!1");
                tmp.enqueue("Who is Joe ?1");
                tmp.enqueue("Hello World!2");
                tmp.enqueue("GoodBye World!2");
                tmp.enqueue("Who is Joe ?2");
                tmp.enqueue("Hello World!3");
                tmp.enqueue("GoodBye World!3");
                tmp.enqueue("Who is Joe ?3");
                System.out.println(tmp.size());
                System.out.println(tmp.toString());
                break;
            case 8 : // Teste dequeue after expand
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                tmp.enqueue("Hello World!");
                tmp.enqueue("GoodBye World!");
                tmp.enqueue("Who is Joe ?");
                System.out.printf("Return Hello Wolrd. Resultado : " + tmp.dequeue());
                System.out.println("\n" + tmp.toString());
                break;
            default: break;


        }


    }

}
