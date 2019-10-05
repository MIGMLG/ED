/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

import java.util.ArrayList;

/**
 *
 * @author NERD-X
 * @param <T>
 */
public class MyCollection<T> {
    
    private ArrayList<T> storage;

    public MyCollection() {
        this.storage = new ArrayList<T>();
    }
    
    public void addToCollection(T info){
        storage.add(info);
    }
    
    public T getFromCollection(int position) throws CollectionExceptions{
        if(storage.isEmpty()){
            throw new CollectionExceptions(CollectionExceptions.EMPTY_LIST);
        }else{
            return storage.get(position);
        }
    }
    
    
}
