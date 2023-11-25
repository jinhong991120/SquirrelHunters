package com.group11;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group11.game.Portal;


import static org.junit.jupiter.api.Assertions.*;

public class PortalTest {
    
    private Portal portal;

    @BeforeEach
    public void setup(){
        portal = new Portal();
    }

    @Test 
    public void imageTest(){
        assertNotNull(portal.image);
    }

    @Test
    public void nameTest(){
        assertEquals(portal.name, "Portal");
    }

    @Test
    public void collisionTest(){
        assertTrue(portal.collision);
    }


}
