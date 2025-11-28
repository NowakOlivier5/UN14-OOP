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
    private int crabY, crabGrav, crabJump;
    private Image crabSprite;

    public CrabSprite() {
        crabY = 600;
        crabX = 10;
        crabGrav = 1;
        loadSprite();
    }

    private void loadSprite() {
        
        ImageIcon cs = new ImageIcon(getClass().getResource("/images/crabSprite.png"));
        crabSprite = cs.getImage(); 
    }
    public void move() { 
        crabJump += crabGrav;
        crabY += crabJump;
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
            crabJump = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            crabJump = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            crabJump = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            crabJump = 0;
        }
    }
}
