import java.util.*; // For Scanner, Random, etc.

/** 
 * Number guessing game for humans.
 * 
 * Enter a seed number, and the computer will think of a number between 0 and
 * 99 that you have to guess in at most seven tries. Afterwards, you see your
 * guessing history so you can learn to better play the game.
 * 
<<<<<<< HEAD
=======
 * @author Dediu David Gabriel
 * @ID <2096676>
>>>>>>> b88dd85324f0c6d5d7dd0cd7a69682991b59f889
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
        int numberOfGuesses = 7;

        System.out.println("Type an arbitrary number");
        seed = sc.nextLong();
        Random rand = new Random(seed);

        int n = rand.nextInt(100);
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
<<<<<<< HEAD
        System.out.println((7-numberOfGuesses) + " guess" 
        + ( 7-numberOfGuesses == 1 ? " :" : "es :"));
=======

        System.out.println((7 - numberOfGuesses) 
            + " guess" + (7 - numberOfGuesses == 1 ? " :" : "es :"));
>>>>>>> b88dd85324f0c6d5d7dd0cd7a69682991b59f889

        for (int i : guesses) {
            for (int j = 0; j < 99; j++) {
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
