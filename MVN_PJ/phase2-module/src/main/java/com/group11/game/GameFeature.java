/**
 * Class GameFeature
 * 
 * Purpose: acts as architecture for potato, acorn class
 * 
 */
package game;
import game.*;

public class GameFeature{
    /**
     * private attributes that define GameFeature
     * 
     * feat_id determines what attribute it is
     */
    private int feat_id;
    private boolean tf_acorn;
    private int x_pos;
    private int y_pos;
    /**
     * Constructor 1:
     * Uses
     * @param feat_id - what feature it is
     * @param x_pos - x-coordinate
     * @param y_pos - y-coordinate
     * 
     * To generate GameFeature on Map
     */
    public GameFeature(int feat_id, int x_pos, int y_pos){
        this.feat_id = feat_id;
        this.x_pos = x_pos;
        this.y_pos = y_pos;

        if(feat_id == 0){
            tf_acorn = FALSE;
        }
        else{
            tf_acorn = TRUE;
        }
    }
    /** 
     * Constrcutor 2:
     * Similar to Con 1, 
     * However:
     * @param feat_id - to determine GameFeature
     * 
     * is only used so it can be randomly generated
     */
    public GameFeature(int feat_id){
        this.feat_id = feat_id;

        if(feat_id == 0){
            tf_acorn = FALSE;
        }
        else{
            tf_acorn = TRUE;
        }
    }

    public abstract rand_generate();

    public abstract generate(int x_pos, int y_pos);

    public void cleanup(){
        this.feat_id = null;
        this.x_pos = null;
        this.y_pos = null;
    }

}