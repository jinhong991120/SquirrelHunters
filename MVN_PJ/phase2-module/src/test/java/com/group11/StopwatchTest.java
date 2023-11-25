/**
 * 
 */
package com.group11.game;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StopwatchTest {

    private Stopwatch stopwatch;

    @BeforeEach
    void setUp() {
        stopwatch = new Stopwatch(); 
    }

    /**
     * Unit test for isRunning() 
     * should return true 
     */
    @Test
    void testRunning() {

        stopwatch.start(); 
        assertTrue(stopwatch.isRunning()); 

    }

    /**
     * Unit test for isPaused() 
     * should return true 
     */
    @Test
    void testPaused() {

        stopwatch.start(); 
        stopwatch.pause(); 
        assertTrue(stopwatch.isPaused()); 

    }

    
}
