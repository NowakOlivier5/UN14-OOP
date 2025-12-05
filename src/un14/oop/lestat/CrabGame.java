/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop.lestat;

/**
 *CrabGame.java
 * @author Lestat Alavarez Quintana Ordiz
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Image;

public class CrabGame extends JPanel implements ActionListener{
    //These timers are for the loops that needs to be happening contantly, ill say what the do on the comment next to when they get used.
    private Timer crabLoop;
    private Timer trashSpawner;
    private CrabSprite crabSprite;
    private Image crabBackground;
    private CrabTrash crabTrash;
    private boolean crabDead = false;
    private boolean crabStart = false;
    private int crabPoints = 0;
    
    public CrabGame(){
        crabBoard(); //This starts basically my whole game. From the loops that the game needs to the UI. By just calling the function.
    }
    
    private void crabBoard(){
        setBackground(Color.BLACK);//I dont really really need this, but just in case that in another computer takes longer to load at least there would be a black background.
        setFocusable(true);//This allows the keyboard to be used and send inputs.
        
        crabBackground = new ImageIcon(getClass().getResource("/un14/oop/images/crabBackground.jpg")).getImage(); //I choose the ocean because its for the Life Below Water so thats why sea animals and all that, so i just set the background here.
        
        crabSprite = new CrabSprite();//This is to create a new instance and initialize the "player".
        crabTrash = new CrabTrash(1280, 720); //This is for the trash, i NEED to initialize it with the screen size, because its how the trash would be spawning by having the size as reference.
        
        addKeyListener(new TAdapter());//The keyboard listener
        
        crabLoop = new Timer(16, this);//I might mess around with this in the future a bit more, but keeping it at 16 makes the game stay at 60 fps.
        crabLoop.start();
        trashSpawner = new Timer(1500, e -> crabTrash.spawningTrash());//This is my trash spawner. I found out that its ms what it measures in time, so if i want to make the game harder i could put less time and make the trash spawn more freacuently.
        
        trashSpawner.start();
    }
    
    @Override //Here is my loose condition and controls. And points ofc
    public void actionPerformed(ActionEvent e){
        if (!crabDead && crabStart){ //Im adding the variable crabStart, so this way the game starts when the players wants to, and shows the instructions.
//I check if the crab state is false, if it is, lets keep going! and add those points when the trash passes outside the screen. If it touched the trash, everything stops.
            crabSprite.move();
            crabPoints += crabTrash.trashPos();
            if(crabTrash.crabDeath(crabSprite)){
                crabDead = true;
                trashSpawner.stop();
                crabLoop.stop();
            }
        }
        repaint(); //If i dont use repaint it doesnt remove the previous position leaving a weird dragged blob behind the crab. So with this redraws the sprite all the time.
    }
    
    public void crabPoints(Graphics g){ // I just display the points on "live" as they are updating while playing.
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString("Points: " + crabPoints, 20, 40);
    }
    
    @Override
    public void paintComponent(Graphics g){ //here im drawing the board that will be on my window. There is the inherintance super.
        super.paintComponent(g); 
        
        g.drawImage(crabBackground, 0,0,getWidth(), getHeight(), this);//This draws my background, the cordinates there says from where it should start drawing it, that it would be top left corner.
     
        if (!crabStart && !crabDead){
            drawCrabStart(g);
        }
        drawCrab(g); //Drawing the crab, the trash and the points!
        crabTrash.drawTrash(g, this);
        if(crabStart && !crabDead){
            crabPoints(g);
        }
        if(crabDead) { //For the "death" I put a message on screen with the points, this call that function and draws it when the player looses.
            drawCrabDead(g);
        }
        
        Toolkit.getDefaultToolkit().sync(); //On a tutorial that i was watching about the paint component, recommended to always put this to avoid screen bugs that can happen with some hardware and systems.
    }
    
    //This is the function that we call before to draw the crab, here is where it happends, assigning the position where it is and the size that i choose for the image.  
    private void drawCrab(Graphics g){ 
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(crabSprite.getImage(), crabSprite.getCrabX(), crabSprite.getCrabY(), 130, 130, this);
    }
    
    //Same as the text of before, but in this case is what we are summoning in the previous part to show on the screen when the crab "dies"
    private void drawCrabDead(Graphics g){
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("THE CRAB GOT CAUGHT IN THE TRASH!",200, 300);
        g.drawString("Your points: "+crabPoints,200, 500);
    }
    //This next part is going to be the display of my instrucctions before the player starts playing.
    private void drawCrabStart(Graphics g){
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("Jump Little Crab!", 450, 100);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Press up to beging", 570, 200);
        g.drawString("How to play:", 250, 350);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Pressing the UP arrow key makes the crab Jump", 350, 400);
        g.drawString("Jump over the trash to gain points and avoid touching it!", 300, 450);        
    }
     
    //Handles the input of the player. Gives the command to the sprite on "what to do when key is pressed" I also added so the screen stays still till the player presses start.
     private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int start = e.getKeyCode();
            if(!crabStart && start == KeyEvent.VK_UP){
               crabStart = true;
            }else if(crabStart){
                crabSprite.keyPressed(e);
            }
        }
    }
     
    
}
