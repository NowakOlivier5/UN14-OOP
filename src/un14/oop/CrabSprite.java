/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

/**
 *CrabSprite.java
 * @author Lestat Alvarez Quintana Ordiz
 */
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class CrabSprite {

    private final int crabX;
    private int crabY;
    private final double crabGrav, crabJump; //I need a velocity and gravity so the jumping is smooth, I learned this while working with scratch last year, it avoids the jump and falling to just look like its on "rails".
    private double crabVel;
    private Image crabSprite;

    public CrabSprite() {
        crabY = 575;
        crabX = 10;
        crabVel = 0;
        crabGrav = 0.6;
        crabJump = - 20;
        loadSprite();
    }

    private void loadSprite() { 
        
        ImageIcon cs = new ImageIcon(getClass().getResource("/un14/oop/images/crabSprite.png"));
        crabSprite = cs.getImage(); 
    }
    //here is where the movement happens. 
    public void move() { 
        crabVel += crabGrav; //This is updating the velocity with the gravity making the crab "fall realitically" and i can control how floaty it feels to jump and fall. 
        crabY += crabVel; //to update the position of the crab while falling.
        if(crabY > 575){ //this is "my floor" is how i keep the crab in the same positon while also stopping it from falling outside the board. I use ">" instead of = because its not precise. So it never fully lands on the same position, making the character just freeze in place.
            crabY = 575;
            crabVel = 0;
        }
    }
//My getters! to return the position and sprite to the CrabGame class.
    public int getCrabX() {
        
        return crabX;
    }

    public int getCrabY() {
        
        return crabY;
    }  

    public Image getImage() {
        
        return crabSprite;
    }
//To keep this part short, is jsut the inpu and the "stop" telling the crab to not be able to jump unless is on the "floor" to stop consecutive jumps and making the crab just fly.
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            if(crabY >= 575){
                crabVel = crabJump;
            }
        }

    }

}
