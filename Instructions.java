/**
  * Instructions.java
  * @author Chirag Aggarwal
  * @description Instructions GUI
  * @version 2.0 2022-04-22
*/

// ***NOTES***
//

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
  private String instructions;

  /**----------Methods----------*/

  /** Constructor */
  public Instructions(){
    setFontsAndColors();
    setPanels();
    setFrame();
    setLocation();
  }

  // Set Instruction Frame Fonts and Colors
  public void setFontsAndColors(){
    // Initilize Colors
    lightGreen = new Color(202, 210, 197);
    darkText = new Color(57, 65, 60);
    // Initialize Fonts
    isHeaderFont = new Font("Courier", Font.BOLD, 30);
  }

  // Set Instruction Frame Panels
  public void setPanels(){
    // Initialize Labels
    isHeaderLabel = new JLabel("Instructions", JLabel.CENTER);
      isHeaderLabel.setFont(isHeaderFont);
      isHeaderLabel.setForeground(darkText);

    // Set Instructions
    instructions = "<html>";
    instructions += "Use the letters provided to come up <br> with a word <br><br>";
    instructions += "You may not use the letters more <br> than once <br><br>";
    instructions += "Press Submit when you are done <br> spelling the word <br><br>";
    instructions += "Press Clear if you would like to <br> clear the text box <br><br>";
    instructions += "Press Finish when you are ready to <br> start a new game! <br><br>";
    instructions += "Press Instructions to get rid of this <br> frame or bring it back again <br><br><br><br>";
    instructions += "MOST IMPORTANT: Have fun! :)";

    isContentLabel = new JLabel(instructions, JLabel.CENTER);

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

  // Set Instruction Frame
  public void setFrame(){
    frame = new JFrame("Instructions");
      frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      frame.setSize(280, 500);
      frame.setResizable(false);
      frame.add(isBckPanel);
      frame.setVisible(true);
  }

  // Set Instruction Frame location relative to Game Frame
  public static void setLocation(){
    // Ref: https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
    /* I wanted to open the instructions frame side by side with the game frame
    This code gets the position of the game frame, and uses it to position the instructions frame */
    Point gameLocation = RightWordsAggarwal.getLocation();
    Point isLocation = new Point(gameLocation.x + 900, gameLocation.y);
    frame.setLocation(isLocation);

    frame.setVisible(true);
  }

  // Change Instruction Frame Visibility
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
} // End of Instructions Class
