/**
 * Purpose : Display Tiles and array of  Tiles
 */
package com.group11.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import java.awt.*;


public class TileRepresenter {
    public GamePanel gp;
    public int[][] mapArr;
    public Tile[] tiles;

    public TileRepresenter(GamePanel gp){
        this.gp = gp;
        tiles = new Tile[4];
        mapArr = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    
    private boolean drawPath = false;
    /**
     * purpose : gets and sets images
     */
    public void getTileImage(){ 

          tiles[0] = new Tile();
          tiles[1] = new Tile();
          tiles[2] = new Tile();
          tiles[3] = new Tile();

          try {
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0001(1).png")) ;
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0126.png")) ;
			tiles[1].collision = true;
			
	        	tiles[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0037.png")) ;
	        	tiles[2].collision = true;
	        	tiles[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0028.png")) ;
	        	tiles[3].collision = true;
		} catch (IOException e) {
			
			e.printStackTrace();
		}


    }
    /** @result = tiles being drawn from attributes in tile class
     * 
     * mapArr members correspond to tiles[] members
     */
    public void draw(Graphics2D g2){
        // put tiles on the panel
        int col = 0;
        int row = 0;   
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow){

            int tileNum = mapArr[col][row];

            g2.drawImage(tiles[tileNum].image, x,y, gp.tileSize, gp.tileSize, null);
            col++;
            x+=gp.tileSize;
            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y+= gp.tileSize;
            }
        }

        if (drawPath == true) {
            g2.setColor(new Color(255, 0, 0, 70));

            for (int i = 0; i < gp.pFinder.pathList.size(); i++) {

                int mapX = gp.pFinder.pathList.get(i).col * gp.tileSize;
                int mapY = gp.pFinder.pathList.get(i).row * gp.tileSize;

                g2.fillRect(mapX, mapY, 32, 32);

            }
        }
    }
    /** use when constructor is called to get map from text file */
    private void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/mapFiles/mapInfo.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine();

                while (col < gp.maxScreenCol){
                    String number[] = line.split(" ");

                    int num = Integer.parseInt(number[col]);
                    mapArr[col][row] = num;
                    col++;
                }
                if (col >= gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
