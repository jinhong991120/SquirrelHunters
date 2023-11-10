package com.group11.game;

import javax.swing.JPanel;

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
    protected final int screenHeight = tileSize * maxScreenRow;  
    
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
    
    /**
    * Main {@code Characters} which is the {@code Squirrel}
    */
    protected Squirrels Squirrels = new Squirrels(this, key);

    /**
    * {@code TileManger}
    */
    protected TileRepresenter tr = new TileRepresenter(this);
    
  
    
    /**
    * {@code Sound} to play music 
    */
    protected Sound sound = new Sound();

    /**
    * {@code UI} on screen
    */
    protected UI ui = new UI (this);
    

    protected Items Acorn[] = new Items[10];


    protected Items potato[] = new Items[10];

    /**
    * Path finder
    */
    protected Pathfinder pFinder = new Pathfinder(this);

    /**
    * Assset Setter
    */
    protected Setter setter = new Setter(this);

    /**
    * Enemy Raccoons {@code Characters}
    */
    protected Characters raccoons[] = new Characters[3];

    /**
    * {@code Portal} to exit after all rewards ({@code Acorn}) are collected
    */
    protected Portal portal = new Portal();

    /**
    * The Game {@code State}
    */
    protected State state;
