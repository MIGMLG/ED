package Demo;

import Lists.DoubleLinkedOrderedList;
import Lists.OrderedListADT;

public class demo {

    public static void main(String[] args) {
        OrderedListADT<Integer> tmp = new DoubleLinkedOrderedList<>();
        int test = 6;

        switch (test) {
            // Teste para o add
            case 1:
                tmp.add(3);
                tmp.add(2);
                tmp.add(1);
                tmp.add(6);
                tmp.add(5);
                tmp.add(4);
                System.out.println(tmp.toString());
                break;
            case 2: // Teste para isEmpty
                System.out.println("Deve ser true. Resultado : " + tmp.isEmpty());
                break;
            case 3: // Teste para first quando está empty
                System.out.println("Imprimir null. Resultado: " + tmp.first());
                break;
            case 4: // Teste para remove sem elementos
                System.out.println("Return null. Resultado : " + tmp.removeFirst());
                System.out.println("Return null. Resultado : " + tmp.remove(1));
                System.out.println("Return null. Resultado : " + tmp.removeLast());
                System.out.println(tmp.toString());
                break;
            case 5: // Teste para remover 1 elemento
                tmp.add(1);
                System.out.println("Return 1. Resultado : " + tmp.remove(1));
                System.out.println(tmp.toString());
                break;
            case 6: // Teste para remover com 3 elementos
                tmp.add(3);
                tmp.add(2);
                tmp.add(1);
                tmp.add(6);
                tmp.add(5);
                tmp.add(4);
                System.out.printf("Return 2. Resultado : " + tmp.remove(2));
                System.out.println("\n" + tmp.toString());
                break;
            default:
                break;
        }

    }

}
