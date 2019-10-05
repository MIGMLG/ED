/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

/**
 *
 * @author NERD-X
 */
public class CollectionExceptions extends Exception{

    public static final String EMPTY_LIST = "Ainda não existem conteudo na lista."; 
    
    public CollectionExceptions(String message) {
        super(message);
    }
    
}
