/**
 * extends item class for Potato 
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class Potato extends Items{
    /*
     * constructor for potato 
     * sets name to potato
     * sets collision to true
     * sets score to 100
     */
    public Potato() {

        name = "Potato"; 
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/potato.png"));
        }catch(IOException i) {
            i.printStackTrace(); 
        }
        
        collision = true; 
        score = 100; 
    }

    /*
     * implements the draw method for potato 
     */

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }



}
