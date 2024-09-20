import java.util.*; // For Scanner, Random, etc.

/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
 * Documentation
 *  
 *  The program generates a random value between 0 and 100 using the Random class.
 *  The user gets 7 chances to guess the value. The program takes input while
 *  the value has not been guessed or the user still has available guesses.
 *  With every wrong guess, the program displays the message "lower" if the
 *  The number guessed by the user is lower than the randomly generated value, 
 *  or the message "higher" if the number is greater.
 * 
 *  If the user guesses the randomly generated value the message the message
 *  "Good guess! You won." will be displayed.
 * 
 *  If the random value was guessed or the user has used all of their attempts,
 *  the program will display all of the guesses. For all values from 0 to 99 that
 *  are not equal to the random value or the number guessed by the user, a "." will
 *  be displayed. For the value equal to the user's guess, an "X" will be displayed 
 *  and for the randomly generated value, a "|" will be displayed.
 *  If the user's guess is equal to the randomly generated value, only an X will be
 *  displayed.
 *  This process is repeated for each guess, in chronological order.
 * 
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 * @data  14/09/2024
 */
public class HumanGame {
    Scanner sc = new Scanner(System.in);
    Random randomGenerator;

    void run() {
        
        // TODO: Implementation
        Scanner sc = new Scanner(System.in);
        long seed;
        ArrayList<Integer> guesses = new ArrayList<>(); 

        //Array list that will memorise the user's guesses in the order they were submited

        int numberOfGuesses = 7;

        System.out.println("Type an arbitrary number");
        seed = sc.nextLong();
        Random rand = new Random(seed);

        int n = rand.nextInt(100); // Generate a random number between 0 and 99
        System.out.println("Start guessing!");

        int userInput;
        userInput = sc.nextInt();
        numberOfGuesses--;
        guesses.add(userInput);

        if (userInput < n) {
            System.out.println("higher");
        }
        if (userInput > n) {
            System.out.println("lower");
        }
        if (userInput == n) {
            System.out.println("Good guess! You won.");
        }
        while (userInput != n && numberOfGuesses > 0 && sc.hasNextInt()) {
            userInput = sc.nextInt();
            numberOfGuesses--;
            guesses.add(userInput);
            if (userInput < n) {
                System.out.println("higher");
            }
            if (userInput > n) {
                System.out.println("lower");
            }
            if (userInput == n) {
                System.out.println("Good guess! You won.");
            }
            if (numberOfGuesses == 0 && n != userInput) {
                System.out.println("No more guesses, you lost.");
            }
        }
        sc.close(); 
        System.out.println((7 - numberOfGuesses) + " guesses:");

        for (int i : guesses) {
            for (int j = 0; j <= 99; j++) {
                if (j == n && i != n) {
                    System.out.print("|");
                }
                if (j == i) {
                    System.out.print("X");
                }
                if (j != i && j != n) {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        // END TODO
    }

    public static void main(String[] args) {
        new HumanGame().run();
    }
}
