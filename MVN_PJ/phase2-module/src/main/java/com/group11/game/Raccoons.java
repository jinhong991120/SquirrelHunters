package com.group11.game;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

/**
 * basic setting class for enemy(raccoon)
 */
public class Raccoons extends Characters {
    GamePanel gp;

    /**
     *for enemy(raccoons)
     *
     * @param gp for the gamepanel
     */
    public Raccoons(GamePanel gp){
        this.gp = gp;

        type = 1;
        speed = 2;
        solidAreaDefaultX = 5;
        solidAreaDefaultY = 16;
        solidArea = new Rectangle(solidAreaDefaultX, solidAreaDefaultY, 32, 32);
        direction = "down";

        getRaccoonImage();
    }

    /**
     * get the raccoon images with different directions
     */
    private void getRaccoonImage(){
        try{
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/n1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/n2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/s1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/s2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/w1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/w2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/e1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/UI_image/raccoon/e2.png")));
        }catch (IOException i){
            i.printStackTrace();
        }
    }


    /**
     * Triggers the pathfinding algorithm for the Raccoon.
     */
    public void setAction() {
        // Calculate the goal column and row for the Raccoon to move towards
        int goalCol = (gp.Squirrels.xPosition + gp.Squirrels.solidArea.x) / gp.tileSize;
        int goalRow = (gp.Squirrels.yPosition + gp.Squirrels.solidArea.y) / gp.tileSize;

        // Use the pathfinding algorithm to determine the shortest path to the goal
        searchPath(goalCol, goalRow);
    }

    /**
     * Searches for the shortest path to player.
     *
     * @param goalCol the goal column
     * @param goalRow the goal row
     */
    public void searchPath(int goalCol, int goalRow) {

        // Calculate the starting column and row for the Raccoon's position
        int startCol = (xPosition + solidArea.x)/gp.tileSize;
        int startRow = (yPosition + solidArea.y)/gp.tileSize;

        // Set the start and goal nodes for the pathfinding algorithm
        gp.pFinder.setNodes(startCol, startRow, goalCol, goalRow);

        // If a path to the goal was found, determine the Raccoon's direction and move it
        if(gp.pFinder.search() == true) {

            // Get the next column and row in the path
            int nextX = gp.pFinder.pathList.get(0).col * gp.tileSize;
            int nextY = gp.pFinder.pathList.get(0).row * gp.tileSize;

            // Determine the Raccoon's solid area positions
            int enLeftX = xPosition + solidArea.x;
            int enRightX = xPosition + solidArea.x + solidArea.width;
            int enTopY = yPosition + solidArea.y;
            int enBottomY = yPosition + solidArea.y + solidArea.height;

            // Determine the direction the Raccoon should move in based on its position and the next path node
            if (enTopY > nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "up";
            }
            else if (enTopY < nextY && enLeftX >= nextX && enRightX < nextX + gp.tileSize) {
                direction = "down";
            }
            else if (enTopY >= nextY && enBottomY <= nextY + gp.tileSize) {
                // Left or Right
                if (enLeftX > nextX) {
                    direction = "left";
                }
                if (enLeftX < nextX) {
                    direction = "right";
                }
            }
            else if (enTopY > nextY && enLeftX > nextX) {
                // Up or Left
                direction = "up";
                checkCollision();
                if(collisionOn == true) {
                    direction = "left";
                }
            }
            else if (enTopY > nextY && enLeftX < nextX) {
                // Up or Right
                direction = "up";
                checkCollision();
                if(collisionOn == true) {
                    direction = "right";
                }

            }
            else if (enTopY < nextY && enLeftX > nextX) {
                // Down or Left
                direction = "down";
                checkCollision();
                if(collisionOn == true) {
                    direction = "left";
                }
            }
            else if (enTopY < nextY && enLeftX < nextX) {
                // Down or Right
                direction = "down";
                checkCollision();
                if(collisionOn == true) {
                    direction = "right";
                }
            }
        }
    }

    /**
     * Damages player if raccoon contacts enemy.
     */
    public void checkCollision() {
        collisionOn = false;
        gp.cChecker.checkTile(this); // Check if the raccoon has collided with a tile
        gp.cChecker.checkObjects(this, false, gp.rewards); // Check if the raccoon has collided with any reward objects
        boolean touchPlayer = gp.cChecker.checkPlayer(this); // Check if the raccoon has collided with the player

        if (this.type == 1 && touchPlayer == true) {
            if (gp.Squirrels.invincible == false) {
                gp.Squirrels.heart -= 1;
                System.out.println("Enemy is hitting you!! Score: " + gp.Squirrels.score);
                gp.Squirrels.invincible = true;
            }
        }
    }


    /**
     * get the update position and else for the raccoons
     *
     */
    public void update(){

        setAction();

        checkCollision();

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

        changeSprite();
    }


    public String getDir(){
        return direction;
    }
    public void setSpriteNum(int spriteNum) {
        this.spriteNumber = spriteNum;
    }
    public int getSprite(){
        return spriteNumber;
    }
    /**
     *
     * @param graphic2 draw the image for raccoon
     */
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
        graphic2.drawImage(image, xPosition, yPosition, gp.tileSize, gp.tileSize, null);

    }
}
