package com.group11.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AcornTest{

    private Items acorn;

    @BeforeEach
    public void setup(){
        acorn = new Acorn();
    }

    @Test // integration testing
    public void imageTest(){
        assertNotNull(acorn.image);
    }

    @Test
    public void nameTest(){
        assertEquals(acorn.name, "Acorn");
    }

    @Test
    public void scoreTest(){
        assertEquals(100, acorn.score);
    }

    @Test
    public void collisionTest(){
        assertTrue(acorn.collision);
    }
}
