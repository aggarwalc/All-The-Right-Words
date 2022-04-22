/**
  * RightWordsAggarwal.java
  * @author Chirag Aggarwal
  * @description Right Words Game GUI
  * @version 1.0 2022-03-19
*/

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RightWordsAggarwal{

  /**----------Attributes----------*/
  private static JFrame frame;
  private JPanel bckMainPanel, bckSidePanel, ButtonTopPanel, ButtonBottomPanel, buttonLetterPanel, buttonExtrasPanel,
                 textPanel, scorePanel, wordsPanel;
  private JButton[] letters = new JButton[7];
  private JButton finish, clearText, instructions, submit;
  private JLabel scoreLabel, wordsLabel, words, headerLabel;
  private JTextField output;
  private Font scoreFont, letterButtonsFont, extraButtonsFont, guessedWordsFont;
  private Color darkGreen, lightGreen, darkText;
  private Response userActivity = new Response();

  /**----------Methods----------*/

  /** Constructor */
  public RightWordsAggarwal(){
    setFontsAndColors();
    setPanels();
    setFrame();
  }

  public void setFontsAndColors(){
    // Initialize Colors
    darkGreen = new Color(132, 169, 140);
    lightGreen = new Color(202, 210, 197);
    darkText = new Color(57, 65, 60);
    // Initialize Fonts
    scoreFont = new Font("Courier", Font.BOLD, 30);
    extraButtonsFont = new Font("Courier", Font.BOLD, 18);
    guessedWordsFont = new Font("Courier", Font.PLAIN, 17);
    letterButtonsFont = new Font("Courier", Font.BOLD, 45);
  }

  public void setPanels(){
    // Initialize TextField
    output = new JTextField();
      output.setFont(letterButtonsFont);
      output.setForeground(darkText);

    // Initialize Extra Buttons
    finish = new JButton("Finish");
      finish.setFont(extraButtonsFont);
      finish.setForeground(darkText);
    clearText = new JButton("Clear");
      clearText.setFont(extraButtonsFont);
      clearText.setForeground(darkText);
      clearText.setPreferredSize(new Dimension(175, 30));
    instructions = new JButton("Instructions");
      instructions.setFont(extraButtonsFont);
      instructions.setForeground(darkText);
      instructions.setPreferredSize(new Dimension(175, 30));
      instructions.addActionListener(userActivity);
    submit = new JButton("Submit");
      submit.setFont(extraButtonsFont);
      submit.setForeground(darkText);
      submit.setPreferredSize(new Dimension(175, 30));

    // Initialize Labels
    scoreLabel = new JLabel("Score:", JLabel.CENTER);
      scoreLabel.setFont(scoreFont);
      scoreLabel.setForeground(darkText);
    wordsLabel = new JLabel("Previous Words:", JLabel.CENTER);
      wordsLabel.setFont(extraButtonsFont);
      wordsLabel.setForeground(darkText);
      // Ref: https://docs.oracle.com/javase/7/docs/api/javax/swing/BorderFactory.html#createEmptyBorder(int,%20int,%20int,%20int)
      /* This code creates an empty border that acts sort of like padding
      It lets me have more control over the positioning of panels */
      wordsLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    words = new JLabel("<html><center></center><html>", JLabel.CENTER);
      words.setFont(guessedWordsFont);
      words.setForeground(darkText);

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
        letters[i] = new JButton("L" + i);
        letters[i].setPreferredSize(new Dimension(105, 110));
        letters[i].setForeground(darkGreen);
        letters[i].setFont(letterButtonsFont);
        ButtonTopPanel.add(letters[i]);
      }
    ButtonBottomPanel = new JPanel();
      ButtonBottomPanel.setLayout(new GridBagLayout());
      ButtonBottomPanel.setBackground(darkGreen);
      // Initialize Letter Buttons
      for (int i=4; i < 7; i++){
        letters[i] = new JButton("L" + i);
        letters[i].setPreferredSize(new Dimension(105, 110));
        letters[i].setForeground(darkGreen);
        letters[i].setFont(letterButtonsFont);
        ButtonBottomPanel.add(letters[i]);
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
      wordsPanel.add(wordsLabel, BorderLayout.NORTH);
      wordsPanel.add(words, BorderLayout.CENTER);
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
      if (press.getSource() == instructions){
        Instructions.setVisible();
      }
    }
  } // end of nested Action Listener Class


  /** Main */
  public static void main(String[] args) {
    new RightWordsAggarwal();
  }
} // end of RightWordsAggarwal Class
