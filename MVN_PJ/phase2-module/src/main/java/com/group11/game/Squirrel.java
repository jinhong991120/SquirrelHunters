/** SQUIRREL CLASS 
 * 
 * PURPOSE : IMPLEMENTS MAIN CHATACTER IN GAME
 * 
 * AUTHORS : BENJAMIN SCHOENING, ____ , ___ , ____ FROM GROUP 11
 * 
 * 
 */
package game;
import game.*;

class squirrel{
    /** User-defined name */
    private String name; 
    /** Position of Main Character at any given time */
    private int x_pos;
    private int y_pos;
    /** Score of game is derived from : acornCounter */
    private int acornCounter;
    /**Speed of player on a scale of 100 */
    private int speed;

    /** Constructor with 
     * @param name = name of squirrel
     * @param x_pos = x-coordinate
     * @param y_pos = y-coordinate
     */
    public Squirrel(String name, int x_pos, int y_pos){
        this.name = name;
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.acornCounter = 0;
        this.speed = 100;
    }

    /**
     * Method moves squirrel from
     * @param X in x-coordinates on map
     * @param Y in y-coordinates on map
     * 
     */
    public void move(int X, int Y){
        x_pos += X;
        y_pos += Y;
    }
    /**
     * Method where squirrel collects acorn
     */
    public void AcornCollected(){
        acornCounter++;
    }
    /**
     * Method if Squirrel collects potato
     * result: reduced speed and acorn
     */
    public void potato(){
        acornCounter--;
        speed--;
    }
    
    /**
     * Getters for private attributes :
     * name
     * acorncounter
     * x_pos
     * y_pos
     * speed
     */
    public String get_name(){
        return name;
    }
    public int get_acorns(){
        return acorn_counter;
    }
    public int get_x(){
        return x_pos;
    }
    public int get_y(){
        return y_pos;
    }
    public int get_speed(){
        return speed;
    }

    /**
     * Method cleanup 
     * 
     * aka
     * 
     * Death 
     */
    public void cleanup(){
        this.name = null;
        this.x_pos = null;
        this.y_pos = null;
        this.speed = null;
        this.acorn_counter = null;
    }

}