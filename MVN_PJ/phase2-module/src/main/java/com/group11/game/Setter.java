package com.group11.game;

/**
 * Setter class for setting items and raccoons onto GamePanel.
 */
public class Setter {

  /**
   * The target {@code GamePanel}.
   */
  private GamePanel gp;

  /**
   * Constructor.
   *
   * @param gp Game panel to be updated
   */
  public Setter(GamePanel gp) {
    this.gp = gp;
  }

  /**
   * Sets the items' locations.
   */
  public void setObject() {

    // Acorns
    int XPositions[] = {1, 1, 23, 11, 8, 35, 36, 13, 24};
    int YPositions[] = {22, 7, 3, 1, 13, 16, 12, 14, 11};

    for (int i = 0; i < 9; i++) {
      gp.rewards[i] = new Acorn();
      gp.rewards[i].xPosition = XPositions[i] * gp.tileSize;
      gp.rewards[i].yPosition = YPositions[i] * gp.tileSize;
    }

    // Orange
    gp.rewards[9] = new Orange();
    gp.rewards[9].xPosition = 15 * gp.tileSize;
    gp.rewards[9].yPosition = 22 * gp.tileSize;

    // Potatoes
    int XPositions2[] = {5, 12, 30, 36};
    int YPositions2[] = {6, 8, 19, 15};

    for (int i = 0; i < 3; i++) {
      gp.potato[i] = new Potato();
      gp.potato[i].xPosition = XPositions2[i] * gp.tileSize;
      gp.potato[i].yPosition = YPositions2[i] * gp.tileSize;
    }
  }

  /**
   * Sets the Raccoons' locations.
   */
  public void setRaccoon() {
    int Xarrs[] = {35, 14, 20};
    int Yarrs[] = {9, 18, 5};

    for (int i = 0; i < 3; i++) {
      gp.raccoons[i] = new Raccoons(gp);
      gp.raccoons[i].xPosition = Xarrs[i] * gp.tileSize;
      gp.raccoons[i].yPosition = Yarrs[i] * gp.tileSize;
    }
  }
}
