/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop.yaroslav;

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
import java.util.ArrayList;
import java.awt.Rectangle;

/**
 *
 * @author Yaroslav Kondaurov
 */
public class Shrimp extends JPanel implements ActionListener{
    private Image shrimpBackground;
    
    private ShrimpPlayer shrimpPlayer;
    private ShrimpTarget shrimpTarget;
    
    private Timer shrimpLoop;
    private Timer fallingTrashSpawner;
    
    private int shrimpPoints;
    
    // Start
    public Shrimp() {
        shrimpBoard();
    }
    
    // Load all resources and timers for the game
    private void shrimpBoard() {
        shrimpBackground = new ImageIcon(getClass().getResource("/un14/oop/images/shrimpBackground.png")).getImage();
        setFocusable(true);
        
        shrimpPlayer = new ShrimpPlayer();
        
        shrimpLoop = new Timer(16, this);
        shrimpLoop.start();
        
        shrimpTarget = new ShrimpTarget();
        fallingTrashSpawner = new Timer(2000, e-> {shrimpTarget.spawnTarget(getWidth());});
        fallingTrashSpawner.start();
        
        addKeyListener(new TAdapter());
    }
    
    // Detects if there was user input
    @Override
    public void actionPerformed(ActionEvent e) {
        // Insert actions
        shrimpPlayer.updatePlayer();
        shrimpTarget.updateTarget(getHeight());
        collisionChecker();
        repaint();
    }
    
    // Draws the main interface for what is shown in the game
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(shrimpBackground, 0, 0, getWidth(), getHeight(), this); // Loads the background
        
        // Calls all the draw functions for their respective sprites and their interactions
        drawShrimp(g); // The player
        drawProjectiles(g); // The punches the player throws out
        drawTargets(g); // The trash targets
        showScore(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    // Draws the shrimp player
    private void drawShrimp(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(shrimpPlayer.getImage(), shrimpPlayer.getPosX(), shrimpPlayer.getPosY(), 200, 100, this);
    }
    
    // Gets the arraylist of projectiles and iterates through the array and for each one,
    // draws its image. Each projectile has its own set of coords to be displayed in the correct position
    private void drawProjectiles(Graphics g) {
        for (ShrimpPunch.Projectile shrimpP : shrimpPlayer.getProjectiles()) {
            g.drawImage(shrimpP.getPImage(), shrimpP.getPosX(), shrimpP.getPosY(), 50, 50, this);
        }
    }
    
    // Similar to the drawProjectiles function with just a different arrayList, this
    // one being about trash instead
    private void drawTargets(Graphics g) {
        for (ShrimpTarget.Target trash : shrimpTarget.getTargets()) {
            g.drawImage(trash.getImage(), trash.getX(), trash.getY(), 150, 150, this);
        }
    }
    
    private void showScore(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Points: " + shrimpPoints, 50, 50);
    }
    
    // This function checks the collision
    private void collisionChecker() {
        ArrayList<ShrimpPunch.Projectile> projectiles = shrimpPlayer.getProjectiles();
        ArrayList<ShrimpTarget.Target> targets = shrimpTarget.getTargets();
        for (int i = 0; i < projectiles.size(); i++) {
            ShrimpPunch.Projectile sp = projectiles.get(i);
            Rectangle punchHitbox = new Rectangle(sp.getPosX(), sp.getPosY(), 50, 50);
            for (int j = 0; j < targets.size(); j++) {
                ShrimpTarget.Target st = targets.get(j);
                Rectangle targetHitbox = new Rectangle(st.getX(), st.getY(), 150, 150);
                if (punchHitbox.intersects(targetHitbox)) {
                    projectiles.remove(i);
                    targets.remove(j);
                    shrimpPoints += 1;
                    i--;
                    break;
                }
            }
        }
    }
    
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            shrimpPlayer.movePlayer(e);
            
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_SPACE) {
                shrimpPlayer.shoot();
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {
            shrimpPlayer.stopPlayer(e);
        }
    }
}
