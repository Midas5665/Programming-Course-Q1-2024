import java.util.Scanner;

public class Aprox {
    Scanner scanner = new Scanner(System.in);
    int n;
    double aprox=0;
    public void Aprox(){
        
        System.out.println("How many iterations do you want");
        n=scanner.nextInt();
        for(int i=0;i<=n;i++){
            aprox += Math.pow(-1,i) * 4/(3+2 * (i-1));
            System.out.printf("%1d %7.15f %+4.15f %n", i, aprox, (aprox-Math.PI));
        }
        System.out.println("Your aproximation is: " + aprox);


        
    }
}