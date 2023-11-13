/**
 * Class representing an Acorn item in the game.
 * This class extends the Items class and provides functionality specific to Acorn items.
 * Images for Acorn items are loaded and set in this class.
 */
package com.group11.game;

import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;

/**
 * The Acorn class extends the Items class and represents an Acorn item in the game.
 */
public class Acorn extends Items {

    /**
     * Constructor for the Acorn class.
     * Initializes the name to "Acorn", sets collision to true, and assigns a score of 100.
     */
    public Acorn() {
        name = "Acorn";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/UI_image/acorn.png"));
        } catch (IOException i) {
            i.printStackTrace();
        }
        collision = true;
        score = 100;
    }

    /**
     * Draws the Acorn image on the specified graphics context.
     *
     * @param g2 The Graphics2D object to draw on.
     * @param gp The GamePanel containing the Acorn.
     */
    public void draw(Graphics2D g2, GamePanel gp) {
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }
}
