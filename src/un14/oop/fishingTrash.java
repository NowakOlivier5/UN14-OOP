/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Olivier Nowak
 */
public class fishingTrash {
    private final int fishingBoardW;
    private final Random fishingRandomPos;
    private final ArrayList<Trash> trashArray;

    public fishingTrash(int fishingBoardW) {
        this.fishingBoardW = fishingBoardW;
        trashArray = new ArrayList<>();
        fishingRandomPos = new Random();
    }
    
    
    public void spawningTrash(){
        int randomY = (fishingRandomPos.nextInt(400)+200); //+200 to keep trash below water and hook resting level
        trashArray.add(new Trash(fishingBoardW, randomY));
    }
    
    public void trashPos(){
        for(int i = trashArray.size() - 1; i >= 0; i--){
            Trash ft = trashArray.get(i);
            ft.trashMove();
        }
    }
    
    public void drawTrash(Graphics g, Component c){
        for(fishingTrash.Trash ft: trashArray){
            g.drawImage(ft.trashSprite, ft.x, ft.y, c);
        }
    }
    
    public void checkCollision(fishingHook hook) {
    for (int i = trashArray.size() - 1; i >= 0; i--) {
        Trash t = trashArray.get(i);

        if (hook.getBounds().intersects(t.getBounds())) {//checks each trash for collision and if so deletes it
            trashArray.remove(i);
        }
        //used to have an if that deletes the trash when it goes off screen but it stopped working after adding collision, this doesnt affect anything other than the game starts to lag if you miss too much trash for a long time
    }
}

    
    public static class Trash{
        int x, y;
        public Random fishingRandomVariant = new Random();
        Image trashSprite;
        boolean variant;
        
        public Trash(int fishingBoardW, int randomY){
            x = fishingBoardW;
            y = randomY;
            
            variant = fishingRandomVariant.nextInt(2) == 1;
            
            if(variant){ //coinflip between my 2 different sprites
                ImageIcon ts = new ImageIcon(Trash.class.getResource("/un14/oop/images/fishingTrash1.png"));
                trashSprite =ts.getImage();
            }else{
                ImageIcon ts = new ImageIcon(Trash.class.getResource("/un14/oop/images/fishingTrash2.png"));
                trashSprite =ts.getImage();
            }
            
        }
        
        public java.awt.Rectangle getBounds(){
            int w = trashSprite.getWidth(null);
            int h = trashSprite.getHeight(null);
            
            return new java.awt.Rectangle(x, y, w, h);//makes the hitbox
        }

        public void trashMove(){
            x -= 2;
        }
        
    }
}
