/**
 * 
 */
package com.group11;

import com.group11.game.GamePanel;
import com.group11.game.Stopwatch;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class StopwatchTest {

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

    /** 
     * Unit test for pause()
     * but the timer should be greater then 0 since it waited 10 
     */
    @Test 
    void testPause() throws InterruptedException { 

        stopwatch.start(); 

        Thread.sleep(10);
        long time = stopwatch.elapsed(); 
        assertTrue(time > 0); 

    }
    
}
