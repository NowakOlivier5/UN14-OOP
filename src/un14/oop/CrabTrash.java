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
    private int crabBoardW, crabBoardH;
    private Random crabRandom;
    private ArrayList<Trash> trashArray;
    
    public CrabTrash(int crabBoardW, int crabBoardH) {
        this.crabBoardW = crabBoardW;
        this.crabBoardH = crabBoardH;
        trashArray = new ArrayList<>();
        crabRandom = new Random();
    }

    public void spawningTrash(){
        boolean doubleTrash = crabRandom.nextInt(100) < 30;
        
        trashArray.add(new Trash(crabBoardW, crabBoardH));
        
        if (doubleTrash){
            Trash topTrash = new Trash(crabBoardW, crabBoardH);
            topTrash.y -= 90;
            trashArray.add(topTrash);
        }
    }
    public void trashPos(){
        for(int i = trashArray.size() - 1; i >= 0; i--){
            Trash ct = trashArray.get(i);
            ct.trashMove();
        }
    }
    public void drawTrash(Graphics g, Component c){
        for(Trash ct: trashArray){
            g.drawImage(ct.trashSprite, ct.x, ct.y, ct.trashW, ct.trashH, c);
        }
    }
    public boolean crabDeath(CrabSprite cs){
        int crabX = cs.getCrabX();
        int crabY = cs.getCrabY();
        int crabW = 90;
        int crabH = 90;
        
        for(Trash ct : trashArray){
            if (crabX < ct.x + ct.trashW && crabX + crabW > ct.x && crabY < ct.y + ct.trashH && crabY + crabH > ct.y){
                return true;
            }
        }
        return false;  
    }
    
    public static class Trash{
        int x, y;
        public int trashW = 100;
        public int trashH = 100;
        Image trashSprite;
        
        public Trash(int crabBoardW, int crabBoardH){
            x = crabBoardW;
            
            y = crabBoardH - trashH - 25;
            
            ImageIcon ts = new ImageIcon(Trash.class.getResource("/un14/oop/images/crabTrash.png"));
            trashSprite =ts.getImage();
            
        }
        public void trashMove(){
            x -= 6;
        }
        
    }
}
