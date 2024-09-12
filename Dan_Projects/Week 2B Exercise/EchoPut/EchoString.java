import java.util.ArrayList;
import java.util.Scanner;

/**
 * Echo input to output
 * 
 * @author ...
 * @date ...
 */
public class EchoString {
    Scanner scanner = new Scanner(System.in);

    void echo() {
        ArrayList<String> ns = new ArrayList<>(); // Store numbers read from input

        String n = scanner.next(); // Last number read from input

        while (n.equals("END")==false) {
            ns.add(n);
            n = scanner.next();
        }

        for (int i = ns.size()-1; i >= 0; i--) {
            System.out.println(ns.get(i));
        }
    }

    public static void main(String[] args) {
        new EchoString().echo();
    }
}
