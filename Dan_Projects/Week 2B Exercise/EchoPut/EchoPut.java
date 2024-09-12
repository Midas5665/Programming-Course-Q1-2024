import java.util.ArrayList;
import java.util.Scanner;

/**
 * Echo input to output
 * 
 * @author ...
 * @date ...
 */
public class EchoPut {
    Scanner scanner = new Scanner(System.in);

    void echo() {
        ArrayList<Integer> ns = new ArrayList<>(); // Store numbers read from input

        int n = scanner.nextInt(); // Last number read from input

        while (n != -1) {
            ns.add(n);
            n = scanner.nextInt();
        }

        for (int i = 0; i < ns.size(); i++) {
            System.out.println(ns.get(i));
        }
    }

    public static void main(String[] args) {
        new EchoPut().echo();
    }
}
