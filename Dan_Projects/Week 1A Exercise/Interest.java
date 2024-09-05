import java.util.Scanner;


public class Interest{
    Scanner scanner = new Scanner(System.in);
    public void calculateInterest() {
        double balance; /**in Euro */
        double rate;

        System.out.print("How much money you got: ");
        balance = scanner.nextDouble();

        System.out.print("Give interest rate as a percentage: ");
        rate = scanner.nextDouble();
        balance = (balance + (balance * rate / 100));
        System.out.println("After a year, your balance is EUR " + balance);
    }

    public static void main(String[] args){
       new Interest().calculateInterest();
    }
}