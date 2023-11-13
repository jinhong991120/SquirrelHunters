/**
 * Class for the potato class 
 * Images are placed here
 */
package com.group11.game;

/*
 * Neccesary libraries for tools 
 */
import java.io.IOException;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;


public class Acorn extends Items{

/*
 * Constructor an Acorn
 * Sets name to Acorn and collison true
 * assign score as 100
 */
public Acorn() {
    name = "Acorn"; 
    try {
        image = ImageIO.read(getClass().getResourceAsStream("/UI_image/acorn.png")); 
    }catch(IOException i) {
        i.printStackTrace(); 
    }
    collision = true;
    score = 100; 
}

    /*
     * Draws Acorn image
     */
    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);
    }


 }

    