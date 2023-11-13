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

    /**
     * The X coordinate on the Screen of {@code Characters}
     */
    public int xPosition;
    /**
     * The Y coordinate on the Screen of {@code Characters}
     */
    public int yPosition;
    /**
     * The speed of {@code Characters}
     */
    public int speed;
    /**
     * Sprite Images for {@code Characters}'s movement
     */
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    /**
     * The Direction of {@code Characters}
     */
    public String direction;
    /**
     * The number representing for sprites
     */
    protected int spriteCounter = 0;
    /**
     * The number representing for sprites
     */
    protected int spriteNumber = 1;
    /**
     * Solid Area of {@code Characters} represented by {@code Ractangle}
     */
    public Rectangle solidArea;
    /**
     * The default solid area of {@code Characters}
     */
    public int solidAreaDefaultX, solidAreaDefaultY;
    /**
     * The option of invincible
     */
    public boolean invincible = false;
    /**
     * The counts of invincible
     */
    public int invincibleCounter = 0;

    /**
     * The type of {@code Characters}, 0 for {@code Student} and 1 for {@code Raccoon}
     */
    public int type;
    /**
     * The option for collision, deafult is {@code false}
     */
    public boolean collisionOn = false;
    /**
     * Updates characters.
     */
    public abstract void update();
    /**
     * Action lock counter
     */
    protected int actionLockCounter = 0;

    /**
     * Sets the actions of characters.
     */
    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter == 90) {

            Random random = new Random();
            int i = random.nextInt(100) + 1; // Picks num from 1-100

            if (i <= 25) direction = "up";
            if (i > 25 && i <= 50) direction = "down";
            if (i > 50 && i <= 75) direction = "left";
            if (i > 75 && i <= 100) direction = "right";

            actionLockCounter = 0;
        }
    }


    /**
     * Draw onto panel.
     *
     * @param g2 the Graphics2D object to draw on
     */
    public abstract void draw(Graphics2D g2);
}
