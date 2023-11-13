package com.group11.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * The UI class provides methods for creating and managing the user interface.
 * It includes functionalities for loading images, setting fonts, and managing game time.
 */
public class UI {

    /**
     * The target GamePanel for UI.
     */
    protected GamePanel gp;

    /**
     * The 2D graphics context for UI.
     */
    protected Graphics2D g2;

    /**
     * A custom font named "retro".
     */
    protected Font retroFont;

    /**
     * Buffered image for the heart (health) icon.
     */
    protected BufferedImage heartImage;

    /**
     * Buffered image for the title page background.
     */
    protected BufferedImage titleImage;

    /**
     * Buffered raccoon images for titleImage.
     */
    protected BufferedImage raccoonImage1;
    protected BufferedImage raccoonImage2;

    /**
     * Buffered squirrel image for titleImage.
     */
    protected BufferedImage squirrelImage;

    /**
     * An order variable for managing UI elements.
     */
    protected int order = 0;

    /**
     * Stopwatch for recording game time.
     */
    protected Stopwatch stopwatch;

    /**
     * The elapsed time recorded by the stopwatch.
     */
    protected double timeElapsed;

  /**
   * Constructor.
   *
   * @param gp target GamePanel to draw on
   */
  public UI(GamePanel gp) {
    this.gp = gp;

    stopwatch = new Stopwatch();

    // Background Title Image
    try {
      titleImage = ImageIO.read(
          getClass().getResourceAsStream("/UI_image/titleImage.png"));
      heartImage =
          ImageIO.read(getClass().getResourceAsStream("/UI_image/heart.png"));
      raccoonImage1 = ImageIO.read(getClass().getResourceAsStream("/raccoon/e1.png"));
      raccoonImage2 = ImageIO.read(getClass().getResourceAsStream("/raccoon/e2.png"));
      squirrelImage = ImageIO.read(getClass().getResourceAsStream("/squirrel_image/right2.png"));
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Create font
    try {
      InputStream is = getClass().getResourceAsStream("/font/Retro_Gaming.ttf");
      retroFont = Font.createFont(Font.TRUETYPE_FONT, is);
    } catch (FontFormatException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    }
  }
  /**
   * Draw the state of the game character.
   *
   * @param g2 Graphics2D object to draw on
   */
  public void draw(Graphics2D g2) {
    this.g2 = g2;
    g2.setFont(retroFont);
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25f));
    g2.setColor(Color.white);

    // HEART
    g2.drawImage(heartImage, 16, 3, 48, 48, null);
    g2.drawString("x " + gp.Squirrels.heart, 74, 40);

    // SCORE
    g2.drawString("Score: " + gp.Squirrels.score, 16, 80);

    // Draw Time Elapsed
    if (gp.state == State.Game) {
      if (!stopwatch.isRunning()) {
        stopwatch.start();
      }
      if (stopwatch.isPaused()) {
        stopwatch.resume();
      }

      timeElapsed = stopwatch.elapsed() / 100000000;
      timeElapsed /= 100;
      timeElapsed *= 10;
    }
    g2.drawString("Time: " + String.format("%.1f", timeElapsed), 16, 110);

    // TITLE STATE
    if (gp.state == State.Title) {
      drawTitle();
    }
    // PAUSE
    if (gp.state == State.Pause) {
      drawPause();
      stopwatch.pause();
    }
    // GAME OVER
    if (gp.state == State.Over) {
      drawGameOver();
      stopwatch.stop();
    }
  }

  /**
   * Creates a new window with the specified title and dimensions.
   */
  public void drawTitle() {
    // Background
    g2.drawImage(titleImage, 0, 0, 1280, 768, null);

    // TITLE
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 100f));
    String txt = "SQUIRREL HUNTERS";
    int x = getCenterX(txt);
    int y = gp.tileSize * 8;

    g2.setColor(Color.darkGray);
    g2.drawString(txt, x + 5, y + 5);
    g2.setColor(Color.white);
    g2.drawString(txt, x, y);

    // IMAGE OF CHARACTER
    x = gp.screenWidth / 2 - (gp.tileSize * 2) / 2 - 600;
    y += gp.tileSize * 2 + 60;

    g2.drawImage(raccoonImage1, 135, 535, gp.tileSize * 3, gp.tileSize * 3,
                 null);
    g2.drawImage(raccoonImage2, 350, 550, gp.tileSize * 3, gp.tileSize * 3,
                 null);
    g2.drawImage(squirrelImage,800, 600, gp.tileSize * 1, gp.tileSize * 1,
                 null);

    // OPTIONS
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 60f));
    txt = "NEW GAME";
    x = getCenterX(txt) + 390;
    y += gp.tileSize * 4;
    g2.drawString(txt, x, y);
    if (order == 0) {
      g2.drawString(">", x - gp.tileSize * 3, y);
    }

    txt = "QUIT";
    x = getCenterX(txt) + 470;
    y += gp.tileSize * 4;
    g2.drawString(txt, x, y);
    if (order == 1) {
      g2.drawString(">", x - gp.tileSize * 2 - 28, y);
    }
  }
  /**
   * Creates a new interface on the Pause state.
   */
  public void drawPause() {
    g2.setColor(new Color(0, 0, 0, 150));
    g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

    String text;
    int x;
    int y;
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 150f));
    text = "PAUSED";
    x = getCenterX(text);
    y = gp.tileSize * 14;

    g2.setColor(Color.white);
    g2.drawString(text, x, y);
  }

  /**
   * Get the middle point of x-axis in the window.
   *
   * @param txt a String with different length
   * @return the index of the middle x in pixel
   */
  public int getCenterX(String txt) {
    int len = (int)g2.getFontMetrics().getStringBounds(txt, g2).getWidth();
    int x = gp.screenWidth / 2 - len / 2;
    return x;
  }
  /**
   * Creates a new interface on the GameOver state.
   */
  public void drawGameOver() {
    g2.setColor(new Color(0, 0, 0, 150));
    g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

    int x;
    int y;
    String text;
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 150f));
    text = "GAME OVER";
    x = getCenterX(text);
    y = gp.tileSize * 15;

    // GAME OVER
    g2.setColor(Color.white);
    g2.drawString(text, x, y - 230);

    // SCORE
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50f));
    text = "Score: " + gp.Squirrels.score;
    x = getCenterX(text);
    y = gp.tileSize * 15;
    g2.drawString(text, x, y - 135);

    // TIME ELAPSED
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50f));
    text = "Time: " + String.format("%.1f", timeElapsed);
    x = getCenterX(text);
    y = gp.tileSize * 15;
    g2.drawString(text, x, y - 85);

    // RETRY
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50f));
    text = "RETRY";
    x = getCenterX(text);
    y = gp.tileSize * 15;
    g2.drawString(text, x, y);
    if (order == 0) {
      g2.drawString(">", x - gp.tileSize * 3, y);
    }

    // EXIT
    g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 50f));
    text = "QUIT";
    x = getCenterX(text);
    y += 55;
    g2.drawString(text, x, y);
    if (order == 1) {
      g2.drawString(">", x - gp.tileSize * 3, y);
    }
  }
}
