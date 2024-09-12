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
        int sum = 0; // the running sum
        int count = 0;
        int number; // the number just read

        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            sum += number;
            count++;
        }

        System.out.println("Sum is " + sum);
    }

    public static void main(String[] args) {
        new Summation().doSummation();
    }
}
