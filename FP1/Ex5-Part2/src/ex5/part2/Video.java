/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5.part2;

/**
 * Classe que define video
 * @author NERD-X
 */
public class Video extends Media{
    
    private int secondsOfDuration;

    /**
     * Metodo Constructor da classe
     * @param secondsOfDuration
     * @param id
     * @param name
     */
    public Video(int secondsOfDuration, int id, String name) {
        super(id, name);
        this.secondsOfDuration = secondsOfDuration;
    }

    /**
     * Metodo para obter a duração do video
     * @return
     */
    public int getSecondsOfDuration() {
        return secondsOfDuration;
    }

    /**
     * Metodo para definir a duração do video
     * @param secondsOfDuration
     */
    public void setSecondsOfDuration(int secondsOfDuration) {
        this.secondsOfDuration = secondsOfDuration;
    }

    @Override
    public String toString() {
        return "Video{" + "secondsOfDuration=" + secondsOfDuration + '}';
    }
    
}
