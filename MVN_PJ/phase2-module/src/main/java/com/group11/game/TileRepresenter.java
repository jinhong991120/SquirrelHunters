/**
 * Purpose : Display Tiles and array of  Tiles
 */
package com.group11.game;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.io.Reader;
import java.io.InputStreamReader;

public class TileRepresenter {
    private GamePanel gp;
    private int[][] mapArr;
    private Tile[] tiles;

    public TileRepresenter(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[4];
        mapArr = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    /**
     * purpose : gets and sets images
     */
    public void getTileImage(){ 

          tiles[0] = new Tile();
          tiles[1] = new Tile();
          tiles[2] = new Tile();
          tiles[3] = new Tile();

          try {
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_001(1).png")) ;
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0028.png")) ;
			tiles[1].collision = true;
			
	        	tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0037.png")) ;
	        	tiles[2].collision = true;
	        	tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0126.png")) ;
	        	tiles[3].collision = true;
		} catch (IOException e) {
			
			e.printStackTrace();
		}


    }
    /** @result = tiles being drawn from attributes in tile class
     * 
     * mapArr members correspond to tiles[] members
     */
    public void draw(Graphics2D g2d){

        int pos_x = 0;
        int pos_y = 0;
        
        for(int i = 0; i < gp.maxScreenCol; i++){
            for(int j = 0; j < gp.maxScreenRow; j++){
            	
                g2d.drawImage(tiles[mapArr[i][j]].image, pos_x, pos_y, gp.maxScreenCol, gp.maxScreenRow, null );
                
                    pos_x+=gp.tileSize;
        }
        pos_y+=gp.tileSize;
        }
    }
    /** use when constructor is called to get map from text file */
    private void loadMap(){
       InputStream is = getClass().getResourceAsStream("directory + .txt");
       Reader rd = new InputStreamReader(is);
       BufferedReader br = new BufferedReader(rd);

       for(int r = 0; r<gp.maxScreenRow; r++){
            String line_r = null;
			try {
				line_r = br.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
			}

            for(int c = 0;c<gp.maxScreenCol;c++){
                String map_format[] = line_r.split(" ");
                int ind_tile = Integer.parseInt(map_format[c]);
                mapArr[c][r]=ind_tile;
            }

       }
           
    try {
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	}

    }
}
