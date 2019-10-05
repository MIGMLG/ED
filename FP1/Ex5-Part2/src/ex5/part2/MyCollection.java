/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

import java.util.ArrayList;

/**
 * Classe que define a collection
 * @author NERD-X
 * @param <T>
 */
public class MyCollection<T> {
    
    private ArrayList<T> storage;

    /**
     * Metodo constructor da Classe
     */
    public MyCollection() {
        this.storage = new ArrayList<T>();
    }
    
    /**
     * Metodo para adicionar á collection
     * @param info
     */
    public void addToCollection(T info){
        storage.add(info);
    }
    
    /**
     * Metodo para obter o que está armazenado na collection 
     * @param position posição na lista
     * @return Parametro
     * @throws CollectionExceptions
     */
    public T getFromCollection(int position) throws CollectionExceptions{
        if(storage.isEmpty()){
            throw new CollectionExceptions(CollectionExceptions.EMPTY_LIST);
        }else{
            return storage.get(position);
        }
    }
    
    
}
