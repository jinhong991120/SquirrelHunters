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
    public int numCollected = 0;
    public int heart = 3;

    public Squirrels(GamePanel gp, KeyHandler key){
        this.gp = gp;
        this.key = key;

        solidArea = new Rectangle(8, 16, 32, 32);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefault();
        getSquirrelImage();

    }

    public void setDefault(){

        xPosition = 7 * gp.tileSize ;
        yPosition = 1 * gp.tileSize;

        speed = 2;
        heart = 3;
        score = 0;
        numCollected = 0;
        direction = "down";

    }

    public void restoreHealthAndScore() {
        heart = 3;
        score = 0;
        invincible = false;
        numCollected = 0;
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

    /**
     * Increases score when picking up items.
     *
     * @param index index of the item on rewards array
     */
    public void pickUpRewards(int index){
        if (index != -1){
            score += gp.rewards[index].score;

            // Double the speed if Orange is collected
            if (gp.rewards[index].name == "Orange")
                speed *= 2;
            else{
                numCollected++;
            }
            gp.rewards[index] = null;
        }
    }
    /**
     * Decreases score when picking up items.
     *
     * @param index index of the item on potato array
     */
    public void pickUpPotato(int index){
        if (index != -1){
            score -= gp.potato[index].score;
            gp.potato[index] = null;
            if (speed > 1) speed -= 1;
        }
    }
    /**
     * Decreases player's health when it contacts and enemy.
     *
     * @param index index of the item on items array
     */
    public void interactEnemy(int index){
        if (index != -1){
            if (invincible == false) {
                heart -= 1;
                invincible = true;
            }
        }
    }

    /**
     * Checks if all the rewards are collected.
     *
     * @return true if all rewards are collected, false otherwise
     */
    public boolean collectAllChecker(){
        if (numCollected == 9){
            return true;
        }
        return false;
    }
    public void update(){

        if( key.up || key.down || key.left || key.right) {
            getNewDir();
            //check collision
            collisionOn = false;
            gp.cChecker.checkTile(this);

            // Rewards collision
            int rewardIndex = gp.cChecker.checkObjects(this, true, gp.rewards);
            pickUpRewards(rewardIndex);

            // potato collision
            int potatoIndex = gp.cChecker.checkObjects(this, true, gp.potato);
            pickUpPotato(potatoIndex);

            // Enemy collision
            int enemyIndex = gp.cChecker.checkEntity(this);
            interactEnemy(enemyIndex);

            if (collectAllChecker()){
                gp.cChecker.checkPortal(this, true, gp.portal);
            }
            moveChar();
            changeSprite();
        }

        checkAlive();

        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 60) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
    }

    private void checkAlive(){
        if(heart <= 0 || score < 0){
            //add the state:game over
            gp.state = State.Over;
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

    public void moveChar(){
        if (collisionOn == false){
            switch(direction){
                case "up": yPosition -= speed;
                    break;
                case "down": yPosition += speed;
                    break;
                case "right": xPosition += speed;
                    break;
                case "left": xPosition -= speed;
                    break;
            }
        }
    }
    private void changeSprite(){
        spriteCounter++;

        if(spriteCounter>15){
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

        // Visualizes that damage was taken
        if (invincible == true) {
            graphic2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        }

        graphic2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);

        graphic2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

    }


}
