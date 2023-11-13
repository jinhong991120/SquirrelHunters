/**
 * Class for the orange class 
 * Images are placed here
 */
package com.group11.game;

/*
 * neccesary libraries for images
 */
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

public class Orange extends Items{
    /*
     * constructor for orange 
     * sets name to orange
     * assigns score to 200 
     * sets collision to true 
     * grabs image from folder for orange
     */
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

    /*
     * implementation of draw method 
     */
    public void draw(Graphics2D g2, GamePanel gp){
    
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }
}

