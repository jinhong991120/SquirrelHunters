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
            image = ImageIO.read(getClass().getResourceAsStream("directory")); 
        }catch(IOException i) {
            i.printStackTrace(); 
        }
        collision = true;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        int pos_x = 0; 
        int pos_y = 0;
    
        g2.drawImage(image, pos_x, pos_y, null);
    }
}

