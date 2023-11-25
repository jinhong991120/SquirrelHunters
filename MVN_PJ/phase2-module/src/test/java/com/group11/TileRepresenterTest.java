package com.group11;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

//import java.io.IOException;

//import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.group11.game.GamePanel;
import com.group11.game.TileRepresenter;

public class TileRepresenterTest {
	
	private GamePanel gp;
	private TileRepresenter tr;
	private int[][] test_mapArr;

	@BeforeEach
	public void setup() {
		
		gp = new GamePanel();
		
		tr = new TileRepresenter(gp);
		
		test_mapArr_filler();
	}

	@Test
	public void TRnotNull() {
	
		assertNotNull(tr);
	}
	
	@Test
	public void TRtilesNotNull() {
		
		assertNotNull(tr.tiles[0]);
		assertNotNull(tr.tiles[1]);
		assertNotNull(tr.tiles[2]);
		assertNotNull(tr.tiles[3]);
	}
	
	@Test 
	public void MapArrNotNull() {
		
		assertNotNull(tr.mapArr);
	}
	
	@Test
	public void testmap() {
		for(int i = 0; i < 40; i++) {
			for(int j = 0; j < 24; j++) {
				assertEquals(test_mapArr[i][j], tr.mapArr[i][j]);
			}
		}
	}
	
	
	/** Method to fill in map information from text file to compare for test */
	public void test_mapArr_filler() {
		test_mapArr = new int[40][24];
	   try {
           InputStream is = getClass().getResourceAsStream("/mapFiles/mapInfo.txt");
           BufferedReader br = new BufferedReader(new InputStreamReader(is));

           int col = 0;
           int row = 0;

           while (col < 40 && row < 24) {
               String line = br.readLine();

               while (col < 40) {
                   String[] number = line.split(" ");
                   int num = Integer.parseInt(number[col]);
                   test_mapArr[col][row] = num;
                   col++;
               }

               if (col >= 40) {
                   col = 0;
                   row++;
               }
           }
           br.close();
       } catch (Exception e) {
           e.printStackTrace();
       }
	}
}
