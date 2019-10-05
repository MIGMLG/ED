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
public class Book extends Media{
    
    private int numberOfPages;

    public Book(int numberOfPages, int id, String name) {
        super(id, name);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" + "numberOfPages=" + numberOfPages + '}';
    }
    
}
