import java.util.Scanner;

public class Interest {

    Scanner scanner = new Scanner(System.in);
    double interest = 2.5;

    public void InterestAgain(){

        
        double balance;
        
        System.out.println("How much ya got:");
        balance=balanceCheck(scanner.nextDouble());

        System.out.println("In one year you'll have " + (balance + balance*interest/100));

        
    }

    public double balanceCheck(double x){
        if(x>=10000){
            interest += 0.5;
        }else if(x<0){
            interest -=0.5;
        }
        
        return x;
    }
    
    
    public static void main(String[] args) {
        new Interest().InterestAgain();
    }
}
