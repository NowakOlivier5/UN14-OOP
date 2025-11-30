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
    public FishingApp(){
        FishingUI();
    }
    private void FishingUI(){
        add(new Fishing());
        setSize(1280, 720);
        
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            FishingApp fishing = new FishingApp();
            fishing.setVisible(true);
        });
    }
}
