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
 * @author Olivier Nowak
 */
public class Fishing extends JPanel implements ActionListener{
    private Timer fishingLoop;
    private Timer fishingTrashSpawner;
    private Timer fishingFishSpawner;
    private Image bg;
    private Image fishingBoat;
    private fishingHook fishingHook;
    private fishingTrash fishingTrash;
    private fishingFish fishingFish;
    
    public Fishing(){
        fishBoard();
    }
    
    private void fishBoard(){
        setBackground(new Color(163, 195, 255));
        setFocusable(true);
        
        bg = new ImageIcon(getClass().getResource("/un14/oop/images/fishingBG2.png")).getImage();
        fishingBoat = new ImageIcon(getClass().getResource("/un14/oop/images/fishingBoat.png")).getImage();
        fishingTrash = new fishingTrash(1280);
        fishingFish = new fishingFish();
        fishingHook = new fishingHook();
        
        addKeyListener(new TAdapter());
        
        fishingLoop = new Timer(16, this);
        fishingLoop.start();
        
        fishingTrashSpawner = new Timer(4500, e -> fishingTrash.spawningTrash());//the reason i made the intervals so different is so they dont line up, as it would be impossible to collect the trash while avoiding the fish
        fishingTrashSpawner.start();
        
        fishingFishSpawner = new Timer(6200, e -> fishingFish.spawningFish());
        fishingFishSpawner.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        fishingHook.move();
        fishingTrash.trashPos();
        fishingFish.fishPos();
        fishingTrash.checkCollision(fishingHook);
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawHook(g); //hook drawn first to be behind sky and boat
        g.drawImage(bg, WIDTH, HEIGHT, this);
        g.drawImage(fishingBoat, 620, 80, this);
        fishingTrash.drawTrash(g, this);

        Toolkit.getDefaultToolkit().sync();
        
    }
    private void drawHook(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(fishingHook.getImage(), fishingHook.getX(), fishingHook.getY(), this);
    }
    
     private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            fishingHook.keyPressed(e);
        }
    }  
}
