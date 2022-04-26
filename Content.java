/**
  * Content.java
  * @author Chirag Aggarwal
  * @description Updates Content in the All The Right Words Game
  * @version 1.0 2022-04-22
*/

// ***NOTES***
// Ref: RightWordsDisplay.java & RightWordsGame.java
// Most methods are from these files
// Some methods have changes such as updateWords()

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Content{

  /**----------Attributes----------*/
  private String words = "<html><br>";
  private String output = "";
  private String[] letters;
  private String scoreText = "Score: 0";
  private int score = 0;
  private String[] bag = {"A","A","A","A","A","A","A","A","A","B","B","C","C",
  "D","D","D","D","E","E","E","E","E","E","E","E","E","E","E","E","F","F","G",
  "G","G","H","H","I","I","I","I","I","I","I","I","I","J","K","L","L","L","L",
  "M","M","N","N","N","N","N","N","O","O","O","O","O","O","O","O","P","P","Q",
  "R","R","R","R","R","R","S","S","S","S","T","T","T","T","T","T","U","U","U",
  "U","V","V","W","W","X","Y","Y","Z"};
  private Random rand = new Random();
  private ArrayList<String> lettersList;

  /**----------Methods----------*/

  /** Constructor */
  public Content(){}

  // Updates output
  public String updateOutput(String letter){
    output = output + letter;
    return output;
  }

  // Clears output
  public String clearOutput(){
    output = "";
    return output;
  }

  // Gets random letters
  public String[] getLetters(){
    letters = getOptions(7);
    return letters;
  }

  // Updates guessed words
  public String updateWords(){
    int word_score = 0;
    if (isFromLetters(output, letters)){
      if (output != ""){
        // Checks if the output is a valid word and updates score
        if (isValid(output)){
          if (!words.contains(output)) // Checks for repeat
            word_score = scoreCalc(output);
            score = score + word_score;
        }
        else{
          if (!words.contains("<br>" + output + " ")) // Checks for repeat
            word_score = -1 * scoreCalc(output);
            score = score + word_score;
        }
        // Updates the scoreBoard
        scoreText = "Score:  " + score + " ";
        // Update words string
        if (!words.contains("<br>" + output + " ")){ // checks for repeat
          if (words == ""){
            words = words + output + " " + word_score + "<br>";
          }
          else{
            words = words + output + " " + word_score + "<br>";
          }
        }
      }
    }
    return words;
  }

  // Clears guessed words
  public String clearWords(){
    words = "<html>";
    return words;
  }

  // Updates score and scoreText
  public String clearScore(){
    score = 0;
    scoreText = "Score: 0";
    return scoreText;
  }

  // Gets scoreText
  public String getScoreText(){
    return scoreText;
  }

  // Uses the  bag of letters to construct an array of n letters
  public String[] getOptions(int n){
    lettersList = new ArrayList<String>();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    int number;
    while(lettersList.size()<n){
      number = rand.nextInt(bag.length);
      if (! numbers.contains(number)){
        numbers.add(number);
        lettersList.add(bag[number]);
      }
    }
    return lettersList.toArray(new String[lettersList.size()]);
  }

  // Uses valid_words.txt to check if the word provided is a valid word
  public Boolean isValid(String answer){
    Boolean valid = false;
    try{
      File validWords = new File("valid_words.txt");
      Scanner readFile = new Scanner(validWords);
      while (readFile.hasNextLine()){
        String data = readFile.nextLine();
        if (data.equals(answer)){
          valid = true;
          System.out.println(data); // To check what the Data is (debugging)
          break;
        }
      }
      readFile.close();
    }
    catch (FileNotFoundException exception) {
    System.out.println("An error occurred.");
    exception.printStackTrace(); // Prints error
    }
    return valid;
  }

  // Checks if the word provided consists only of the letters provided
  public Boolean isFromLetters(String word, String[] letterArray){
    ArrayList<String> letterList = new ArrayList<String>(Arrays.asList(letterArray));
    Boolean valid = true;
    for (int i = 0; i < word.length(); i++){
      char letter = word.charAt(i);
      if (letterList.contains(String.valueOf(letter))){
        int index = letterList.indexOf(String.valueOf(letter));
        letterList.remove(index);
      }
      else{
        valid = false;
      }
    }
    return valid;
  }

  // Calculates the score of a word
  public int scoreCalc(String word){
    int points = 0;
    for (int i = 0; i < word.length(); i++){
      char letter = word.charAt(i);
      switch(letter){
        case 'D': case 'G':
          points = points + 2;
          break;
        case 'B': case 'C': case 'M': case 'P':
          points = points + 3;
          break;
        case 'F': case 'H': case 'V': case 'W': case 'Y':
          points = points + 4; //points = 4
          break;
        case 'K':
          points = points + 5;
          break;
        case 'J': case 'X':
          points = points + 8;
          break;
        case 'Q': case 'Z':
          points = points + 10;
          break;
        default:
          points = points + 1;
          break;
      }
    }
    return points;
  }
} // End of Content Class
