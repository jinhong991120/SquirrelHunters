package com.group11.game;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D; 
import java.awt.Color;
/**
 * The GamePanel class represents the main panel for a simple game.
 * It contains all the game logic and rendering, and handles user input.
 */
public class GamePanel extends JPanel implements Runnable{
    
    /**
     * The size of each tile (Deafult: 32)
     */
    protected final int tileSize = 32;

    /**
     * The number of columns (horizontal tiles) on the map (Deafult: 40)
     */
    protected final int maxScreenCol = 40;

    /**
     * The number of rows (vertical tiles) on the map (Deafult: 24)
     */
    protected final int maxScreenRow = 24;

    /**
     * Screen Width (Default: 1280 pixels)
     */
    protected final int screenWidth = tileSize * maxScreenCol;    

    /**
     * Screen Height (Default: 768 pixels)
     */
    protected final int screenHeight = tileSize * maxScreenRow;   // 768 pixels
    
    /**
     * Frames per Seconds (Deafult: 60)
     */
    protected final int FPS = 60;

    /**
     * Game {@code Thread}
     */
    protected Thread gameThread;
    
    /**
     * Collision Checker
     */
    protected CollisionChecker cChecker = new CollisionChecker(this);
    
    /**
     * {@code KeyHandler} to interact with keyboard inputs
     */
    protected KeyHandler key = new KeyHandler(this);
