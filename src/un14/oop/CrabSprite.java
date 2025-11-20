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

    private int x = 10;
    private final int y = 600;
    private int w = 100;
    private int h = 80;
    private int speedX;
    private Image crab;

    public CrabSprite() {

        loadSprite();
    }

    private void loadSprite() {
        
        ImageIcon cs = new ImageIcon("src/images/crab.png");
        crab = cs.getImage(); 
        
        w = crab.getWidth(null);
        h = crab.getHeight(null);
    }
    public void move() {
        
        x += speedX;
    }

    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image getImage() {
        
        return crab;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            speedX = -2;
        }

        if (key == KeyEvent.VK_RIGHT) {
            speedX = 2;
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            speedX = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            speedX = 0;
        }
    }
}
