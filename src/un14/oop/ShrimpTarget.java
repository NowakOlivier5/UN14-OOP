/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author yaros
 */
// Fix this code up

public class ShrimpTarget {
    // Declaring the array
    private ArrayList<Target> targets;
    
    // Constructor
    public ShrimpTarget() {
        targets = new ArrayList<>();
    }
    
    // Called and given the width of the ui window. Furthur calls the Target function in the
    // static class, takes the data(x and y coords) and inserts it into the arraylist as a new object
    public void spawnTarget(int panelWidth) {
        targets.add(new Target(panelWidth));
    }
    
    // Similar to the ShrimpPunch update function
    public void updateTarget(int panelHeight) {
        for (int i = 0; i < targets.size(); i++) {
            Target t = targets.get(i);
            t.update();
            if (t.isOffScreen(panelHeight)) {
                targets.remove(i);
                i--;
            }
        }
    }
    
    public ArrayList<Target> getTargets() {
        return targets;
    }
    
    // A static class Target
    // Similar structure to the static class in ShrimpPunch.java
    public static final class Target {
        // Variables
        private int targetPosX;
        private int targetPosY;
        private int speed = 5;
        private Image trashIcon;
        
        public Target(int panelWidth) {
            this.targetPosX = (int)(Math.random() * (panelWidth - 50));
            this.targetPosY = -50;
            loadSprite();
        }
        
        public void loadSprite() {
            ImageIcon tt = new ImageIcon(getClass().getResource("/un14/oop/images/shrimpTrash1.png"));
            trashIcon = tt.getImage();
        }
        
        public void update() {
            targetPosY += speed;
        }
        
        public boolean isOffScreen(int panelHeight) {
            return targetPosY > panelHeight;
        }
        
        // Getters
        public int getX() {
            return targetPosX;
        }
        public int getY() {
            return targetPosY;
        }
        public Image getImage() {
            return trashIcon;
        }
    }
}
