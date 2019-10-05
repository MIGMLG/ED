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
public class CD extends Media{
    
    private int numberOfTracks;
    
    public CD(int id, String name, int numberOfTracks) {
        super(id, name);
        this.numberOfTracks = numberOfTracks;
    }

    public int getNumberOfTracks() {
        return numberOfTracks;
    }

    public void setNumberOfTracks(int numberOfTracks) {
        this.numberOfTracks = numberOfTracks;
    }

    @Override
    public String toString() {
        return "CD{" + "numberOfTracks=" + numberOfTracks + '}';
    }
    
}
