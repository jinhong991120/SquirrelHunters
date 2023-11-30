/**
 * Extends Items class for Portal.
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

/**
 * The Portal class represents the exit portal in the game.
 * It extends the Items class and includes settings for the portal's image, position, and collision.
 */
public class Portal extends Items {

    /**
     * Portal's X coordinate.
     */
    protected int xPosition;

    /**
     * Portal's Y coordinate.
     */
    protected int yPosition;

    /**
     * Check Collision.
     */
    public boolean collision;

    /**
     * Image for the portal.
     */
    public BufferedImage image;

    /**
     * Solid area rectangle for collision.
     */
    protected Rectangle solidArea = new Rectangle(39 * 32, 32, 16, 16);

    /**
     * Default constructor for Portal.
     * Grabs the image for the portal from the folder and sets collision to true.
     */
    public Portal() { 

         name = "Portal"; 
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/portal.png")); 
        } catch(IOException i) {
            i.printStackTrace(); 
        }
        collision = true; 
    }

    /**
     * Draws the portal on the game panel.
     *
     * @param g2 Graphics2D object to draw on
     * @param gp GamePanel instance
     */
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }
}
