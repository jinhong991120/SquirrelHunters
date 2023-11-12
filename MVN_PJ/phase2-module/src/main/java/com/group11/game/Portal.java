/**
 * extends items class for portal
 * 
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;


public class Portal{
        /**
     * {@code Portal}'s X coordinate
     */
    protected int xPosition;

    /**
     * {@code Portal}'s X coordinate
     */
    protected int yPosition;
    /**
     * Check Collision
     */
    protected boolean collision;

    protected BufferedImage image;
    
    protected Rectangle solidArea = new Rectangle(39 * 32, 32, 16,16);
    public Portal() { 
         
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/portal.png")); 
        }catch(IOException i) {
            i.printStackTrace(); 
        }
        collision = true; 
    }

    public void draw(Graphics2D g2, GamePanel gp){
    
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);

    }
}
