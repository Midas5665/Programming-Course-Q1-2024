import java.util.*;

public class RandomBingoCardCreator extends BingoCard implements BingoCardCreator {
    int maximumNumber=9;
    int minimumNumber=0;
    int[][] bingoNumbers = new int[5][5];
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    

    public RandomBingoCardCreator() {
        this.maximumNumber = scanner.nextInt();
        this.minimumNumber = scanner.nextInt();
    }

    @Override

    public void readCard(){
        for(int i =0; i<5;i++){
            for(int j = 0; j < 5; j++){
                bingoNumbers[i][j]= random.nextInt(maximumNumber + 1) + minimumNumber;
            }
        }
    }

    @Override
    public String toString() {  
        System.out.println("");
        for (int i = 0; i < 5; i++) {
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


    public static void main(String[] args) {
        RandomBingoCardCreator rand = new RandomBingoCardCreator();
        BingoCard bingo = new BingoCard();
        rand.readCard();
        System.out.print(rand);

    }
}
