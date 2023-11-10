package com.group11.game;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * basic setting class for enemy(raccoon)
 */
public class Raccoons extends Characters {
    GamePanel gp;

    public Raccoons(GamePanel gp){
        this.gp = gp;

        speed = 2;
        solidAreaDefaultX = 16;
        solidAreaDefaultY = 16;
        solidArea = new Rectangle(solidAreaDefaultX, solidAreaDefaultY, 32, 32);
        direction = "right";

        getRaccoonImage();
    }

    private void getRaccoonImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/raccoon/n1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/raccoon/n2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/raccoon/s1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/raccoon/s2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/raccoon/w1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/raccoon/w2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/raccoon/e1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/raccoon/e2.png"));
        }catch (IOException i){
            i.printStackTrace();
        }
    }


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

    public void update(){

        setAction();
        collisionOn = false;
        gp.cChecker.checkPlayer(this);

        //still working here

        changeSprite();
    }

    private void changeSprite(){
        spriteCounter++;

        if(spriteCounter>10){
            if (spriteNumber == 1)
                spriteNumber = 2;
            else
                spriteNumber = 1;
        }

        spriteCounter = 0;
    }



    public void draw(Graphics2D graphic2) {
        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNumber == 1) {
                    image = up1;
                }
                else {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNumber == 1) {
                    image = down1;
                }
                else {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNumber == 1) {
                    image = left1;
                }
                else {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNumber == 1) {
                    image = right1;
                }
                else {
                    image = right2;
                }
        }
        graphic2.drawImage(image, gp.tileSize, gp.tileSize, null);

    }
}
