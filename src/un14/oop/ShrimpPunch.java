/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Yaroslav Kondaurov
 */
public class ShrimpPunch {
    // Declaring the array
    private ArrayList<Projectile> projectiles;
    
    // Constructor
    public ShrimpPunch() {
        projectiles = new ArrayList<>();
    }
    
    // When called, creates a new punch projectile with its own set of x and y coordinates and adds it to the array
    public void shoot(int x, int y) {
        projectiles.add(new Projectile(x, y));
    }
    
    // Updates the position of every shrimp projectile inside the arraylist
    // If a projectile is off screen(its y coordinate is less than 0), the object is removed from the arraylist
    public void updateProjectile() {
        for (int i = 0; i < projectiles.size(); i++) {
            Projectile p = projectiles.get(i);
            p.update(); // Calls the update function
            // Checks if the projectile is off screen(under a y threshold),
            // and checks for a true or false return
            if (p.isOffScreen()) {
                projectiles.remove(i);
                i--; // Iterates the i down by 1 to avoid indexing errors
            }
        }
    }
    
    // Getter
    public ArrayList<Projectile> getProjectiles() {
        return projectiles;
    }
    
    // A static class Projectile that contains information on each projectile
    public static final class Projectile {
        // Variables
        private int projectilePosX;
        private int projectilePosY;
        private int speed = 8;
        private Image projectileIcon;
        
        // Constructor
        public Projectile(int startX, int startY) {
            this.projectilePosX = startX;
            this.projectilePosY = startY;
            loadSprite();
        }
        
        public void loadSprite() {
            ImageIcon pp = new ImageIcon(getClass().getResource("/un14/oop/images/punch.png"));
            projectileIcon = pp.getImage();
        }
        
        // Updates the projectiles position using the speed value
        public void update() {
            projectilePosY -= speed;
        }
        
        // Returns either true or false based on the y position of the projectile being checked
        public boolean isOffScreen() {
            return projectilePosY < 0;
        }
        
        // Getters
        public int getPosX() {
            return projectilePosX;
        }
        public int getPosY() {
            return projectilePosY;
        }
        public Image getPImage() {
            return projectileIcon;
        }
    }
}
