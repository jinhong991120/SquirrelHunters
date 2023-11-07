/**
 * extends items class for orange
 */
package com.group11.game;

import java.io.IOException;

public class Orange extends Items{
    public Orange() {

        name = "Orange"; 

        try {
            image = ImageIO.read(); 
        }catch(IOException i) {
            i.printStackTrace(); 
        }

        score += 0; 

        xPosition = 0;
        yPosition = 0; 


    }
}

