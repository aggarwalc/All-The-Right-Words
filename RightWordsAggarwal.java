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

  // ---- Attributes ----
  private JFrame gameFrame, instructionsFrame;
  private JPanel bckMain, bckSide, bpTop, bpBot, buttonLetterPanel, buttonExtrasPanel,
                 textPanel, scorePanel, wordsPanel, bckIs, headerPanel, isPanel;
  private JButton[] letters = new JButton[7];
  private JButton finish, clearText, instructions, submit;
  private JLabel scoreLabel, wordsLabel, words, headerLabel;
  private JTextField output;
  private Font scoreFont, letterFont, extrasFont, wordsFont, isFont;
  private Color darkGreen, lightGreen, darkText;

  // ---- Methods ----

  /** constructor */
  public RightWordsAggarwal(){

    // initializing colors
    darkGreen = new Color(132, 169, 140);
    lightGreen = new Color(202, 210, 197);
    darkText = new Color(57, 65, 60);
    // initializing fonts
    scoreFont = new Font("Courier", Font.BOLD, 30);
    extrasFont = new Font("Courier", Font.BOLD, 18);
    wordsFont = new Font("Courier", Font.PLAIN, 17);
    letterFont = new Font("Courier", Font.BOLD, 45);
    isFont = new Font("Courier", Font.BOLD, 30);
    // output textfield
    output = new JTextField();
      output.setFont(letterFont);
      output.setForeground(darkText);
    // Buttons - finish, clear, instuctions, submit
    finish = new JButton("Finish");
      finish.setFont(extrasFont);
      finish.setForeground(darkText);

    clearText = new JButton("Clear");
      clearText.setFont(extrasFont);
      clearText.setForeground(darkText);
      clearText.setPreferredSize(new Dimension(175, 30));

    instructions = new JButton("Instructions");
      instructions.setFont(extrasFont);
      instructions.setForeground(darkText);
      instructions.setPreferredSize(new Dimension(175, 30));

      // Ref: https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
      /* I wanted to create a button that opens or closes the instruction frame
      This code uses setVisible() to show or hide the frame when the button is clicked */
      instructions.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          if (instructionsFrame.isVisible()){
            instructionsFrame.setVisible(false);
          }
          else{
            instructionsFrame.setVisible(true);
          }
        }
      });

    submit = new JButton("Submit");
      submit.setFont(extrasFont);
      submit.setForeground(darkText);
      submit.setPreferredSize(new Dimension(175, 30));
    // Labels - score, previous words header + words, instructions header,
    scoreLabel = new JLabel("Score:", JLabel.CENTER);
      scoreLabel.setFont(scoreFont);
      scoreLabel.setForeground(darkText);

    wordsLabel = new JLabel("Previous Words:", JLabel.CENTER);
      wordsLabel.setFont(extrasFont);
      wordsLabel.setForeground(darkText);
      // Ref: https://docs.oracle.com/javase/7/docs/api/javax/swing/BorderFactory.html#createEmptyBorder(int,%20int,%20int,%20int)
      /* This code creates an empty border that acts sort of like padding
      It lets me have more control over the positioning of panels */
      wordsLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    words = new JLabel("<html><center></center><html>", JLabel.CENTER);
      words.setFont(wordsFont);
      words.setForeground(darkText);

    headerLabel = new JLabel("Instructions", JLabel.CENTER);
      headerLabel.setFont(isFont);
      headerLabel.setForeground(darkText);
    // Panels
    headerPanel = new JPanel();
      headerPanel.setPreferredSize(new Dimension(250, 60));
      headerPanel.setBackground(lightGreen);
      headerPanel.setLayout(new BorderLayout());
      headerPanel.add(headerLabel, BorderLayout.CENTER);

    isPanel = new JPanel();
      isPanel.setPreferredSize(new Dimension(250, 380));
      isPanel.setBackground(lightGreen);

    textPanel = new JPanel();
      textPanel.setLayout(new BorderLayout());
      textPanel.setPreferredSize(new Dimension(550, 80));
      textPanel.setBackground(darkGreen);
      textPanel.add(output, BorderLayout.CENTER);

    bpTop = new JPanel();
      bpTop.setLayout(new GridBagLayout());
      bpTop.setBackground(darkGreen);
      // Buttons - letters
      for (int i=0; i < 4; i++){
        letters[i] = new JButton("L" + i);
        letters[i].setPreferredSize(new Dimension(105, 110));
        letters[i].setForeground(darkGreen);
        letters[i].setFont(letterFont);
        bpTop.add(letters[i]);
      }

    bpBot = new JPanel();
      bpBot.setLayout(new GridBagLayout());
      bpBot.setBackground(darkGreen);
      // Buttons - letters
      for (int i=4; i < 7; i++){
        letters[i] = new JButton("L" + i);
        letters[i].setPreferredSize(new Dimension(105, 110));
        letters[i].setForeground(darkGreen);
        letters[i].setFont(letterFont);
        bpBot.add(letters[i]);
      }

    buttonLetterPanel = new JPanel();
      buttonLetterPanel.setBackground(lightGreen);
      buttonLetterPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
      buttonLetterPanel.add(bpTop);
      buttonLetterPanel.add(bpBot);

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
    // Design Structure Panels
    bckMain = new JPanel();
      bckMain.setBackground(lightGreen);
      bckMain.setPreferredSize(new Dimension(650, 500));
      bckMain.setLayout(new BorderLayout());
      bckMain.setBorder(BorderFactory.createEmptyBorder(45, 25, 20, 25));
      bckMain.add(textPanel, BorderLayout.NORTH);
      bckMain.add(buttonLetterPanel, BorderLayout.CENTER);
      bckMain.add(buttonExtrasPanel, BorderLayout.SOUTH);

    bckSide = new JPanel();
      bckSide.setBackground(darkGreen);
      bckSide.setPreferredSize(new Dimension(250, 500));
      bckSide.setLayout(new BorderLayout());
      bckSide.setBorder(BorderFactory.createEmptyBorder(25,25, 25, 25));
      bckSide.add(scorePanel, BorderLayout.NORTH);
      bckSide.add(wordsPanel, BorderLayout.SOUTH);

    bckIs = new JPanel();
      bckIs.add(headerPanel);
      bckIs.add(isPanel);
      bckIs.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
    // Frames - Game, Instructions
    gameFrame = new JFrame("All the Right Words");
      gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      gameFrame.setSize(900, 500);
      gameFrame.setResizable(false);
      gameFrame.setLayout(new BorderLayout());
      gameFrame.add(bckMain, BorderLayout.WEST);
      gameFrame.add(bckSide, BorderLayout.EAST);
      gameFrame.setVisible(true);

      // Ref: https://stackoverflow.com/questions/15513380/how-to-open-a-new-window-by-clicking-a-button
      /* I wanted to open the instructions frame side by side with the game frame
      This code gets the position of the game fram, and uses it to position the instructions frame */
      Point gfLocation = gameFrame.getLocation();

    instructionsFrame = new JFrame("Instructions");
      instructionsFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
      instructionsFrame.setSize(280, 500);
      instructionsFrame.setResizable(false);
      instructionsFrame.add(bckIs);

      // see reference above
      Point ifLocation = new Point(gfLocation.x + gameFrame.getWidth(), gfLocation.y);
      instructionsFrame.setLocation(ifLocation);

      instructionsFrame.setVisible(true);

  }

  /** main method */
  public static void main(String[] args) {
    new RightWordsAggarwal();
  }

}
