import java.util.Scanner;
/**
 * Summation sums a sequence of integer numbers.
 * 
 * @author ...
 * @date ...
 */
class Product0{
    Scanner scanner = new Scanner(System.in);

    void doProduct() {
        int product = 1; // the running sum
        
        int number; // the number just read

        while (scanner.hasNextInt()) {
            number = scanner.nextInt();
            if(number == 0){
                break;
            }
            product *= number;
        }

        System.out.println("Product is " + product);
    }

    public static void main(String[] args) {
        new Product0().doProduct();
    }
}
