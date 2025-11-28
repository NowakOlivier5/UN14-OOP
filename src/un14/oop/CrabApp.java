/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;



/**
 *CrabApp.java
 * @author Lestat Alvarez Quintana Ordiz 
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
public class CrabApp extends JFrame{
    public CrabApp(){
        crabUI();
    }
    private void crabUI(){
        add(new CrabGame());
        setSize(1280, 720);
        
        setTitle("Crab Game");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            CrabApp crab = new CrabApp();
            crab.setVisible(true);
        });
    }
}

