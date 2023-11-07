/**
 * 
 */
public class Tile{
    /** integer represents what type of Tile */
    private int TileType;
    /**Constructor */
    public Tile(int TileType){
        this.TileType=TileType;
    }
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