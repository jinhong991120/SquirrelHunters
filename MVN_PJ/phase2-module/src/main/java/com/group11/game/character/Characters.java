package com.group11.game.character;

import java.awt.image.BufferedImage;
import java.awt.Rectangle;

/**
 *Abstract character class for the moving entity(squirrel and racoon) in the game
 * including some general setting of the moving entity
 *
 * @author: zekai li (zekail)
 */

public abstract class Characters {
    public int xPosition;
    public int yPosition;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    protected int spriteCounter = 0;
    protected int spriteNumber = 1;

    public Rectangle solidArea = new Rectangle(0, 0, 32, 32);
    public int solidAreaDefaultX, solidAreaDefaultY;

    protected boolean collisionOn = false;

}
