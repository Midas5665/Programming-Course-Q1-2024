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
 * @author TODO
 * @id     TODO
 * @author TODO
 * @id     TODO
 * @data   TODO
 */
public class ComputerGame {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    void run() {
        // TODO: Implementation
        System.out.println("Think of a secret number between not smaller than 0 and not greater than 999. Type 'go' when you have one.");
        gameStart();
        //if(scanner.next().equals("go")){
        //    gameStart(); //Debugging. TO BE REMOVED
        //}
        // END TODO
    }
    //Random borders: rand = rand.nextInt(topBorder-bottomBorder + 1) + bottomBorder
    public void gameStart(){
        int numberOfGuesses = 10;
        int bottomBorder=0;
        int topBorder=1000;
        String response;

        //int guessedNumber = rand.nextInt(bottomBorder, topBorder);
        //System.out.println(guessedNumber);
        //numberOfGuesses--;
        
        //scanner.hasNext();
        if(scanner.next().equals("go")){
            //gameStart(); //Debugging. TO BE REMOVED
        
            while(numberOfGuesses != 0){
                int guessedNumber = rand.nextInt(bottomBorder, topBorder);
                System.out.println(guessedNumber);
                System.out.println("Top border: " + topBorder);
                System.out.println("Bottom border: " + bottomBorder);
                numberOfGuesses--;
                response = scanner.next();
            
                if(response.equals("lower")){
                    if(guessedNumber==topBorder){
                        topBorder-=1;
                    }else{
                    topBorder = guessedNumber;
                    }
                    
                } else if(response.equals("higher")){
                    if(guessedNumber==bottomBorder){
                        bottomBorder+=1;
                    }else{
                    bottomBorder = guessedNumber;
                    
                    }
                
                } else if(response.equals("guessed")){
                    scanner.close();
                    numberOfGuesses=0;
                }
            
                if(numberOfGuesses == 0){
                    System.out.println("I give up");
                }

            }
        }
    }

    public static void main(String[] args) {
            new ComputerGame().run();
    }
}
