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
public class CrabApp extends JFrame{ //Here I use extend Jframe to create my window for my game.
    public CrabApp(){
        crabUI(); //With this I call the method and I start the UI
    }
    private void crabUI(){ //In the first part i create my Jpanel while also setting its size and title.  
        add(new CrabGame());
        setSize(1280, 720);
        
        setTitle("Crab Game");
        setResizable(false); //This is to stop resizing, so this way is more consintent with the other games.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Puts the window in the middle of your screen.
    }
    public static void main(String[] args){
        EventQueue.invokeLater(() -> { //Creates my gui and keeps it updated.
            CrabApp crab = new CrabApp(); //Makes a new instance of my game window and sets it as visible for the user.
            crab.setVisible(true);
        });
    }
}

