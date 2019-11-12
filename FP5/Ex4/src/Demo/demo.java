package Demo;

import Lists.ListExceptions;
import Lists.UnorderedArray;
import Lists.UnorderedListADT;

public class demo {

    public static void Tests(int test) throws ListExceptions {
        UnorderedListADT<Integer> tmp = new UnorderedArray<Integer>();

        switch (test) {
            case 1: // Teste para removeFirst quando está empty
                System.out.println("Imprimir null. Resultado: " + tmp.removeFirst());
                break;
            case 2: // Teste para removeFirst quando está com 1 elemento
                tmp.addToFront(3);
                System.out.println("Imprimir 3. Resultado: " + tmp.removeFirst());
                break;
            case 3: // Teste para removeFirst quando está com 2 elementos
                tmp.addToFront(2);
                tmp.addToRear(3);
                System.out.println("Imprimir 2. Resultado: " + tmp.removeFirst());
                break;
            case 4: // Teste para removeFirst quando está com 3 elementos
                tmp.addToFront(1);
                tmp.addToRear(2);
                tmp.addToRear(3);
                System.out.println("Imprimir 1. Resultado: " + tmp.removeFirst());
                break;
            case 5: // Teste para removeLast quando está empty
                System.out.println("Imprimir null. Resultado: " + tmp.removeLast());
                break;
            case 6: // Teste para removeLast quando está com 1 elemento
                tmp.addToRear(3);
                System.out.println("Imprimir 3. Resultado: " + tmp.removeLast());
                break;
            case 7: // Teste para removeLast quando está com 2 elementos
                tmp.addToFront(2);
                tmp.addToRear(3);
                System.out.println("Imprimir 3. Resultado: " + tmp.removeLast());
                break;
            case 8: // Teste para removeLast quando está com 3 elementos
                tmp.addToFront(1);
                tmp.addToRear(2);
                tmp.addToRear(3);
                System.out.println("Imprimir 3. Resultado: " + tmp.removeLast());
                break;
            case 9: // Teste para remove sem elementos
                System.out.println("Return null. Resultado : " + tmp.remove(1));
                System.out.println(tmp.toString());
                break;
            case 10: // Teste para remover 1 elemento
                tmp.addToFront(1);
                System.out.println("Return 1. Resultado : " + tmp.remove(1));
                System.out.println(tmp.toString());
                break;
            case 11: // Teste para remover no meio com 6 elementos
                tmp.addToFront(3);
                tmp.addToFront(2);
                tmp.addToFront(1);
                tmp.addToRear(6);
                tmp.addAfter(5,3);
                tmp.addAfter(4, 3);
                System.out.printf("Return 2. Resultado : " + tmp.remove(2));
                System.out.println("\n" + tmp.toString());
                break;
            case 12: // Teste para remover a head com 6 elementos
                tmp.addToFront(3);
                tmp.addToFront(2);
                tmp.addToFront(1);
                tmp.addToRear(6);
                tmp.addAfter(5,3);
                tmp.addAfter(4, 3);
                System.out.printf("Return 1. Resultado : " + tmp.remove(1));
                System.out.println("\n" + tmp.toString());
                break;
            case 13: // Teste para remover a tail com 6 elementos
                tmp.addToFront(3);
                tmp.addToFront(2);
                tmp.addToFront(1);
                tmp.addToRear(6);
                tmp.addAfter(5,3);
                tmp.addAfter(4, 3);
                System.out.printf("Return 6. Resultado : " + tmp.remove(6));
                System.out.println("\n" + tmp.toString());
                break;
            case 14: // Teste para first quando está empty
                System.out.println("\nImprimir null. Resultado: " + tmp.first());
                break;
            case 15: // Teste para first com 1 elemento
                tmp.addToFront(3);
                System.out.println("\nImprimir 3. Resultado: " + tmp.first());
                break;
            case 16: // Teste para first com 2 elementos
                tmp.addToFront(3);
                tmp.addToRear(4);
                System.out.println("\nImprimir 3. Resultado: " + tmp.first());
                break;
            case 17: // Teste para last quando está empty
                System.out.println("Imprimir null. Resultado: " + tmp.last());
                break;
            case 18: // Teste para last com 1 elemento
                tmp.addToFront(3);
                System.out.println("Imprimir 3. Resultado: " + tmp.last());
                break;
            case 19: // Teste para last com 2 elementos
                tmp.addToFront(3);
                tmp.addToRear(4);
                System.out.println("Imprimir 4. Resultado: " + tmp.last());
                break;
            case 20: // Teste para contains quando está empty
                System.out.println("Imprimir false. Resultado: " + tmp.contains(1));
                break;
            case 21: // Teste para contains quando contem o elemento
                tmp.addToFront(1);
                tmp.addAfter(2, 1);
                tmp.addToRear(3);
                System.out.println("Imprimir true. Resultado: " + tmp.contains(2));
                break;
            case 22: // Teste para contains quando não contem o elemento
                tmp.addToFront(1);
                tmp.addAfter(2, 1);
                tmp.addToRear(3);
                System.out.println("Imprimir false. Resultado: " + tmp.contains(4));
                break;
            case 23: // Teste para isEmpty quando está empty
                System.out.println("Deve ser true. Resultado : " + tmp.isEmpty());
                break;
            case 24: // Teste para isEmpty quando não está empty
                tmp.addToFront(1);
                tmp.addAfter(2, 1);
                tmp.addToRear(3);
                System.out.println("Deve ser false. Resultado : " + tmp.isEmpty());
                break;
            case 25: // Teste para size com 3 elementos
                tmp.addToFront(1);
                tmp.addAfter(2, 1);
                tmp.addToRear(3);
                System.out.println("Deve ser 3. Resultado : " + tmp.size());
                break;
            case 26: // Teste para size com 0 elementos
                System.out.println("Deve ser 0. Resultado : " + tmp.size());
                break;
            case 27: // Teste para o adds combinados
                tmp.addToFront(3);
                tmp.addToFront(2);
                tmp.addToFront(1);
                tmp.addToRear(6);
                tmp.addAfter(5,3);
                tmp.addAfter(4, 3);
                System.out.println(tmp.toString());
                break;
            case 28: //Teste para addAfter
                tmp.addToRear(3);
                tmp.addAfter(4, 3);
                tmp.addToFront(2);
                System.out.println(tmp.toString());
            default:
                break;
        }
    }

    public static void main(String[] args) {

        for(int i = 0; i <= 28 ; i++){
            try {
                Tests(i);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

}
