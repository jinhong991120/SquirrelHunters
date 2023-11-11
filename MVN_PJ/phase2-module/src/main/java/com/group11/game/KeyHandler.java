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
    protected boolean up, down, right, left, pause;

    /**
     * Constructor.
     *
     * @param gp the target GamePanel
     */
    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode){
            //up
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                up = true;
                break;
            //down
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                down = true;
                break;
            //left
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                left = true;
                break;
            //right
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                right = true;
                break;

            //pause
            case KeyEvent.VK_ESCAPE:
                if(!pause){
                    gp.state = State.Pause;
                }
                pause = true;

        }
    }

    /**
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            //up
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                up = false;
                break;
            //down
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                down = false;
                break;
            //left
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                left = false;
                break;
            //right
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                right = false;
                break;

            //pause
            case KeyEvent.VK_ESCAPE:
                pause = false;

        }
    }


}



