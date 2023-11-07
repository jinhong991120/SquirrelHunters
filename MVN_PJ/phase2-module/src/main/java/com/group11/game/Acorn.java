/**
 * extends item class for Potato 
 */
package com.group11.game;

import java.io.IOException;

public class Acorn extends Items{
    public Acorn() {

        name = "Acorn"; 

        try {
            image = ImageIO.read()
        }catch(IOException e) {
            e.printStackTrace(); 
        }

        score += 10; 

        xPosition = 0;
        yPosition = 0; 

        }
    }
    
    // /** Random generation of Acorn */
    // public void rand_generate(){
        
    // }
    // /**Generates Acorn in specific spot */
    // public void generate(int x_pos, int y_pos){

    // }
    
//}