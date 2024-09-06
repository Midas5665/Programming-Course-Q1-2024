
import java.util.Scanner;
import java.util.Arrays;
public class Ex1 {
    double balance;
    
    Ex1(double x) {
        balance = x;
    }
    void calculateBalance() {
        double interestRate = 2.5;

        if (balance < 0)
            interestRate -= .5;
        if (balance >= 10000)
            interestRate += .5;
        
        balance += balance * interestRate / 100;

        
        
        

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance;


        

        System.out.println("Enter your balance: \n");
        balance = scanner.nextDouble();
        Ex1 thing = new Ex1(balance);
        thing.calculateBalance();
        System.out.println(thing.balance);

        
    }
}
