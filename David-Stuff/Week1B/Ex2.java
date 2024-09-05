import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {

    Scanner scanner = new Scanner(System.in);

    public double Maxim (int nr)
    {
        if (nr == 0) {
            return 0;
        }
            
        double rez;
        System.out.println("Enter number 1");
        rez = scanner.nextDouble();

        for (int i = 1; i < nr; i++) {
            System.out.println("Enter number " + (i + 1));
            double y = scanner.nextDouble();
            rez = Math.max(rez, y);
        }
        scanner.close();
        return rez;
    }

    public static void main(String[] args) {
        int nr;
        System.out.println("Input the number of numbers lol:");

        System.out.println(nr);
    }
}
