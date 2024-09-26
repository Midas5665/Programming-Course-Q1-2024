import java.awt.*;
import java.util.Random;
import javax.swing.*;

/**
 * Show a single letter in its own window.
 */
public class Letter extends JFrame {
  final static int STEP = 10;
  final static String DEFAULT_LETTER = " ";
  final static int DEFAULT_FONT_SIZE_IN_PX = 120;

  static int sn = 0; // last used serial number

  String text = DEFAULT_LETTER;
  int fontSize = DEFAULT_FONT_SIZE_IN_PX;

  LetterPanel panel;
  Random random = new Random();

  /**
   * Create a new but empty Letter window.
   */
  public Letter() {
    this(DEFAULT_LETTER);
  }

  /**
   * Create a new Letter window at the top left of the screen, showing the first character of string s.
   * 
   * Letters objects created later will be shifted farther to the left relative to this Letter.
   * 
   * @param s  the string of which the first character is shown in the Letter window
   */
  public Letter(String s) {
    this.panel = new LetterPanel(this);
    this.add(this.panel);
    text = getFirstCharOrDefault(s);
    this.setSize(120, 150);
    this.setTitle("#" + sn++);
    this.setLocation(10 * sn, 10);
    this.setVisible(true);
  }

  private String getFirstCharOrDefault(String s) {
    if (s != null && s.length() > 0) {
      return s.substring(0, 1);
    } else {
      return DEFAULT_LETTER;
    }
  }

  /**
   * Create a new Letter window at the top left of the screen, showing character c
   * 
   * @param c  the character to show
   */
  public Letter(char c) {
    this(String.valueOf(c));
  }

  /**
   * Change the text shown in this Letter window to string s. Dimensions of the window are not changed accordingly.
   * 
   * @param s  the string to show
   */
  public void setText(String s) {
    if (s != null) {
      text = getFirstCharOrDefault(s);
    }
    this.repaint();
  }

  public void moveRandomly(Letter x){
    double r=random.nextDouble();
    if(r<0.25){
      x.moveLeft();
    }
    else if(r<0.5){
      x.moveRight();
    }
    else if(r<0.75){
      x.moveDown();
    }
    else{
      x.moveUp();
    }
  }

  public void Dance(Letter x){
    moveRandomly(x);
    moveRandomly(x);
    x.pauseInMs(50);
    moveRandomly(x);
  } //put it in a condition that lasts for as long as you want him to dance

  /**
   * Change the text shown in this Letter window to char c.
   * 
   * @param c  the character to show
   */
  public void setText(char c) {
    this.setText(String.valueOf(c));
  }

  /**
   * Set the background color of this Letter window.
   * 
   * @param c  the color
   */
  public void setColor(Color c) {
    this.panel.setBackground(c);
  }

  /**
   * Set the fontsize of this Letter window in pixels.
   * 
   * @param fs  the fontsize
   */
  public void setFontSize(int fs) {
    this.fontSize = fs;
    this.repaint();
  }

  /**
   * Center this Letter window on the screen.
   */
  public void center() {
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int a = screen.width;
    int b = this.getWidth();
    int x = (a - b) / 2;
    int y = screen.height / 2 - this.getHeight() / 2;
    this.setLocation(x, y);
    this.toFront();
  }

  /**
   * Move this Letter window dx pixels to the right and dy pixels down. Use negative values to move left and up, respectively.
   * 
   * @param dx  the horizontal distance to move
   * @param dy  the vertical distance to move
   */
  public void moveRel(int dx, int dy) {
    Point here = this.getLocationOnScreen();
    this.setLocation(here.x + dx, here.y + dy);
    this.toFront();
  }

  /**
   * Move this Letter window 10 pixels to the right.
   */
  public void moveRight() {
    this.moveRel(STEP, 0);
  }

  /**
   * Move this Letter window 10 pixels to the left.
   */
  public void moveLeft() {
    this.moveRel(-STEP, 0);
  }

  /**
   * Move this Letter window 10 pixels down.
   */
  public void moveDown() {
    this.moveRel(0, STEP);
  }

  /**
   * Move this Letter window 10 pixels up.
   */
  public void moveUp() {
    this.moveRel(0, -STEP);
  }

  /**
   * Move this Letter window to position (x, y) on the screen.
   * 
   * @param x  the x coordinate
   * @param y  the y coordinate
   */
  public void moveAbs(int x, int y) {
    this.setLocation(x, y);
  }

  /**
   * Pause execution for ms milliseconds
   * 
   * @param ms  number of milliseconds
   */
  public static void pauseInMs(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }

  /**
   * Pause execution for sec seconds.
   * 
   * @param sec  number of seconds
   */
  public static void pauseInSec(double sec) {
    pauseInMs((int) sec * 1000);
  }

  // Example of very simple animation
  public static void exampleUse() {
    Letter x = new Letter("X");
    pauseInSec(0.5);
    x.setColor(Color.pink);
    pauseInSec(1.0);
    x.setColor(Color.green);
  }

  /**
   * Animate moving Letter windows
   */
  public static void animate() {
    // INSERT YOUR ANIMATION CODE HERE
    // Look at the 'exampleUse()' method to get an idea about how you could animate
  }

  public static void main(String[] ar) {
    System.out.println("This class is meant to be used in JShell,");
    System.out.println("not to run from the method main.");
  }
}

class LetterPanel extends JPanel {
  private static final String OS_NAME = System.getProperty("os.name").toLowerCase();
  Letter letter;

  LetterPanel(Letter let) {
    this.letter = let;
  }

  /**
   * redraws the Letter, called by the windowing system
   * text is vertically more or less centered, horizontally it is not
   * 
   * @param g
   */
  public void paint(Graphics g) {
    super.paintComponent(g);
    int bar = OS_NAME.contains("mac") ? 10 : 0; // height of title bar (Mac OS); estimation
    int h = getHeight() - bar;

    Font font = new Font(g.getFont().getFontName(), Font.BOLD, letter.fontSize);
    g.setFont(font);
    g.drawString(letter.text, 25, (h + letter.fontSize) / 2 - 10);
  }

}