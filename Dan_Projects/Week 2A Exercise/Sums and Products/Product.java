import java.util.Scanner;
/**
 * Summation sums a sequence of integer numbers.
 * 
 * @author ...
 * @date ...
 */
class Product{
    Scanner scanner = new Scanner(System.in);

    void doProduct() {
        int product = 1; // the running sum
        
        int number; // the number just read

        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            product *= number;
        }

        System.out.println("Product is " + product);
    }

    public static void main(String[] args) {
        new Product().doProduct();
    }
}
