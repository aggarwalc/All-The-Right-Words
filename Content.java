/**
  * Content.java
  * @author Chirag Aggarwal
  * @description Updates Content in the All The Right Words Game
  * @version 1.0 2022-04-22
*/

// ***NOTES***
// *****GAME FILE*****
// *****RANDOM LETTERS*****
// *****CALCULATE SCORE*****
// *****VALID WORD*****

// Ref: RightWordsDisplay.java

public class Content{

  /**----------Attributes----------*/
  private String words = "<html>";
  private String output = "";
  private String[] letters;
  private String scoreText = "Score: 0";
  private int score = 0;

  /**----------Methods----------*/

  /** Constructor */
  public Content(){}

  // updates output
  public String updateOutput(String letter){
    output = output + letter;
    return output;
  }

  // clears output
  public String clearOutput(){
    output = "";
    return output;
  }

  // gets random letters
  public String[] getLetters(){
    letters = new String[]{"L1", "L2", "L3", "L4", "L5", "L6", "L7"};
    return letters;
  }

  // updates guessed words
  public String updateWords(){
    words += output + "<br>";
    score += 1;
    scoreText = "Score: " + score;
    return words;
  }

  // clears guessed words
  public String clearWords(){
    words = "<html>";
    return words;
  }

  // updates score and scoreText
  public String clearScore(){
    score = 0;
    scoreText = "Score: 0";
    return scoreText;
  }

  // gets scoreText
  public String getScoreText(){
    return scoreText;
  }
}
