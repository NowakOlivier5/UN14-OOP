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
    private final int crabBoardW;
    private final int crabBoardH;
    private final Random crabRandom;
    private final ArrayList<Trash> trashArray; //This array will generate new trash
    
    //The position in the board is important, cause makes the trash spawn outside the board and makes it stay on "ground level"
    public CrabTrash(int crabBoardW, int crabBoardH) {
        this.crabBoardW = crabBoardW;
        this.crabBoardH = crabBoardH;
        trashArray = new ArrayList<>();
        crabRandom = new Random();
    }

    public void spawningTrash(){
        boolean doubleTrash = crabRandom.nextInt(100) < 30; //This is saying that on those 100 numbers it makes, if its the numbers bellow the ones less than 30 then it spawns a double trash. THis way adds more to the challenge, I tried doing it with less but the game becomes way more easy. I would even try a bit harder by putting it on 35 or 40, but i dont want to make the game hard to try.
        
        trashArray.add(new Trash(crabBoardW, crabBoardH));//Spawns my normal trash
        
        if (doubleTrash){ //Spawns and adds it in to the array the trash on top, 90 pixels above the other one.
            Trash topTrash = new Trash(crabBoardW, crabBoardH);
            topTrash.y -= 90;
            trashArray.add(topTrash);
        }
    }
    //This loops through the array "backwards". When the trash is spawned puts it in the array and slides it through the screen. Once is off screen it removes it (if i didnt after a while you could notice the game slowing down a bit)It also adds a point if the crab doesnt touch the trash. 
    public int trashPos(){
        int crabPoints = 0;
        for(var i = trashArray.size() - 1; 0 < i; i--){
            Trash ct = trashArray.get(i);
            ct.trashMove();
            
            if (ct.x + ct.trashW<0){
                crabPoints++;
                trashArray.remove(i);
            }
        }
        return crabPoints;
    }
    //The trash gets drawn here on the propper positon
    public void drawTrash(Graphics g, Component c){
        for(Trash ct: trashArray){
            g.drawImage(ct.trashSprite, ct.x, ct.y, ct.trashW, ct.trashH, c);
        }
    }
    //My collision detection. To not make it a long explanation, it makes sure that the trash size and position is not touching/sharing the same location of the crab size and position. This way if they collide it returns the corresponding boolean value. The crab width and height is not the same as the propper crab sprite, if i did the "hit box" of the crab was too big making it easy to loose.
    public boolean crabDeath(CrabSprite cs){
        int crabX = cs.getCrabX();
        int crabY = cs.getCrabY();
        int crabW = 120;
        int crabH = 90;
        
        for(Trash ct : trashArray){
            if (crabX < ct.x + ct.trashW && crabX + crabW > ct.x && crabY < ct.y + ct.trashH && crabY + crabH > ct.y){
                return true;
            }
        }
        return false;  
    }
    
    //This is the class that has the size and position of every trash. It loads the sprite of the trashbag and i also set the speed of the trash when moving to the left.
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
