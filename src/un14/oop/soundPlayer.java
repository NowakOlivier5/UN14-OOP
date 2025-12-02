/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author Olivier Nowak
 */

//followed this tutorial https://www.youtube.com/watch?v=wJO_cq5XeSA
public class soundPlayer {
    
    private Clip clip;
    private AudioInputStream audioInput;
    
    public soundPlayer(String path){
        try{
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(getClass().getResource(path));
            clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            //setVolume(SettingsGUI.volume); //out of nowhere this started breaking the sound so i commented it out for now
            clip.start();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void setVolume(float volume){ 
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);//this line is from https://stackoverflow.com/questions/953598/audio-volume-control-increase-or-decrease-in-java
        System.out.println(volume);
        if(volume == 0f){//the only solutions i found online involved formulas converting the volume percentage to decibels, which i didnt understand so i hardcoded decibel values instead
            gainControl.setValue(-80f);
        }else if(volume == 1f){
            gainControl.setValue(-40f);
        }else if(volume == 2f){
            gainControl.setValue(-10f);
        }else if(volume == 3f){
            gainControl.setValue(0f);
        }else{
            gainControl.setValue(6f);
        }
    }
}