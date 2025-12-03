/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

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
/**
 *
 * @author Yaroslav
 */
public class Shrimp extends JPanel implements ActionListener{
    private Image shrimpBackground;
    private Image shrimpPunch;
    private Image shrimpTrash;
    
    private ShrimpPlayer shrimpPlayer;
    
    private Timer shrimpLoop;
    private Timer fallingTrashSpawner;
    
    // Start
    public Shrimp() {
        shrimpBoard();
    }
    
    // Load all resources and timers for the game
    private void shrimpBoard() {
        shrimpBackground = new ImageIcon(getClass().getResource("/un14/oop/images/shrimpBackground.png")).getImage();
        shrimpPlayer = new ShrimpPlayer();
    }
    
    // Take user input
    @Override
    public void actionPerformed(ActionEvent e) {
        // Insert actions
        //player.move();
    }
    
    // 
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(shrimpBackground, WIDTH, HEIGHT, this);
        
        drawShrimp(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawShrimp(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(shrimpPlayer.getImage(), shrimpPlayer.getPosX(), shrimpPlayer.getPosY(), 200, 100, this);
    }
}
