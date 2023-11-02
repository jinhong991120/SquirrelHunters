/**
 * Wall class that implements the wall tiles 
 * 
 * Author: Jefferson Li 
 * 
 */

package game;

class Wall {

    /**
     * Private attributed 
     */
    private int length;
    private int pos_x1;
    private int pos_y1;
    private int pos_x2;
    private int pos_y2;
    private char dir;


    public Wall (int length, int pos_x1, int pos_y1, int pos_x2,int pos_y2, char dir ) {

        this.length = length;
        this.pos_x1 = pos_x1;
        this.pos_y1 = pos_y1;
        this.pos_x2 = pos_x2; 
        this.pos_y2 = pos_y2;
        this.dir = dir; 
        
    }
    
    public int getlength(){
        return length;
    }

    public int getpos_x1(){
        return pos_x1; 
    }

    public int getpos_x2(){
        return pos_x2; 
    }

    public int getpos_y1(){
        return pos_y1; 
    }

    public int getpos_y2(){
        return pos_y2; 
    }
    



}