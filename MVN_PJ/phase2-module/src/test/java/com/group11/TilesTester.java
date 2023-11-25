package com.group11;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.group11.game.*;



public class TilesTester {

		private Tile tile1;
		
		@BeforeEach
		public void setup() throws IOException {
			tile1 = new Tile();
			
			tile1.image = ImageIO.read(getClass().getResourceAsStream("/tiles/tile_0001(1).png"));
		}
		
		@Test
		public void TileCollisionNotNull() {
			assertNotNull(tile1.collision);
		}
		
		@Test
		public void TileCollisionFalse() {
			assertEquals(false, tile1.collision);
		}
		
		
		@Test
		public void TileImageSet() {
			
			assertNotNull(tile1.image);
		}
		
		
		
}
