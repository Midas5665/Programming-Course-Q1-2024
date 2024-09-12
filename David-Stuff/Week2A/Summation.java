import java.util.Scanner;
/**
 * Summation sums a sequence of integer numbers.
 * 
 * @author ...
 * @date ...
 */
class Summation {
    Scanner scanner = new Scanner(System.in);

    void doSummation() {
        int sum = 1; // the running sum
        
        int number; // the number just read
        number = scanner.nextInt();
        sum *= number;

        while (number != 0 && scanner.hasNextInt()) {

            number = scanner.nextInt();
            if(number != 0)
                sum *= number;
        }

        System.out.printf("The product is %d", sum);
    }

    public static void main(String[] args) {
        new Summation().doSummation();
    }
}
