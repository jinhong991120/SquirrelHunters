package com.group11.game;

/**
 * CollisionChecker class
 */
public class CollisionChecker {

  /**
   * target {@code GamePanel} 
   */
  private GamePanel gp;

  /**
   * Constructor.
   *
   * @param gp GamePanel that is affected
   */
  public CollisionChecker(GamePanel gp) { this.gp = gp; }

  /**
   * Checks whether the tile is a wall or water tile, and if true, the character
   * cannot go forward.
   *
   * @param entity the target character
   */
  public void checkTile(Characters entity) {
    int left = entity.xPosition + entity.solidArea.x;
    int right = entity.xPosition - entity.solidArea.x + entity.solidArea.width;
    int top = entity.yPosition + entity.solidArea.y;
    int bot =
        entity.yPosition - entity.solidArea.y + entity.solidArea.height + 10;

    int leftCol = left / gp.tileSize;
    int rightCol = right / gp.tileSize;
    int topRow = top / gp.tileSize;
    int botRow = bot / gp.tileSize;

    int tileNum1, tileNum2;

    switch (entity.direction) {
    case "up":
      topRow = (top - entity.speed) / gp.tileSize;
      tileNum1 = gp.tr.mapArr[leftCol][topRow];
      tileNum2 = gp.tr.mapArr[rightCol][topRow];
      if (gp.tr.tiles[tileNum1].collision == true ||
          gp.tr.tiles[tileNum2].collision == true || top - 10 < 0) {
        entity.collisionOn = true;
      }
      break;
    case "down":
      botRow = (bot + entity.speed) / gp.tileSize;
      tileNum1 = gp.tr.mapArr[leftCol][botRow];
      tileNum2 = gp.tr.mapArr[rightCol][botRow];
      if (gp.tr.tiles[tileNum1].collision == true ||
          gp.tr.tiles[tileNum2].collision == true ||
          bot + 10 > gp.screenHeight) {
        entity.collisionOn = true;
      }
      break;
    case "left":
      leftCol = (left - entity.speed) / gp.tileSize;
      tileNum1 = gp.tr.mapArr[leftCol][topRow];
      tileNum2 = gp.tr.mapArr[leftCol][botRow];
      if (gp.tr.tiles[tileNum1].collision == true ||
          gp.tr.tiles[tileNum2].collision == true || left - 5 < 0) {
        entity.collisionOn = true;
      }
      break;
    case "right":
      rightCol = (right + entity.speed) / gp.tileSize;
      tileNum1 = gp.tr.mapArr[rightCol][topRow];
      tileNum2 = gp.tr.mapArr[rightCol][botRow];
      if (gp.tr.tiles[tileNum1].collision == true ||
          gp.tr.tiles[tileNum2].collision == true ||
          right + 10 > gp.screenWidth) {
        entity.collisionOn = true;
      }
      break;
    }
  }

