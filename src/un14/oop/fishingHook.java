/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Olivier Nowak
 */

public class fishingHook {
    
    private final int X;
    private int Y, hookVel;
    private Image hookSprite;
    private int canMove; //added this as the simplest way i could think of to stop hook from going up past the ship
    private int score;
    
    public fishingHook(){
        X = 0;
        Y = -501;
        hookVel = 0;
        loadSprite();
        canMove = 0;
        score = 0;
    }
    private void loadSprite() {
        
        ImageIcon cs = new ImageIcon(getClass().getResource("/un14/oop/images/fishingHook.png"));
        hookSprite = cs.getImage(); 
    }
    
    public void move(){
        if(Y > -50){
            hookVel = -5;
        }
        if(canMove == 0){
            hookVel = 0;
        }
        if(Y < -500 && hookVel < -1){ //checking if high enough and going up, without the hookvel check it would constantly lock up at the start
            canMove = 0;
        }
        Y += hookVel;
    }
    public int getX() {
        
        return X;
    }

    public int getY() {
        
        return Y;
    }  

    public Image getImage() {
        
        return hookSprite;
    }
    
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            canMove = 1;
            if(Y < -500){
                hookVel = 5;
            }
        }

    }
    
    public java.awt.Rectangle getBounds() {
        int spriteW = hookSprite.getWidth(null);
        int spriteH = hookSprite.getHeight(null);
        
        int hitboxW = spriteW/10; //making a small hitbox 10% of the original size
        int hitboxH = spriteH/10;
        
        int hitboxX = X + (spriteW-hitboxW)/2;//this centres the hitbox
        int hitboxY = Y + spriteH - hitboxH;//this puts the hitbox at the bottom at the hook
        
        return new java.awt.Rectangle(hitboxX, hitboxY, hitboxW, hitboxH);
    }

    public int getScore() {
        return score; //for future leaderboard
    }

    public void changeScore(int amount) {
        score += amount;
    }
}
