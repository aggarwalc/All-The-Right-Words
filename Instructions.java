/**
  * Instructions.java
  * @author Chirag Aggarwal
  * @description Instructions GUI
  * @version 2.0 2022-04-22
*/

// ***NOTES***
// *****ADD INSTRUCTIONS*****

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Instructions{

  /**----------Attributes----------*/
  private static JFrame frame;
  private JPanel isBckPanel, isHeaderPanel, isContentPanel;
  private JLabel isHeaderLabel, isContentLabel;
  private Font isHeaderFont;
  private Color lightGreen, darkText;

  /**----------Methods----------*/

  /** Constructor */
  public Instructions(){
    setFontsAndColors();
    setPanels();
    setFrame();
    setLocation();
  }

  public void setFontsAndColors(){
    // Initilize Colors
    lightGreen = new Color(202, 210, 197);
    darkText = new Color(57, 65, 60);
    // Initialize Fonts
    isHeaderFont = new Font("Courier", Font.BOLD, 30);
  }

  public void setPanels(){
    // Initialize Labels
    isHeaderLabel = new JLabel("Instructions", JLabel.CENTER);
      isHeaderLabel.setFont(isHeaderFont);
      isHeaderLabel.setForeground(darkText);
    isContentLabel = new JLabel(); // *****ADD INSTRUCTIONS*****
    // Initialize panels
    isHeaderPanel = new JPanel();
      isHeaderPanel.setPreferredSize(new Dimension(250, 60));
      isHeaderPanel.setBackground(lightGreen);
      isHeaderPanel.setLayout(new BorderLayout());
      isHeaderPanel.add(isHeaderLabel, BorderLayout.CENTER);
    isContentPanel = new JPanel();
      isContentPanel.setPreferredSize(new Dimension(250, 380));
      isContentPanel.setBackground(lightGreen);
      isContentPanel.add(isContentLabel);
    isBckPanel = new JPanel();
      isBckPanel.add(isHeaderPanel);
      isBckPanel.add(isContentPanel);
      isBckPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
  }

  public void setFrame(){
    frame = new JFrame("Instructions");
      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      frame.setSize(280, 500);
      frame.setResizable(false);
      frame.add(isBckPanel);
      frame.setVisible(true);
  }

  public static void setLocation(){
    // Ref: https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
    /* I wanted to open the instructions frame side by side with the game frame
    This code gets the position of the game frame, and uses it to position the instructions frame */
    Point gameLocation = RightWordsAggarwal.getLocation();
    Point isLocation = new Point(gameLocation.x + 900, gameLocation.y);
    frame.setLocation(isLocation);

    frame.setVisible(true);
  }

  public static void setVisible(){
    if (frame.isVisible()){
      frame.setVisible(false);
    }
    else{
      setLocation();
      frame.setVisible(true);
    }
  }

  /** Main */
  public static void main(String[] args) {
    new Instructions();
  }
} // end of Instructions Class
