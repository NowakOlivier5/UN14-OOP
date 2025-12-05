/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop.yaroslav;

import javax.swing.JFrame;
import java.awt.EventQueue;
import un14.oop.olivier.soundPlayer;
/**
 *
 * @author Yaroslav Kondaurov
 */
public class ShrimpApp extends JFrame{
    private soundPlayer music;
    
    // Main method calling
    public ShrimpApp() {
        music = new soundPlayer("/un14/oop/sound/shrimpMusic.wav");
        shrimpUI();
    }
    
    private void shrimpUI() { 
        add(new Shrimp());
        setTitle("Shrimp Game");
        setSize(1280, 720); // Sets the preferred size
        setResizable(false); // Prevents resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Stops the processes once the application is closed
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ShrimpApp shrimp = new ShrimpApp();
            shrimp.setVisible(true);
        });
    }
}
