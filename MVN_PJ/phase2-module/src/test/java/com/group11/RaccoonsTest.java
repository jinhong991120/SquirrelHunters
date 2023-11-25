package com.group11;

import com.group11.game.GamePanel;
import com.group11.game.Raccoons;
import com.group11.game.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaccoonsTest {

    private GamePanel gp;
    private Raccoons raccoons;


    @BeforeEach
    public void setup(){
        gp = new GamePanel();
        raccoons = new Raccoons(gp);
    }

    @Test
    public void testDefault(){
        Setter setter = new Setter(gp);
        setter.setRaccoon();

        assertEquals(35 * gp.tileSize, gp.raccoons[0].xPosition);
        assertEquals(9* gp.tileSize, gp.raccoons[0].yPosition);
        assertEquals(14* gp.tileSize, gp.raccoons[1].xPosition);
        assertEquals(18* gp.tileSize, gp.raccoons[1].yPosition);
        assertEquals(20* gp.tileSize, gp.raccoons[2].xPosition);
        assertEquals(5* gp.tileSize, gp.raccoons[2].yPosition);

    }

    @Test
    public void testSpeed(){
        assertEquals(2, raccoons.speed);
    }

    @Test
    void checkCollision() {
        raccoons.collisionOn = false;
        assertFalse(gp.cChecker.checkPlayer(raccoons));

    }

    @Test
    void testSpriteNum(){
        assertEquals(1, raccoons.getSprite());
        raccoons.setSpriteNum(2);
        assertEquals(2, raccoons.getSprite());
    }

    @Test
    void testDirection() {
        raccoons.direction = "up";
        assertEquals("up", raccoons.getDir());
        raccoons.direction = "down";
        assertEquals("down", raccoons.getDir());
        raccoons.direction = "left";
        assertEquals("left", raccoons.getDir());
        raccoons.direction = "right";
        assertEquals("right", raccoons.getDir());
    }


}