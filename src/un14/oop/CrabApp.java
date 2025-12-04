/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;
/*To learn how to make my own game I have used different tutorials, I had to learn to make different games like Flappy bird before I could make my game. 
*https://zetcode.com/javagames/collision/
*http://edu4java.com/es/game/game0.html (This one is in spanish, but i think you can review it in english somewhere in the website)
*https://www.instructables.com/Java-Game-Programming-Tutorial-Flappy-Bird-Redux/ 
*https://www.youtube.com/watch?v=Xw2MEG-FBsE&t=2104s These ones are the resources I used to learn how to do games on java without having to make a game engine from scratch.
*/
/**
 *CrabApp.java
 * @author Lestat Alvarez Quintana Ordiz 
 */
import java.awt.EventQueue;
import javax.swing.JFrame;
public class CrabApp extends JFrame{ //Here I use extend Jframe to create my window for my game.
    private final soundPlayer song;
    public CrabApp(){
        song = new soundPlayer("/un14/oop/sound/CrabSong.wav"); //Olivier told me to put this here so i can also have a song of my choosing.
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

