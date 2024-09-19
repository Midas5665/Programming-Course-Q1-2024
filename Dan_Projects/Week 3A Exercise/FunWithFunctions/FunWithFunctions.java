import java.util.Scanner;
public class FunWithFunctions {

    Scanner scanner = new Scanner(System.in);

    public static double f(double x, double a, double b, double c){
        return( a * Math.pow(x,2) + b*x + c);
    }

    public static void printTable(){
        System.out.printf("   x     f(x) %n");
        System.out.printf("---------------%n");
        int a = 1;
        int b = -2;
        int c = -3;
        for (double i = -3; i <= 3; i += 0.5) {
            System.out.printf("%5.2f   %5.2f %n", i, f(i, a, b, c));
            
        }
    }

    public void functionGame(){
        System.out.println("Give me values for a, b and c");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        System.out.println("Let's play a game. You tell me an x and I'll tell you f(x)." 
            + " When the f(x) is less than 0.001 and greater than -0.001, you win!");
        double x = scanner.nextDouble();
        int y=1;
        while (f(x, a, b, c) < -0.001 || f(x, a, b, c) > 0.001) {
            System.out.println(f(x, a, b, c));
            x = scanner.nextDouble();
            y++;
        }

        if (y == 1) {
            System.out.println("Wow! First try! Lucky guess or something more?");
        } else {
            System.out.println("Congratulations! You're great at math! It only took you " 
                + y + " tries");
        }
    }
    public static void main(String[] args) {
        //printTable();
        FunWithFunctions game = new FunWithFunctions();
        game.functionGame();
    }
}
