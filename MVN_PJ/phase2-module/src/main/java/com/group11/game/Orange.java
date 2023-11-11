/**
 * extends items class for orange
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class Orange extends Items{
    public Orange() {
        name = "Orange"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/Orange.png")); 
        }catch(IOException i) {
            i.printStackTrace(); 
        }
        collision = true;
        score = 200; 
    }

    public void draw(Graphics2D g2, GamePanel gp){
    
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }
}

