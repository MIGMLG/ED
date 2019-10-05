/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Clase Demo para testes
 * @author NERD-X
 */
public class Ex4Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<String> tmp = new ArrayList();
        tmp.add("Hello");
        tmp.add("World");
        tmp.add("GoodBye");
        tmp.add("Earth");
        System.out.println(tmp);

        //Classe Anonima
        Collections.sort(tmp, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }
                
        );
        System.out.println(tmp);
    }

}
