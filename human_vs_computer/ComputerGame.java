import java.util.Scanner; //Importing the java scanner package for future use

/**
 * Simple number guessing game for computers.
 * 
 * This program activates with the help of the string variable startWord. If the user
 * types 'go', the program starts. The computer uses binary search to try and guess a random
 * number thought by the user, its only clues being the confirmation if its guess is lower or higher
 * than the desired number. When the computer guesses correctly, the user responds with
 * 'guessed' and the process ends. Although impossible, if the computer manages to not guess
 * within 10 tries, it prints out 'I give up'.
 * 
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 * @data  14/09/2024
 */
public class ComputerGame {
    Scanner scanner = new Scanner(System.in); //Building a new scanner object
     
    public void run(){

        int numberOfGuesses = 10;   //Defining the main variables needed at the start of 
        int bottomBorder = 0;       //the main constructor.
        int topBorder = 999;
        int guessedNumber;  //a one time variable to cleanly start the process

        String response;    //Response will be used to communicate to the computer
        String startWord;   //the validity of its guess, while startWord serves as
        
        boolean hasGuessed = false; 
        //a one time variable to check for cases in 
        //which the computer guessed with its final attempt
        
        System.out.println("Think of a secret number not smaller "
            + "than 0 and not greater than 999. Type 'go' when you have one."); 
        //A small guide for first time users
        startWord = scanner.next();
        
        while (numberOfGuesses != 0 && startWord.equals("go")){
            guessedNumber = (bottomBorder + topBorder) / 2; //The basis of binary search,
            System.out.println(guessedNumber);              //we make our computer 'guess'
            numberOfGuesses--;                              //the middle number of its allowed 
            response = scanner.next();                      //borders.

            //These borders shrink after every response. Each repetition
            //of this loop decreases the number of allowed guesses for the computer.
            
            
            switch (response) {                             //These blocks of code dictate the
                case "lower":                               //computer's answer to all possible 
                    topBorder = guessedNumber;              //options of responses to its guess.
                    break;                                  //At 'higher', the lower border 
                case "higher":                              //increases. For 'lower', it
                    bottomBorder = guessedNumber;           //decreases. For 'guessed', the
                    break;                                  //process ends. 
                case "guessed":                             
                    numberOfGuesses = 0;                    
                    scanner.close();
                    hasGuessed = true;                        
                    break;
                default:
                    
                }
                
            
                

            
        }
        if (numberOfGuesses == 0 && !hasGuessed) { 
            System.out.println("I give up");
        }   //Computer's response to running out of guesses
        
    }

    public static void main(String[] args) {    //The main method, where the computer game 
        new ComputerGame().run();               //class method 'run' is used.
    }
}
