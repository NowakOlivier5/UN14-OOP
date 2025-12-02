/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

/**
 *
 * @author Olivier Nowak
 */
import java.awt.EventQueue;
import javax.swing.JFrame;

public class FishingApp extends JFrame{
    
    private String name;
    private soundPlayer music;
    
    public FishingApp(String name){
        this.name = name;
        music = new soundPlayer("/un14/oop/sound/fishingMusic.wav");
        FishingUI();
    }
    public String getPlayer(){ //getName didnt work for some reason
        return name;
    }
    private void FishingUI(){
        add(new Fishing(name));
        setSize(1280, 720);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            FishingApp fishing = new FishingApp("");//placeholder as i added name functionality later and had to add something here to make it work
            fishing.setVisible(true);
        });
        
    }
}
