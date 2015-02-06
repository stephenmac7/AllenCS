import java.util.*;

class Hangman {
  
  /* We're going to make a hangman game!
   * Read the documentation and fill in the missing pieces of code   */
  
  // First, the class variables:  
  private String entireWord = new String();                       // The word to be guessed
  private List<Character> word = new ArrayList<Character>();      // An ArrayList of single-letter characters that contain the word
  private int wordLength;                                         // The length of the word
  private int turns = 6;                                          // The number of incorrect guesses the user is allowed to have
  private List<Boolean> correct = new ArrayList<Boolean>();       // An ArrayList of whether each letter in the word has been guessed or not
  Scanner scan = new Scanner(System.in);                          // So we can accept user input
  
  void enterWord() {
    // Prompt the user to enter the word to be guessed
    System.out.print("Enter the word: ");
    // Assign the String entered to entireWord
    entireWord = scan.next();
    scan.nextLine();
    // Get the length of the word, important for traversing the ArrayList looking for matching characters
    this.wordLength = entireWord.length();
    /* I'm doing this loop for you because the charAt method isn't on the AP test so you don't need to know about it
     * What this loop does is take the characters one at a time from entireWord and place them in the array list word */
    for (int i = 0; i < this.wordLength; i++)
      word.add(entireWord.charAt(i));
    /* OK, now you get to do something: write a loop to set the ArrayList correct to false, since
     * the player has not guessed any letters yet     */
    for (int i = 0; i < wordLength; i++) {
      correct.add(false);
    }

    // This statement is here to place some blank lines before player 2 starts guessing
    for (int i = 0; i < 20; i++)
      System.out.println();
  }
  
  void checkWord() {
    // This method lets the user input a guess. First, getting a character from the user:
    char c;
    System.out.print("Enter a guess: ");
    try {
      c = Character.toLowerCase((char) System.in.read());
      scan.nextLine();
    } catch(java.io.IOException e) {
      c = ' ';
    }
    // Another temporary boolean because of the whole ArrayList method thing
    boolean cc = false;
    /* OK. What you need to do is traverse through the ArrayList word and see if c (the letter guessed by the player)
     * is the same as any of the letters. If it is, the ArrayList correct at that index needs to be set to true     */

    for (int i = 0; i < wordLength; i++) {
      if (Character.toLowerCase(word.get(i)) == c) {
        cc = true;
        correct.set(i, true);
      }
    }
    
    // Finally, if the user has NOT guessed a letter correctly this turn, the number of turns needs to go down by 1
    if (!cc) {
      turns--;
    }
  }
  
  void printWord() {
    /* This method prints out the word
     * If the letter has been guessed, print the letter
     * If not, print a _ */
    for (int i = 0; i < wordLength; i++) {
      if (correct.get(i))
        System.out.print(word.get(i));
      else
        System.out.print("_");
    }
    System.out.println();
    
    // Finally, print out how many guesses the player has left
    System.out.println("You have " + turns + " guesses left.");
  }

  boolean checkWin() {
    /* Check to see if the user has won. If all of the boolean values in the ArrayList correct are true,
     * then the user has won and you should return true.
     * If not, return false */
    for (boolean b : correct) {
      if (!b) {
        return false;
      }
    }
    return true;
  }
  
  /* It's good practice to use private for variables in a class, so outside users can't change values
   * These two methods are used to get the String entireWord and int turns        */
  String getEntireWord() {
    return entireWord;
  }
  
  int getTurns() {
    return turns;
  }
}