/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

/**
 * Classe que define um livro
 * @author NERD-X
 */
public class Book extends Media{
    
    private int numberOfPages;

    /**
     * Metodo Constructor da Classe
     * @param numberOfPages
     * @param id
     * @param name
     */
    public Book(int numberOfPages, int id, String name) {
        super(id, name);
        this.numberOfPages = numberOfPages;
    }

    /**
     * Metodo para obter o número de páginas
     * @return
     */
    public int getNumberOfPages() {
        return numberOfPages;
    }

    /**
     * Metodo para definir o número de páginas
     * @param numberOfPages
     */
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" + "numberOfPages=" + numberOfPages + '}';
    }
    
}
