/**
 * 
 */
import game.*;/
package game;

public class Tile{
    /** Attributes of Tile to help represent the map */
    public int TileType;
    public boolean collision;
    public BufferedImage image;

    /** @return int representing TileType */
    public int getTT(){
        return TileType;
    }
    
    /** @param int for type of tile that is being changed
     * @return int for the new Tile
     */
    public void setTT(int TileType){
        this.TileType=TileType;
    }
}