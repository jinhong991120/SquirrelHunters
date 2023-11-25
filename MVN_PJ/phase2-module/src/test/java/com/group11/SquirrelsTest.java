package com.group11;

import com.group11.game.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class SquirrelsTest {

    private GamePanel gp;
    private KeyHandler key;
    private Squirrels squirrels;


    @BeforeEach
    public void setup(){
        gp = new GamePanel();
        key = new KeyHandler(gp);
        squirrels = new Squirrels(gp, key);

        //set default
        squirrels.xPosition = 7 * gp.tileSize ;
        squirrels.yPosition = 1 * gp.tileSize;

        squirrels.heart = 3;
        squirrels.score = 0;
    }


    @Test
    void restoreHealthAndScore() {
        squirrels.restoreHealthAndScore();

        // Test that health, score, and other related values are restored correctly
        assertEquals(3, squirrels.heart);
        assertEquals(0, squirrels.score);
        assertFalse(squirrels.invincible);
        assertEquals(0, squirrels.numCollected);
    }

    @Test
    void pickUpRewards() {
        squirrels.setDefault();
        Setter setter = new Setter(gp);
        setter.setObject();
        //touch acorn
        squirrels.pickUpRewards(0/1/2/3/4/5/6/7/8);
        assertEquals(100, squirrels.score);

        //touch orange
        squirrels.pickUpRewards(9);
        assertEquals(4, squirrels.speed);
    }
    @Test
    void pickUpPotato(){
        Setter setter = new Setter(gp);
        setter.setObject();
        squirrels.setDefault();
        squirrels.pickUpPotato(0/1/2);
        assertEquals(-100, squirrels.score);
    }

    @Test
    void collectAllChecker() {
        squirrels.setDefault();
        assertEquals(false, squirrels.collectAllChecker());
        squirrels.setNumCollected(9);
        assertEquals(true, squirrels.collectAllChecker());

    }

    @Test
    void testSpriteNum(){
        squirrels.setDefault();
        assertEquals(1, squirrels.getSprite() );
        squirrels.setSpriteNum(2);
        assertEquals(2, squirrels.getSprite());
    }


    @Test
    void update() {
        key = new KeyHandler(gp);
        squirrels.setDefault();
        squirrels.getNewDir();
        if(key.up){
            assertEquals("up",squirrels.getDir());
        } else if (key.down) {
            assertEquals("down",squirrels.getDir());
        } else if (key.left) {
            assertEquals("left",squirrels.getDir());
        } else if (key.right) {
            assertEquals("right",squirrels.getDir());
        }
    }

    @Test
    void moveChar() {
        squirrels.collisionOn = false;
        squirrels.xPosition = 2;
        squirrels.yPosition = 2;
        squirrels.speed = 2;

        squirrels.direction = "up" ;
        squirrels.moveChar();
        assertEquals(0, squirrels.yPosition);
        squirrels.direction = "down" ;
        squirrels.moveChar();
        assertEquals(2, squirrels.yPosition);
        squirrels.direction = "left" ;
        squirrels.moveChar();
        assertEquals(0, squirrels.xPosition);
        squirrels.direction = "right" ;
        squirrels.moveChar();
        assertEquals(2, squirrels.xPosition);

    }
}