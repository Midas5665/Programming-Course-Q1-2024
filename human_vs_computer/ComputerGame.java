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
 * @id     2155699
 * @author TODO
 * @id     TODO
 * @data   TODO
 */
public class ComputerGame {
    Scanner scanner = new Scanner(System.in); //Building a new scanner object
     
    public void run(){

        int numberOfGuesses = 10;   //Defining the main variables needed at the start of 
        int bottomBorder = 0;       //the main constructor.
        int topBorder = 999;
        String response;    //Response will be used to communicate to the computer
        String startWord;   //the validity of its guess, while startWord serves as
        int guessedNumber;  //a one time variable to cleanly start the process

        
        System.out.println("Think of a secret number between not smaller"
            + "than 0 and not greater than 999. Type 'go' when you have one."); 
        //A small guide for first time users
        startWord = scanner.next();
        
        while (numberOfGuesses != 0 && startWord.equals("go")){
            guessedNumber = (bottomBorder + topBorder) / 2; //The basis of binary search,
            System.out.println(guessedNumber);              //we make our computer 'guess'
            numberOfGuesses--;                              //the middle number of its allowed 
            response = scanner.next();                      //borders, those borders shrinking
            if (numberOfGuesses == 0) {                     //after every response. Each repetition
                System.out.println("I give up");          //of this loop decreases the number of 
            }   //Computer's response to                    //allowed guesses for the computer.
            //running out of guesses

            switch (response) {                             //These blocks of code dictate the
                case "lower":                               //computer's answer to all possible 
                    topBorder = guessedNumber;              //options of responses to its guess.
                    break;                                  //At 'higher', the lower border 
                case "higher":                              //increases. For 'lower', it
                    bottomBorder = guessedNumber;           //decreases. For 'guessed', the
                    break;                                  //process ends. For any other
                case "guessed":                             //input, the number of guesses
                    numberOfGuesses = 0;                    //remain the same, nothing 
                    scanner.close();                        //changing.
                    break;
                default:
                    numberOfGuesses++;
                }
                
            
                

            
        }
    }

    public static void main(String[] args) {    //The main method, where the computer game 
        new ComputerGame().run();               //class method 'run' is used.
    }
}
