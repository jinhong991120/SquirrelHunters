package com.group11.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PotatoTest {

    private Items potato;

    @BeforeEach
    public void setup(){
        potato = new Potato();
    }

    @Test // integration testing
    public void imageTest(){
        assertNotNull(potato.image);
    }

    @Test
    public void nameTest(){
        assertEquals(potato.name, "Potato");
    }

    @Test
    public void scoreTest(){
        assertEquals(100, potato.score);
    }

    @Test
    public void collisionTest(){assertTrue(potato.collision);}
}
