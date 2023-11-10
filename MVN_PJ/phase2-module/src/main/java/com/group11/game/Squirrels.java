package com.group11.game;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * basic setting class for player(squirrel)
 */

public class Squirrels extends Characters {
    GamePanel gp;
    KeyHandler key;
    public int score= 0;
    public int acornCount = 0;
    public int health = 3;

    public Squirrels(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.key = key;

        solidArea = new Rectangle(0, 0, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefault();
        getSquirrelImage();

    }

    public void setDefault(){

        //still need something for get start position
        //xPosition=  ;
        //yPosition=  ;

        speed = 4;
        health = 3;
        score = 0;
        acornCount = 0;
        direction = "right";

    }

    private void getSquirrelImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/right2.png"));
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public void update(){
        checkHealth();

        if( key.up || key.down || key.left || key.right){
            getNewDir();
            collisionOn = false;
            gp.cChecker.checkTile(this);

            changeSprite();

            //still working on here

        }
    }

    private void checkHealth(){
        if(health == 0){
            //add the state:game over
        }
    }

    private void getNewDir(){
        if(key.up)
            direction = "up";
        else if (key.down)
            direction = "down";
        else if (key.left)
            direction = "left";
        else if (key.right)
            direction = "right";
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
        graphic2.drawImage(image,  gp.tileSize, gp.tileSize, null);
    }


}
