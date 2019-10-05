/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

/**
 * Classe que define as exceções da Collection
 * @author NERD-X
 */
public class CollectionExceptions extends Exception{

    /**
     * String para quando não existe nada na lista
     */
    public static final String EMPTY_LIST = "Ainda não existem conteudo na lista."; 
    
    /**
     * Metodo Constructor para a exception
     * @param message
     */
    public CollectionExceptions(String message) {
        super(message);
    }
    
}
