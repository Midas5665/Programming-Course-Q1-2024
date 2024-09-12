
import java.util.Scanner;

public class Columnism{

    Scanner scanner = new Scanner(System.in);
    public void Columnism(){
        int rows;
        int columns;
        int sum=0;

        System.out.println("Input Data");
        rows=scanner.nextInt();
        columns=scanner.nextInt();

        int[][] mat = new int[columns+1][rows+1];

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                mat[i][j]=dataCheck(scanner.nextInt());
            }
        }

        for(int j=0;j<columns; j++){
            sum=0;
            for(int i=0; i<rows-1; i++){
                sum += mat[i][j];
            }
            mat[rows-1][j]=sum;
        }
        System.out.println("--------------");
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                //System.out.print(mat[i][j]+" ");
                System.out.printf("%-4d", mat[i][j]);
            }
            System.out.println("");
        }
    }

     public int dataCheck(int x){
        if(-100 < x  && x < 1000){
            return x;
        }else{
            System.out.println("Input error");
            return scanner.nextInt();
        }
    }
}