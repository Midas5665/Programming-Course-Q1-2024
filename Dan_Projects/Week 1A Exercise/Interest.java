import java.util.Scanner;


public class Interest{
    Scanner scanner = new Scanner(System.in);
    public void calculateInterest() {
        double balance; /**in Euro */
        double rate;

        balance =250.0;

        System.out.print("Give interest rate as a percentage: ");
        rate = scanner.nextDouble();

        System.out.println(
            "After a year, you have earned " + (balance * rate / 100) + " from interest"
        );

    }

    public static void main(String[] args){
       new Interest().calculateInterest();
    }
}