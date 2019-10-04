/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4.part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
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
        ComparatorString test = new ComparatorString();
        Collections.sort(tmp, test);
        System.out.println(tmp);
    }
    
}
