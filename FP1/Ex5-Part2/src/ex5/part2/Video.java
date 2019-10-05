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
public class Video extends Media{
    
    private int secondsOfDuration;

    public Video(int secondsOfDuration, int id, String name) {
        super(id, name);
        this.secondsOfDuration = secondsOfDuration;
    }

    public int getSecondsOfDuration() {
        return secondsOfDuration;
    }

    public void setSecondsOfDuration(int secondsOfDuration) {
        this.secondsOfDuration = secondsOfDuration;
    }

    @Override
    public String toString() {
        return "Video{" + "secondsOfDuration=" + secondsOfDuration + '}';
    }
    
}
