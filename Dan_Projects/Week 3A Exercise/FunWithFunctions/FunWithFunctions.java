
public class FunWithFunctions {

    public static double f(double x){
        return(Math.pow(x,2) - 2*x -3);
    }

    public static void printTable(){
        System.out.printf("   x    f(x) %n");
        System.out.printf("---------------%n");
        for(double i=-3;i<=3;i+=0.5){
            System.out.printf("%0+-4.1f %1+-4.1f %n", i, f(i));
        }
    }
    public static void main(String[] args) {
        printTable();
    }
}
