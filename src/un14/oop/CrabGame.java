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
    
    private Timer timer;
    private CrabSprite crabSprite;
    private Image crabBackground;
    private final int delay = 10;
    
    public CrabGame(){
        crabBoard();
    }
    private void crabBoard(){
        setBackground(Color.BLACK);
        setFocusable(true);
        crabBackground = new ImageIcon(getClass().getResource("/images/crabBackground.jpg")).getImage();
        
        crabSprite = new CrabSprite();
        
        addKeyListener(new TAdapter());
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        g.drawImage(crabBackground, 0,0,getWidth(), getHeight(), this);
        
        drawCrab(g);
        Toolkit.getDefaultToolkit().sync();
    }
    private void drawCrab(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(crabSprite.getImage(), crabSprite.getX(), crabSprite.getY(),crabSprite.getHeight(), crabSprite.getWidth(), this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        jump();
    } 
    private void jump() {
        
        crabSprite.move();
        
        repaint();     
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
