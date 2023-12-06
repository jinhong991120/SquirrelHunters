package com.group11.game;

import io.IOException;
import javax.imageio.ImageIO;

public class TileSetter{

    /** Array of `Tile` objects representing different types of tiles. */
    public Tile[] tiles;


    public TileSetter(){
        tiles = new Tile[4];
        getTileImage;
    }

    /**
     * Gets and sets images for different tile types.
     */
    public void getTileImage() {
        tiles[0] = new Tile();
        tiles[1] = new Tile();
        tiles[2] = new Tile();
        tiles[3] = new Tile();

        try {
            tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/UI_image/tiles/tile_0001(1).png"));
            tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/UI_image/tiles/tile_0126.png"));
            tiles[1].collision = true;

            tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/UI_image/tiles/tile_0037.png"));
            tiles[2].collision = true;
            tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/UI_image/tiles/tile_0028.png"));
            tiles[3].collision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}