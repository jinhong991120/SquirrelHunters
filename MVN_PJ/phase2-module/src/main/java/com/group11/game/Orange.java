/**
 * Class for the orange class 
 * Images are placed here
 */
package com.group11.game;

/*
 * Necessary libraries for images
 */
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 * The Orange class represents the orange item in the game.
 * It includes the image loading, name, collision, and score settings for the orange item.
 */
public class Orange extends Items {

    /**
     * Constructor for Orange.
     * Sets the name to Orange, assigns a score of 200, and sets collision to true.
     * Grabs the image for Orange from the folder.
     */
    public Orange() {
        name = "Orange"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/Orange.png")); 
        } catch(IOException i) {
            i.printStackTrace(); 
        }
        collision = true;
        score = 200; 
    }

    /**
     * Implementation of the draw method.
     * Draws the Orange image on the game panel.
     *
     * @param g2 Graphics2D object to draw on
     * @param gp GamePanel instance
     * Images are 16x16 pixels
     */
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }
}
