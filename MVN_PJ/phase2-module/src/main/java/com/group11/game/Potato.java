/**
 * extends item class for Potato 
 */
package com.group11.game;

public class Potato extends Items{
    public Potato() {

        name = "Potato"; 
        
        try {
            image = ImageIO.read()
        }catch(IOException i) {
            i.printStackTrace(); 
        }
        
        score += 10; 

        xPosition = 0;
        yPosition = 0; 


    }
    // /**Random generation of Acorn */
    // public void rand_generate(){

    // }
    // /**Generates Acorn in specific spot */
    // public void generate(int x_pos, int y_pos){

    // }

}