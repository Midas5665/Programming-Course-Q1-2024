import java.util.Scanner;

interface BingoCardCreator{
    void readCard();
}


public class BingoCard implements BingoCardCreator{
    public static final int CARD_SIZE = 5;
    Scanner scanner = new Scanner(System.in);

    int[][] bingoNumbers = new int[CARD_SIZE][CARD_SIZE];
    int n;

    public void BingoCard(){
        
    }

    @Override
    public String toString() {  
        System.out.println("");
        for (int i = 0; i < CARD_SIZE; i++) {
            for (int j = 0; j < CARD_SIZE; j++) {
                if(bingoNumbers[i][j]==0){
                    System.out.print("  ");
                }
                else{
                    System.out.print(bingoNumbers[i][j] + " ");
                }
                
                
            }
            System.out.println("");
        }
        return "";
    }

    /**
     * .
     */
    @Override

    public void readCard() {
        for (int i = 0; i < CARD_SIZE; i++) {
            for (int j = 0; j < CARD_SIZE; j++) {
                bingoNumbers[i][j] = scanner.nextInt();
            }
            
        }
    }

    public static void main(String[] args) {
        BingoCard bingo = new BingoCard();
        bingo.readCard();
        System.out.println(bingo);
    }


}