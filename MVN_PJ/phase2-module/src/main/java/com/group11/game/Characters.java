package com.group11.game;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *Abstract character class for the moving entity(squirrel and racoon) in the game
 * including some general setting of the moving entity
 *
 */

public abstract class Characters {

    public int xPosition;
    public int yPosition;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public String direction;

    protected int spriteCounter = 0;
    protected int spriteNumber = 1;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;

    public boolean invincible = false;

    public int invincibleCounter = 0;

    public boolean collisionOn = false;

    public abstract void update();

    public abstract void draw(Graphics2D g2);
}
