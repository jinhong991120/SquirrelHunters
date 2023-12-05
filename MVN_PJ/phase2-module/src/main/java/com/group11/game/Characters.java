package com.group11.game;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Abstract character class representing the moving entities (squirrel and raccoon) in the game.
 * This class includes general settings for the moving entities, such as position, speed, and sprites.
 */
public abstract class Characters {

    /**
     * The X coordinate on the screen for the Characters.
     */
    public int xPosition;

    /**
     * The Y coordinate on the screen for the Characters.
     */
    public int yPosition;

    /**
     * The speed of the Characters.
     */
    public int speed;

    /**
     * Sprite Images for the Characters' movement.
     */
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    /**
     * The direction of the Characters.
     */
    public String direction;

    /**
     * The number representing the sprite counter for the Characters.
     */
    protected int spriteCounter = 0;

    /**
     * The number representing the sprite number for the Characters.
     */
    protected int spriteNumber = 1;


    /**
     * get the change of sprite
     */
    protected void changeSprite(){
        spriteCounter++;

        if(spriteCounter>15){
            if (spriteNumber == 1){
                spriteNumber = 2;
            }

            else if(spriteNumber == 2){
                spriteNumber = 1;}

            spriteCounter = 0;
        }
    }

    /**
     * Solid Area of Characters represented by a Rectangle.
     */
    public Rectangle solidArea;

    /**
     * The default X coordinate of the solid area for Characters.
     */
    public int solidAreaDefaultX;

    /**
     * The default Y coordinate of the solid area for Characters.
     */
    public int solidAreaDefaultY;

    /**
     * The option of invincibility for Characters.
     */
    public boolean invincible = false;

    /**
     * The counter for the invincibility duration of Characters.
     */
    public int invincibleCounter = 0;

    /**
     * The type of Characters, 0 for Student and 1 for Raccoon.
     */
    public int type;

    /**
     * The option for collision, default is false.
     */
    public boolean collisionOn = false;

    /**
     * Updates characters.
     */
    public abstract void update();


    /**
     * Draws the Characters onto the panel.
     *
     * @param g2 the Graphics2D object to draw on.
     */
    public abstract void draw(Graphics2D g2);
}
