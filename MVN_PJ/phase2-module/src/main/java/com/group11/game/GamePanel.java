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
    * The size of each tile (Default: 32)
    */
    protected final int tileSize = 32;

    /**
    * The number of columns (horizontal tiles) on the map (Default: 40)
    */
    protected final int maxScreenCol = 40;

    /**
    * The number of rows (vertical tiles) on the map (Default: 24)
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
    * Frames per Second (Default: 60)
    */
    protected final int FPS = 60;

    /**
    * Game Thread
    */
    protected Thread gameThread;
    
    /**
    * Collision Checker
    */
    protected CollisionChecker cChecker = new CollisionChecker(this);
    
    /**
    * KeyHandler to interact with keyboard inputs
    */
    protected KeyHandler key = new KeyHandler(this);
    
    /**
    * Main Characters which is the Squirrel
    */
    protected Squirrels Squirrels = new Squirrels(this, key);

    /**
    * Tile Representer
    */
    protected TileRepresenter tr = new TileRepresenter(this);
    
    /**
    * Sound to play music 
    */
    protected Sound sound = new Sound();

    /**
    * UI on screen
    */
    protected UI ui = new UI (this);
    

    protected Items rewards[] = new Items[10];


    protected Items potato[] = new Items[10];

    /**
    * Path finder
    */
    protected PathFinder pFinder = new PathFinder(this);

    /**
    * Asset Setter
    */
    protected Setter setter = new Setter(this);

    /**
    * Enemy Raccoons Characters
    */
    protected Characters raccoons[] = new Characters[3];

    /**
    * Portal to exit after all rewards (Acorn) are collected
    */
    protected Portal portal = new Portal();

    /**
    * The Game State
    */
    protected State state;
    
    /**
     * Default Constructor. Creates GamePanel 
     */
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // setup size
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true); // let GamePanel focus to receive key input
        this.state = State.Title;
    }

    /**
     * Setting up the items and enemies locations on the panel.
     */
    public void setupGame(){
        setter.setObject();
        setter.setRaccoon();
        state = State.Title;
        playMusic(1);
    }

    /**
     * Let Thread start the game.
     */
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Resets the character's positions and values.
     */
    public void retry() {
        Squirrels.setDefault();
        Squirrels.restoreHealthAndScore();
        setter.setObject();
        setter.setRaccoon();
    }

    @Override
    public void run() {

        // game loop
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
    
        while (gameThread != null){

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1){
                this.update();
                this.repaint();
                delta--;
            }
        }
    }

    /**
     * Updates the characters.
     */
    public void update(){
        if(state == State.Game) {
            // PLAYER
            Squirrels.update();

            //ENEMIES
            for (int i = 0; i < raccoons.length; i++) {
                if (raccoons[i] != null) {
                    raccoons[i].update();
                }
            }
        }
    }

    /**
     * Draws the components on the panel.
     *
     * @param g Graphic 
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if (state == State.Title)
        {
            ui.draw(g2);
        }
        else {
            //TITLE
            tr.draw(g2);

            // rewards and portal 
            for (int i = 0; i < rewards.length; i++){
                if (rewards[i] != null)
                    rewards[i].draw(g2, this);
                
                // create portal if coffees are all collected
                if (Squirrels.collectAllChecker()){
                    portal.xPosition = 38 * this.tileSize;
                    portal.yPosition = 1 * this.tileSize;
                    portal.draw(g2, this);
                }
            }

            //Potatoes
            for (int i = 0; i < rewards.length; i++){
                if (potato[i] != null)
                potato[i].draw(g2, this);
            }
            
            //ENEMIES
            for(int i = 0; i < raccoons.length; i++) {
                if (raccoons[i] != null)
                    raccoons[i].draw(g2);
            }

            //UI
            ui.draw(g2);
            
            //PLAYER
            Squirrels.draw(g2);
        }
        g2.dispose();   // dispose of this graphics contxt and release any system resources that it is using  
    }
    
    /**
     * Play the music
     *
     * @param i index number of target music stream
    */
    public void playMusic(int i)
     {
         sound.setFile(i);
         sound.play();
         sound.loop();
     }
    
   
    //  * Stop the music
    //  */
     public void stopMusic()
     {
         sound.stop();
     }
    
    
}
