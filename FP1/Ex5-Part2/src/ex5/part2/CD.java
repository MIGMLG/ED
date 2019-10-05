/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

/**
 * Classe que define um CD
 * @author NERD-X
 */
public class CD extends Media{
    
    private int numberOfTracks;
    
    /**
     * Metodo Constructor da Classe
     * @param id
     * @param name
     * @param numberOfTracks
     */
    public CD(int id, String name, int numberOfTracks) {
        super(id, name);
        this.numberOfTracks = numberOfTracks;
    }

    /**
     * Metodo para obter o número de faixas
     * @return
     */
    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    /**
     * Metodo para definir o número de faixas
     * @param numberOfTracks
     */
    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "CD{" + "numberOfTracks=" + numberOfTracks + '}';
    }
    
}
