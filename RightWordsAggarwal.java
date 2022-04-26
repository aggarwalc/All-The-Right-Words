/**
  * RightWordsAggarwal.java
  * @author Chirag Aggarwal
  * @description All The Right Words Game GUI
  * @version 2.0 2022-04-22
*/

// ***NOTES***
//

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RightWordsAggarwal{

  /**----------Attributes----------*/
  private static JFrame frame;
  private JPanel bckMainPanel, bckSidePanel, ButtonTopPanel, ButtonBottomPanel, buttonLetterPanel, buttonExtrasPanel,
                 textPanel, scorePanel, wordsPanel;
  private JButton[] letterButtons = new JButton[7];
  private JButton finish, clearText, instructions, submit;
  private JLabel scoreLabel, wordsHeaderLabel, wordsContentLabel;
  private JTextField output;
  private Font scoreFont, letterButtonsFont, extraButtonsFont, guessedWordsFont;
  private Color darkGreen, lightGreen, darkText;
  private Response userActivity = new Response();
  private Content content = new Content();
  private String[] letters = content.getLetters();

  /**----------Methods----------*/

  /** Constructor */
  public RightWordsAggarwal(){
    setFontsAndColors();
    setPanels();
    setFrame();
  }

  // Set Game Frame Fonts and Colors
  public void setFontsAndColors(){
    // Initialize Colors
    darkGreen = new Color(132, 169, 140);
    lightGreen = new Color(202, 210, 197);
    darkText = new Color(57, 65, 60);
    // Initialize Fonts
    scoreFont = new Font("Courier", Font.BOLD, 25);
    extraButtonsFont = new Font("Courier", Font.BOLD, 19);
    guessedWordsFont = new Font("Courier", Font.PLAIN, 19);
    letterButtonsFont = new Font("Courier", Font.BOLD, 45);
  }

  // Set Game Frame Panels
  public void setPanels(){
    // Initialize TextField
    output = new JTextField();
      output.setFont(letterButtonsFont);
      output.setForeground(darkText);

    // Initialize Extra Buttons
    finish = new JButton("Finish");
      finish.setFont(extraButtonsFont);
      finish.setForeground(darkText);
      finish.addActionListener(userActivity);
    clearText = new JButton("Clear");
      clearText.setFont(extraButtonsFont);
      clearText.setForeground(darkText);
      clearText.setPreferredSize(new Dimension(175, 30));
      clearText.addActionListener(userActivity);
    instructions = new JButton("Instructions");
      instructions.setFont(extraButtonsFont);
      instructions.setForeground(darkText);
      instructions.setPreferredSize(new Dimension(175, 30));
      instructions.addActionListener(userActivity);
    submit = new JButton("Submit");
      submit.setFont(extraButtonsFont);
      submit.setForeground(darkText);
      submit.setPreferredSize(new Dimension(175, 30));
      submit.addActionListener(userActivity);

    // Initialize Labels
    scoreLabel = new JLabel("Score: 0", JLabel.CENTER);
      scoreLabel.setFont(scoreFont);
      scoreLabel.setForeground(darkText);
    wordsHeaderLabel = new JLabel("Previous Words:", JLabel.CENTER);
      wordsHeaderLabel.setFont(extraButtonsFont);
      wordsHeaderLabel.setForeground(darkText);
      // Ref: https://docs.oracle.com/javase/7/docs/api/javax/swing/BorderFactory.html#createEmptyBorder(int,%20int,%20int,%20int)
      /* This code creates an empty border that acts sort of like padding
      It lets me have more control over the positioning of panels */
      wordsHeaderLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    wordsContentLabel = new JLabel("", JLabel.CENTER);
      wordsContentLabel.setFont(guessedWordsFont);
      wordsContentLabel.setForeground(darkText);

    // Initialize Panels
    textPanel = new JPanel();
      textPanel.setLayout(new BorderLayout());
      textPanel.setPreferredSize(new Dimension(550, 80));
      textPanel.setBackground(darkGreen);
      textPanel.add(output, BorderLayout.CENTER);
    ButtonTopPanel = new JPanel();
      ButtonTopPanel.setLayout(new GridBagLayout());
      ButtonTopPanel.setBackground(darkGreen);
      // Initialize Letter Buttons
      for (int i=0; i < 4; i++){
        letterButtons[i] = new JButton(letters[i]);
        letterButtons[i].setPreferredSize(new Dimension(105, 110));
        letterButtons[i].setForeground(darkGreen);
        letterButtons[i].setFont(letterButtonsFont);
        letterButtons[i].addActionListener(userActivity);
        ButtonTopPanel.add(letterButtons[i]);
      }
    ButtonBottomPanel = new JPanel();
      ButtonBottomPanel.setLayout(new GridBagLayout());
      ButtonBottomPanel.setBackground(darkGreen);
      // Initialize Letter Buttons
      for (int i=4; i < 7; i++){
        letterButtons[i] = new JButton(letters[i]);
        letterButtons[i].setPreferredSize(new Dimension(105, 110));
        letterButtons[i].setForeground(darkGreen);
        letterButtons[i].setFont(letterButtonsFont);
        letterButtons[i].addActionListener(userActivity);
        ButtonBottomPanel.add(letterButtons[i]);
      }
    buttonLetterPanel = new JPanel();
      buttonLetterPanel.setBackground(lightGreen);
      buttonLetterPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
      buttonLetterPanel.add(ButtonTopPanel);
      buttonLetterPanel.add(ButtonBottomPanel);
    buttonExtrasPanel = new JPanel();
      buttonExtrasPanel.setLayout(new GridBagLayout());
      buttonExtrasPanel.setBackground(lightGreen);
      buttonExtrasPanel.add(clearText);
      buttonExtrasPanel.add(instructions);
      buttonExtrasPanel.add(submit);
    scorePanel = new JPanel();
      scorePanel.setBackground(lightGreen);
      scorePanel.setPreferredSize(new Dimension(200, 80));
      scorePanel.setLayout(new BorderLayout());
      scorePanel.add(scoreLabel, BorderLayout.CENTER);
    wordsPanel = new JPanel();
      wordsPanel.setBackground(lightGreen);
      wordsPanel.setPreferredSize(new Dimension(200, 300));
      wordsPanel.setLayout(new BorderLayout());
      wordsPanel.add(wordsHeaderLabel, BorderLayout.NORTH);
      wordsPanel.add(wordsContentLabel);
      wordsPanel.add(finish, BorderLayout.SOUTH);

    // Initialize Structural Panels (used for layout)
    bckMainPanel = new JPanel();
      bckMainPanel.setBackground(lightGreen);
      bckMainPanel.setPreferredSize(new Dimension(650, 500));
      bckMainPanel.setLayout(new BorderLayout());
      bckMainPanel.setBorder(BorderFactory.createEmptyBorder(45, 25, 20, 25));
      bckMainPanel.add(textPanel, BorderLayout.NORTH);
      bckMainPanel.add(buttonLetterPanel, BorderLayout.CENTER);
      bckMainPanel.add(buttonExtrasPanel, BorderLayout.SOUTH);

    bckSidePanel = new JPanel();
      bckSidePanel.setBackground(darkGreen);
      bckSidePanel.setPreferredSize(new Dimension(250, 500));
      bckSidePanel.setLayout(new BorderLayout());
      bckSidePanel.setBorder(BorderFactory.createEmptyBorder(25,25, 25, 25));
      bckSidePanel.add(scorePanel, BorderLayout.NORTH);
      bckSidePanel.add(wordsPanel, BorderLayout.SOUTH);
  }

  // Set Game Frame
  public void setFrame(){
    frame = new JFrame("All the Right Words");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(900, 500);
      frame.setResizable(false);
      frame.setLayout(new BorderLayout());
      frame.add(bckMainPanel, BorderLayout.WEST);
      frame.add(bckSidePanel, BorderLayout.EAST);
      frame.setVisible(true);
    new Instructions();
  }

  // Get the location of the Game Frame
  public static Point getLocation(){
    // Ref: https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
    /* I wanted to open the instructions frame side by side with the game frame
    This code gets the position of the game frame, and uses it to position the instructions frame */
    Point gameLocation = frame.getLocation();
    return(gameLocation);
  }

  /** Adds Responsive Elements */
  private class Response implements ActionListener{

    public void actionPerformed(ActionEvent press){
      // Instructions Button
      if (press.getSource() == instructions){
        Instructions.setVisible();
      }
      // Clear Button
      else if (press.getSource() == clearText){
        output.setText(content.clearOutput());
      }
      // Submit Button
      else if (press.getSource() == submit){
        wordsContentLabel.setText(content.updateWords());
        output.setText(content.clearOutput());
        scoreLabel.setText(content.getScoreText());
      }
      // Finish Button
      else if (press.getSource() == finish){
        output.setText(content.clearOutput());
        wordsContentLabel.setText(content.clearWords());
        scoreLabel.setText(content.clearScore());

        // Initialize new Buttons
        letters = content.getLetters();
        for (int i=0; i < 7; i++){
          letterButtons[i].setText(letters[i]);
        }
      }
      // Letter Buttons
      else{
        for (int i = 0; i < 7; i++){
          if (press.getSource() == letterButtons[i]){
            output.setText(content.updateOutput(letters[i]));
          }
        }
      }
    }
  } // end of nested Action Listener Class


  /** Main */
  public static void main(String[] args) {
    new RightWordsAggarwal();
  }
} // End of RightWordsAggarwal Class
