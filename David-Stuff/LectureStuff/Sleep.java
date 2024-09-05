import java.util.Scanner;
public class Sleep {
    /*
     *  How to do input in java
     *  import java.util.Scanner;
     * 
     *  scanner.nextInt, scanner.nextDouble etc.
     *  scanner.hasNextInt, scanner.hasNextDouble etc.
     * 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i ;
        i = scanner.nextInt();

        System.out.println(scanner.hasNextInt());
    }

}