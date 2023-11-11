/**
 * extends item class for Potato 
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class Potato extends Items{
    public Potato() {

        name = "Potato"; 
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("directory"));
        }catch(IOException i) {
            i.printStackTrace(); 
        }
        
        collision = true; 
        score = -100; 
    }

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }



}