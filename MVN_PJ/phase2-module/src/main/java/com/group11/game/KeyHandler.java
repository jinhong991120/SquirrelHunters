package com.group11.game;

import java.awt.event.*;

/**
 * KeyHandler class -- interact with Squirrel - Keyboard input from player
 */
public class KeyHandler implements KeyListener {

    /**
     * target {@code GamePanel} 
     */
    protected GamePanel gp;

    /**
     * {@code Squirrel}'s direction (true - facing direction, false otherwise)
     */
    protected boolean up, down, right, left;

    /**
     * Constructor.
     * 
     * @param gp the target GamePanel
     */
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }


