package com.group11.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrangeTest {

    private Items orange;

    @BeforeEach
    public void setup(){
        orange = new Orange();
    }

    @Test // integration testing
    public void imageTest(){
        assertNotNull(orange.image);
    }

    @Test
    public void nameTest(){
        assertEquals(orange.name, "Orange");
    }

    @Test
    public void scoreTest(){
        assertEquals(200, orange.score);
    }

    @Test
    public void collisionTest(){
        assertTrue(orange.collision);
    }
}
