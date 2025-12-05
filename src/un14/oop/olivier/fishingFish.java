/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package un14.oop.olivier;

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

//this code is mostly the same as my fishingTrash, all i did was flip some variables and change sprites

public class fishingFish {
    private final int fishingBoardW;
    private final Random fishingRandomPos;
    private final ArrayList<Fish> fishArray;

    public fishingFish(int fishingBoardW) {
        this.fishingBoardW = fishingBoardW;
        fishArray = new ArrayList<>();
        fishingRandomPos = new Random();
    }
    
    
    public void spawningFish(){
        int randomY = (fishingRandomPos.nextInt(400)+200);
        fishArray.add(new Fish(fishingBoardW, randomY));
    }
    
    public void fishPos(){
        for(int i = fishArray.size() - 1; i >= 0; i--){
            Fish ft = fishArray.get(i);
            ft.fishMove();
        }
    }
    
    public void drawFish(Graphics g, Component c){
        for(fishingFish.Fish ft: fishArray){
            g.drawImage(ft.fishSprite, ft.x, ft.y, c);
        }
    }
    
    public void checkCollision(fishingHook hook) {
    for (int i = fishArray.size() - 1; i >= 0; i--) {
        Fish t = fishArray.get(i);

        if (hook.getBounds().intersects(t.getBounds())) {
            hook.changeScore(-1);
            fishArray.remove(i);
        }
        
    }
}

    
    public static class Fish{
        int x, y;
        public Random fishingRandomVariant = new Random();
        Image fishSprite;
        boolean variant;
        
        public Fish(int fishingBoardW, int randomY){
            x = -50;
            y = randomY;
            
            variant = fishingRandomVariant.nextInt(2) == 1;
            
            if(variant){
                ImageIcon ts = new ImageIcon(Fish.class.getResource("/un14/oop/images/fishingFish1.png"));
                fishSprite =ts.getImage();
            }else{
                ImageIcon ts = new ImageIcon(Fish.class.getResource("/un14/oop/images/fishingFish2.png"));
                fishSprite =ts.getImage();
            }
            
        }
        
        public java.awt.Rectangle getBounds(){
            int w = fishSprite.getWidth(null);
            int h = fishSprite.getHeight(null);
            
            return new java.awt.Rectangle(x, y, w, h);//makes the hitbox
        }

        public void fishMove(){
            x += 3;
        }
        
    }
}

