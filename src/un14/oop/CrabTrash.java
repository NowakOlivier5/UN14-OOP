/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

/**
 *CrabTrash.java
 * @author Lestat Alvarez Quintana Ordiz
 */
import java.awt.Image;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.util.Random;
import java.util.ArrayList;
public class CrabTrash {
    private int trashY, trashX;
    private Random crabRandom;
    private ArrayList<Trash> trashArray;
    
    public CrabTrash() {
        trashY = 600;
        trashX = 60;
        trashArray = new ArrayList<>();
    }

    public void spawningTrash(){
        trashArray.add(new Trash(120,120));
    }
    public void trashPos(){
        for(int i = trashArray.size() - 1; i >= 0; i--){
            Trash ct = trashArray.get(i);
            ct.trashMove();
        }
    }
    public void drawTrash(Graphics g, Component c){
        for(Trash ct: trashArray){
            g.drawImage(ct.trashSprite, ct.x, ct.y, ct.trashX, ct.trashY, c);
        }
    }
    public boolean crabDeath(CrabSprite cs){
        int crabX = cs.getCrabX();
        int crabY = cs.getCrabY();
        int crabW = 120;
        int crabH = 120;
        
        for(Trash ct : trashArray){
            if (crabX < ct.x + ct.trashX && crabX + crabW > ct.x && crabY < ct.y + ct.trashY && crabY + crabH > ct.y){
                return true;
            }
        }
        return false;  
    }
    public static class Trash{
        int x, y;
        Image trashSprite;
        
        public Trash(int trashY, int trashX){
            x = trashY + 10;
            y = new Random().nextInt(trashY - 100) + 50;
            
            ImageIcon ts = new ImageIcon(Trash.class.getResource("/images/crabTrash.png"));
            trashSprite =ts.getImage();
            
        }
        public void trashMove(){
            x -= 6;
        }
        
    }
    
    
}
