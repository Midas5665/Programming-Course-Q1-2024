/**
 * greeter
 */
import java.util.Scanner;
class greeter {
    int age;
 
    greeter(int x)
    {
        age = x;
    }
    void greet()
    {
        System.out.println((int) age);

    }

    public static void main(String[] args)
    {
        int input;
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        
        greeter ac = new greeter(18);
        ac.greet();
    }
    
}