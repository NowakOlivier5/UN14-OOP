/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

/**
 *CrabGame.java
 * @author Lestat Alavarez Quintana Ordiz
 */
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

public class CrabGame extends JPanel implements ActionListener{
    
    private Timer crabLoop;
    private Timer trashSpawner;
    private CrabSprite crabSprite;
    private Image crabBackground;
    private CrabTrash crabTrash;
    private boolean crabDead = false;
    
    public CrabGame(){
        crabBoard();
    }
    
    private void crabBoard(){
        setBackground(Color.BLACK);
        setFocusable(true);
        
        crabBackground = new ImageIcon(getClass().getResource("/un14/oop/images/crabBackground.jpg")).getImage();
        
        crabSprite = new CrabSprite();
        crabTrash = new CrabTrash(1280, 720);
        
        addKeyListener(new TAdapter());
        
        crabLoop = new Timer(16, this);
        crabLoop.start();
        
        trashSpawner = new Timer(1500, e -> crabTrash.spawningTrash());
        trashSpawner.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (!crabDead){
            crabSprite.move();
            crabTrash.trashPos();
            
            if(crabTrash.crabDeath(crabSprite)){
                crabDead = true;
                trashSpawner.stop();
                crabLoop.stop();
            }
        }
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(crabBackground, 0,0,getWidth(), getHeight(), this);
     
        drawCrab(g);
        crabTrash.drawTrash(g, this);
        
        if(crabDead) {
            drawCrabDead(g);
        }
        
        Toolkit.getDefaultToolkit().sync();
    }
    private void drawCrab(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(crabSprite.getImage(), crabSprite.getCrabX(), crabSprite.getCrabY(), 130, 130, this);
    }
    
    private void drawCrabDead(Graphics g){
        g.setColor(Color.ORANGE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        g.drawString("THE CRAB GOT CAUGHT IN THE TRASH!",200, 300);
    }
     
     private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            crabSprite.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            crabSprite.keyPressed(e);
        }
    }   
}
