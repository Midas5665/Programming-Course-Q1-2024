import java.util.Scanner;


public class Interest{
    Scanner scanner = new Scanner(System.in);
    public void calculateInterest() {
        double balance; /**in Euro */
        double rate;
        double tax;

        System.out.print("How much money you got: ");
        balance = scanner.nextDouble();

        System.out.print("Give interest rate as a percentage: ");
        rate = scanner.nextDouble();

        System.out.print("How much is the tax as a percentage: ");
        tax = scanner.nextDouble();


        balance = (balance + (balance * rate / 100));  
         /**I chose to calculate the new balance before the print statement, since it 
         makes the code cleaner and easier to handle in the future modifications of 
        the code. Had the objective of this program would have been something that 
        required different versions of the balance depending on the choice, not 
        relying only on interest, I would have calculated it in the print statement */
        System.out.println("After a year, your balance is EUR " + balance);
        System.out.println("You'll have to pay in taxes: " + balance * tax /100);

    }

    public static void main(String[] args){
       new Interest().calculateInterest();
    }
}