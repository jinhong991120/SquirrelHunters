package com.group11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetterTest {

  private GamePanel gp;
  private Setter setter;

  @BeforeEach
  public void setUp() {
    gp = new GamePanel(); // Create an instance of GamePanel for testing
    setter = new Setter(gp); // Create an instance of AssetSetter
  }

  @Test
  public void testSetObject() {
    setter.setObject(); // Call the setObject() method

    // Assert that the rewards array is properly updated
    assertEquals(gp.rewards[0].xPosition, 1 * gp.tileSize);
    assertEquals(gp.rewards[0].yPosition, 22 * gp.tileSize);
    assertEquals(gp.rewards[1].xPosition, 1 * gp.tileSize);
    assertEquals(gp.rewards[1].yPosition, 7 * gp.tileSize);
    assertEquals(gp.rewards[2].xPosition, 23 * gp.tileSize);
    assertEquals(gp.rewards[2].yPosition, 3 * gp.tileSize);
    assertEquals(gp.rewards[3].xPosition, 11 * gp.tileSize);
    assertEquals(gp.rewards[3].yPosition, 1 * gp.tileSize);
    assertEquals(gp.rewards[9].xPosition, 15 * gp.tileSize);
    assertEquals(gp.rewards[9].yPosition, 22 * gp.tileSize);

    // Assert that the potato array is properly updated
    assertEquals(gp.potato[0].xPosition, 5 * gp.tileSize);
    assertEquals(gp.potato[0].yPosition, 6 * gp.tileSize);
    assertEquals(gp.potato[1].xPosition, 12 * gp.tileSize);
    assertEquals(gp.potato[1].yPosition, 8 * gp.tileSize);
    assertEquals(gp.potato[2].xPosition, 30 * gp.tileSize);
    assertEquals(gp.potato[2].yPosition, 19 * gp.tileSize);
    assertEquals(gp.potato[3].xPosition, 36 * gp.tileSize);
    assertEquals(gp.potato[3].yPosition, 15 * gp.tileSize);

  }
}
