/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
/**
 *
 * @author yaros
 */
public class ShrimpPlayer {
    // Variables
    private int playerPosX;
    private final int playerPosY;
    private int playerMove;
    private Image shrimpPlayer;
    
    // Constructor
    public ShrimpPlayer() {
        playerPosX = 500;
        playerPosY = 500;
        playerMove = 0;
        loadSprite();
    }
    
    // Gets the png image file and loads it
    private void loadSprite() {
        ImageIcon sp = new ImageIcon(getClass().getResource("/un14/oop/images/shrimp.png"));
        shrimpPlayer = sp.getImage();
    }
    
    public void updatePlayer() {
        playerPosX += playerMove;
    }
    
    public void movePlayer(KeyEvent direction) {
        int moveKey = direction.getKeyCode();
        if (moveKey == KeyEvent.VK_LEFT) {
            playerMove = -5;
        } else if (moveKey == KeyEvent.VK_RIGHT) {
            playerMove = 5;
        }
    }
    
    public void stopPlayer(KeyEvent direction) {
        int stopKey = direction.getKeyCode();
        if (stopKey == KeyEvent.VK_LEFT || stopKey == KeyEvent.VK_RIGHT) {
            playerMove = 0;
        }
    }
    
    // Getters
    public int getPosX() {
        return playerPosX;
    }
    public int getPosY() {
        return playerPosY;
    }
    public Image getImage() {
        return shrimpPlayer;
    }
}
