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
    private int crabY, crabGrav, crabVel, crabJump;
    private Image crabSprite;

    public CrabSprite() {
        crabY = 575;
        crabX = 10;
        crabVel = 0;
        crabGrav = 1;
        crabJump = - 28;
        loadSprite();
    }

    private void loadSprite() {
        
        ImageIcon cs = new ImageIcon(getClass().getResource("/un14/oop/images/crabSprite.png"));
        crabSprite = cs.getImage(); 
    }
    public void move() { 
        crabVel += crabGrav;
        crabY += crabVel;
        if(crabY > 575){
            crabY = 575;
            crabVel = 0;
        }
    }

    public int getCrabX() {
        
        return crabX;
    }

    public int getCrabY() {
        
        return crabY;
    }  

    public Image getImage() {
        
        return crabSprite;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            if(crabY >= 575){
                crabVel = crabJump;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        
    }
}
