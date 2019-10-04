/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import static ex4.Ex4.printCollection;
import java.util.Collection;

/**
 *
 * @author NERD-X
 */
public class Ex4 {

    static void printCollection(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Collection<String> c;
        // TODO code application logic here
        printCollection(c);
    }

    

}
