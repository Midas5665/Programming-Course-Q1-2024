import java.util.*;

/**
 * Simple number guessing game for computers.
 * 
 * Think of a number and type "go". Your computer starts guessing
 * your number. Reply "lower" when the guess is too high, "higher" 
 * when it is too low, and "guessed" when the computer guessed
 * your number correctly.
 * Ok so computer game. The basic plan is to use scanner to 
 * make the computer modify the random pool where it will take numbers from.
 * 
 * @author Dediu David Gabriel
 * @ID <2096676>
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @data  14/09/2024
 */
public class ComputerGame {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    void run() {
        // TODO: Implementation
        System.out.println("Think of a secret number between not smaller than 0 and not greater than 999. Type 'go' when you have one.");

        // END TODO
    }
    //Random borders: rand = rand.nextInt(topBorder-bottomBorder + 1) + bottomBorder

    public void gameStart(){

        int numberOfGuesses = 10;
        int bottomBorder = 0;
        int topBorder = 1000;
        String response = "";
        Boolean hasGuessed = false;
        //int guessedNumber = rand.nextInt(bottomBorder, topBorder);
        //System.out.println(guessedNumber);
        //numberOfGuesses--;
        
        //scanner.hasNext();

        if (scanner.next().equals("go")) {

            while (numberOfGuesses != 0 && !hasGuessed) {
                int middle = (topBorder + bottomBorder) / 2;
                numberOfGuesses--;
                System.out.println(middle);
                response = scanner.next();

                switch (response) {
                    case "higher": {
                        bottomBorder = middle;
                    } 
                        break;
                    case "lower": {
                        topBorder = middle;
                    }
                        break;
                    case "guessed": {
                        hasGuessed = true;
                    }
                        break;
                    default:


                }
            }
            if (numberOfGuesses == 0 && !response.equals("guessed")) {
                System.err.println("I give up");
            }

        }
    }

    public static void main(String[] args) {
            new ComputerGame().run();
    }
}
