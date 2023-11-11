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

    /**
     * The type of {@code Characters}, 0 for {@code Student} and 1 for {@code Raccoon}
     */
    public int type;

    public boolean collisionOn = false;

    public abstract void update();

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

    public abstract void draw(Graphics2D g2);
}
