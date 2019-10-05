/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Demo classe para testes
 * @author NERD-X
 */
public class Ex5Part2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CD cd1 = new CD(1,"Never Gonna Give You Up", 1);
        MyCollection<Media> tmp = new MyCollection();
        tmp.addToCollection(cd1);
        try {
            System.out.println(tmp.getFromCollection(0));
        } catch (CollectionExceptions ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
