/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

/**
 * Classe abstracta que define Media
 * @author NERD-X
 */
public abstract class Media {
    
    private int id;
    private String name;

    /**
     * Metodo Constructor de Media
     * @param id
     * @param name
     */
    public Media(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Metodo para obter o id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para definir o id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para obter o nome
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo para definir o nome
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Media{" + "id=" + id + ", name=" + name + '}';
    }
    
}
