/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;

/**
 *
 * @author NERD-X
 */
public class Ex1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TwoTypePair<String,String> tmp = new TwoTypePair("Hello", "World");
        TwoTypePair<String,String> tmp1 = new TwoTypePair("Hellos", "World");
        System.out.println(tmp.equals(tmp1));
        
    }
    
}
