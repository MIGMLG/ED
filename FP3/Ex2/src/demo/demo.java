package demo;

import LinkedStack.*;

public class demo {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack();
        int test = 2;

        switch (test){
            // Teste para o Push
            case 1 :
                stack.push("Hello");
                stack.push("World");
                stack.push(".");
                System.out.println(stack.toString());
                break;
            case 2 : // Teste para o Pop com elementos lá dentro
                stack.push("Hello");
                stack.push("World");
                stack.push(".");
                System.out.println(stack.toString());
                try {
                    System.out.println("Removido: " + stack.pop() + "\n");
                    System.out.println("Removido: " + stack.pop() + "\n");
                    System.out.println("Removido: " + stack.pop() + "\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());;
                }
                System.out.println(stack.toString());
                break;
            case 3 : // Teste do Pop com a stack Vazia
                try {
                    System.out.println("Removido: " + stack.pop() + "\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());;
                }
                break;
            case 4 : // Teste para fazer Peek com elementos na stack
                stack.push("Hello");
                stack.push("World");
                stack.push(".");
                System.out.println(stack.toString());
                try {
                    System.out.println("Top: " + stack.peek() + "\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());;
                }
                System.out.println(stack.toString());
                break;
            case 5 : // Teste para fazer Peek sem elementos na stack
                try {
                    System.out.println("Top: " + stack.peek() + "\n");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());;
                }
                System.out.println(stack.toString());
                break;
            default: break;
        }

    }
}
