/**
 * extends items class for portal
 */
package com.group11.game;

public class Portal extends Items{
    public Portal() { 

        name = "Portal"; 

        try {
            image = ImageIO.read()
        }catch(IOException i) {
            i.printStackTrace(); 
        }

        score += 0; 

        xPosition = 0;
        yPosition = 0; 

    }

}
