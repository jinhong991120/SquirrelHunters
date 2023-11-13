/**
 * Extends Items class for Potato.
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 * The Potato class represents a potato item in the game.
 * It extends the Items class and includes settings for the potato's name, image, collision, and score.
 */
public class Potato extends Items {

    /**
     * Constructor for Potato.
     * Sets the name to "Potato," loads the potato image, sets collision to true, and assigns a score of 100.
     */
    public Potato() {
        name = "Potato"; 
        
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/potato.png"));
        } catch(IOException i) {
            i.printStackTrace(); 
        }
        
        collision = true; 
        score = 100; 
    }

    /**
     * Implements the draw method for Potato.
     * Draws the potato image on the game panel.
     *
     * @param g2 Graphics2D object to draw on
     * @param gp GamePanel instance
     */
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }
}
