import java.util.Scanner;

public class Conversion{
    Scanner scanner = new Scanner(System.in);

    public void Conversion(){
        double Fanrenheit;


        System.out.println("Please input a temperature in Fanrenheit");
        while(scanner.hasNextDouble()){
            Fanrenheit = scanner.nextDouble();
            System.out.printf("Your input of %1.1f degrees Fanrenheit is equal to %1.1f degrees Celsius %n",Fanrenheit, (Fanrenheit - 32)/1.8);
        }
    }


}