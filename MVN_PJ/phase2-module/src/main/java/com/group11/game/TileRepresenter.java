/**
 * Purpose : Display Tiles and array of  Tiles
 */
package com.group11.game;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.Arrays;
import java.io.Scanner;

class TileRepresenter{

    private GamePanel gp;
    private int[][] mapArr;
    private Tile[] tiles;

    public TileRepresenter(GamePanel gp){
        this.gp = gp;
        tiles = new ArrayList<Tile>();
        mapArr = int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap();
    }

    /**
     * purpose : gets and sets images
     */
    public void getTileImage(){ 

          tiles[0] = new tile();
          tiles[1] = new tile();
          tiles[2] = new tile();

          tiles[0].image = imageIO.read(getClass().getResourceAsStream("directory")) ;
          tiles[1].image = imageIO.read(getClass().getResourceAsStream("directory")) ;
          tiles[2].image = imageIO.read(getClass().getResourceAsStream("directory")) ;


    }
    /** @result = tiles being drawn from attributes in tile class */
    public void draw(Graphics2D g2d){

        int pos_x, pos_y = 0;
        
        for(int i = 0; i < mapArr.length(); i++){
            for(int j = 0; j < mapArr[].length(); j++){

                if(mapArr[i][j] == 0){
                    g2d.drawimage(tiles[0].image, pos_x, pos_y, gp.maxScreenCol, gp.maxScreenRow, null );
                }
                else if(mapArr == 1){
                    g2d.drawimage(tiles[1].image, pos_x, pos_y, gp.maxScreenCol, gp.maxScreenRow, null );
                }
                else {
                    g2d.drawimage(tiles[2].image, pos_x, pos_y, gp.maxScreenCol, gp.maxScreenRow, null );
                }

                pos_x+=gp.tileSize;
        }
        pos_y+=gp.tileSize;
        }
    }
    /** use when constructor is called to get map from text file */
    private void loadMap(){
        String map = new File("Path to text file");
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(map)));

        while(scanner.hasNextLine()){
            for(int i = 0; i<maxScreenCol; i++){
                String[] temp = scanner.nextLine().trim().split(" ");
                for(int h = 0; h<temp.length; h++){
                    mapArr[i][h] = Integer.parseInt(temp[h]);
                }
            }
        }
           

    }

    



}