  /**
   * Checks the collision with given array items and returns the index of the
   * item.
   *
   * @param sq Squirrel
   * @param isSquirrel true if Squirrel, false otherwise
   * @param items Items array to check collision with it
   * @return index of item
   */
  public int checkObjects(Characters sq, boolean isSquirrel, Items[] items) {
    int index = -1;

    for (int i = 0; i < items.length; i++) {
      if (items[i] != null) {
        // get character's solid area position
        sq.solidArea.x = sq.xPosition + sq.solidArea.x;
        sq.solidArea.y = sq.yPosition + sq.solidArea.y;

        // get the item's solid area position
        items[i].solidArea.x = items[i].xPosition + items[i].solidArea.x + 10;
        items[i].solidArea.y = items[i].yPosition + items[i].solidArea.y + 10;

        switch (sq.direction) {
        case "up":
          sq.solidArea.y -= sq.speed;
          if (sq.solidArea.intersects(items[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        case "down":
          sq.solidArea.y += sq.speed;
          if (sq.solidArea.intersects(items[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        case "left":
          sq.solidArea.x -= sq.speed;
          if (sq.solidArea.intersects(items[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        case "right":
          sq.solidArea.x += sq.speed;
          if (sq.solidArea.intersects(items[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        }
        sq.solidArea.x = sq.solidAreaDefaultX;
        sq.solidArea.y = sq.solidAreaDefaultY;
        items[i].solidArea.x = items[i].solidAreaDefaultX;
        items[i].solidArea.y = items[i].solidAreaDefaultY;
      }
    }
    return index;
  }

  /**
   * Checks the collision if player contacts an enemy.
   *
   * @param sq Squirrel
   * @return index of enemy
   */
  public int checkEntity(Characters sq) {
    int index = -1;

    for (int i = 0; i < gp.raccoons.length; i++) {
      if (gp.raccoons[i] != null) {
        // get character's solid area position
        sq.solidArea.x = sq.xPosition + sq.solidArea.x;
        sq.solidArea.y = sq.yPosition + sq.solidArea.y;

        // get the enemy's solid area position
        gp.raccoons[i].solidArea.x =
            gp.raccoons[i].xPosition + gp.raccoons[i].solidArea.x;
        gp.raccoons[i].solidArea.y =
            gp.raccoons[i].yPosition + gp.raccoons[i].solidArea.y;

        switch (sq.direction) {
        case "up":
          sq.solidArea.y -= sq.speed;
          if (sq.solidArea.intersects(gp.raccoons[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        case "down":
          sq.solidArea.y += sq.speed;
          if (sq.solidArea.intersects(gp.raccoons[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        case "left":
          sq.solidArea.x -= sq.speed;
          if (sq.solidArea.intersects(gp.raccoons[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        case "right":
          sq.solidArea.x += sq.speed;
          if (sq.solidArea.intersects(gp.raccoons[i].solidArea)) {
            sq.collisionOn = true;
            index = i;
          }
          break;
        }
        sq.solidArea.x = sq.solidAreaDefaultX;
        sq.solidArea.y = sq.solidAreaDefaultY;
        gp.raccoons[i].solidArea.x = gp.raccoons[i].solidAreaDefaultX;
        gp.raccoons[i].solidArea.y = gp.raccoons[i].solidAreaDefaultY;
      }
    }
    return index;
  }

  /**
   * Checks if enemy contacts the player.
   *
   * @param enemy the target enemy
   * @return true is player is touched
   */
  public boolean checkPlayer(Characters enemy) {
    boolean touchPlayer = false;

    // get enemy's solid area position
    enemy.solidArea.x = enemy.xPosition + enemy.solidArea.x;
    enemy.solidArea.y = enemy.yPosition + enemy.solidArea.y;

    // get the Squirrel's solid area position
    gp.Squirrels.solidArea.x = gp.Squirrels.xPosition + gp.Squirrels.solidArea.x;
    gp.Squirrels.solidArea.y = gp.Squirrels.yPosition + gp.Squirrels.solidArea.y;

    switch (enemy.direction) {
    case "up":
      enemy.solidArea.y -= enemy.speed;
      if (enemy.solidArea.intersects(gp.Squirrels.solidArea)) {
        enemy.collisionOn = true;
        touchPlayer = true;
      }
      break;
    case "down":
      enemy.solidArea.y += enemy.speed;
      if (enemy.solidArea.intersects(gp.Squirrels.solidArea)) {
        enemy.collisionOn = true;
        touchPlayer = true;
      }
      break;
    case "left":
      enemy.solidArea.x -= enemy.speed;
      if (enemy.solidArea.intersects(gp.Squirrels.solidArea)) {
        enemy.collisionOn = true;
        touchPlayer = true;
      }
      break;
    case "right":
      enemy.solidArea.x += enemy.speed;
      if (enemy.solidArea.intersects(gp.Squirrels.solidArea)) {
        enemy.collisionOn = true;
        touchPlayer = true;
      }
      break;
    }
    enemy.solidArea.x = enemy.solidAreaDefaultX;
    enemy.solidArea.y = enemy.solidAreaDefaultY;
    gp.Squirrels.solidArea.x = gp.Squirrels.solidAreaDefaultX;
    gp.Squirrels.solidArea.y = gp.Squirrels.solidAreaDefaultY;

    return touchPlayer;
  }

  /**
   * Checks whether the Squirrel goes to the portal.
   *
   * @param sq Squirrel
   * @param isSquirrel check Squirrel, true if Squirrel, false otherwise
   * @param p portal
   */
  public void checkPortal(Characters sq, boolean isSquirrel, Portal p) {
    if (isSquirrel) {
      // get character's solid area position
      sq.solidArea.x = sq.xPosition + sq.solidArea.x;
      sq.solidArea.y = sq.yPosition + sq.solidArea.y;

      switch (sq.direction) {
      case "up":
        sq.solidArea.y -= sq.speed;
        if (sq.solidArea.intersects(p.solidArea)) {
          if (p.collision == true) {
            sq.collisionOn = true;
          }
          gp.state = State.Over;
        }
        break;
      case "down":
        sq.solidArea.y += sq.speed;
        if (sq.solidArea.intersects(p.solidArea)) {
          if (p.collision == true) {
            sq.collisionOn = true;
          }
          gp.state = State.Over;
        }
        break;
      case "left":
        sq.solidArea.x -= sq.speed;
        if (sq.solidArea.intersects(p.solidArea)) {
          if (p.collision == true) {
            sq.collisionOn = true;
          }
          gp.state = State.Over;
        }
        break;
      case "right":
        sq.solidArea.x += sq.speed;
        if (sq.solidArea.intersects(p.solidArea)) {
          if (p.collision == true) {
            sq.collisionOn = true;
          }
          gp.state = State.Over;
        }
        break;
      }
    }
    gp.Squirrels.solidArea.x = gp.Squirrels.solidAreaDefaultX;
    gp.Squirrels.solidArea.y = gp.Squirrels.solidAreaDefaultY;
  }
}

