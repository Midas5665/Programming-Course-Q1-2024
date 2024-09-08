
import java.util.Scanner;
/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * TODO: Documentation
 * 
 * END TODO
 * 
 * @author < Dediu David Gabriel>
 * @ID <ID STUDENT 1>
 * @author < Vasilescu Dan Gabriel>
 * @ID <2155699>
 * 
 */
class HitDetection {

    Scanner scanner = new Scanner(System.in);

    public void run() {
        // TODO: Hit detection
        double cordX1;
        double cordY1;
        double radius1;
        double cordX2;
        double cordY2;
        double radius2;
        double pointX;
        double pointY;


        System.out.println("Please gimme input"); //Temporary
        cordX1 = scanner.nextDouble();
        cordY1 = scanner.nextDouble();
        radius1 = errorCheck(scanner.nextDouble());
        cordX2 = scanner.nextDouble();
        cordY2 = scanner.nextDouble();
        radius2 = errorCheck(scanner.nextDouble());
        pointX = scanner.nextDouble();
        pointY = scanner.nextDouble();

        if (inCircle(distanceCalc(cordX1, cordY1, pointX, pointY), radius1) 
            && inCircle(distanceCalc(cordX2, cordY2, pointX, pointY), radius2)) {
            System.out.println("The point hits both circles");
        }
        else if (inCircle(distanceCalc(cordX1, cordY1, pointX, pointY), radius1)) {
            System.out.println("The point hits the first circle");
        }
        else if (inCircle(distanceCalc(cordX2, cordY2, pointX, pointY), radius2)) {
            System.out.println("The point hits the second circle");
        }
        else {
            System.out.println("The point does not hit either circle");
        }

        
        // END TODO
    }

    public static double errorCheck(double radius) {
        if (radius < 0) {
            System.out.println("input error");
            return 0;
        }
        return radius;
    }
    public static boolean inCircle(double x, double y){
        if(x <= y){
            return true;
        }   
        return false;
    }


    public static double distanceCalc(double x, double y, double q, double z){
        return Math.sqrt(Math.pow((q - x), 2) + Math.pow((y - z), 2));
    }
    public static void main(String[] args) {
        new HitDetection().run();
    }
}