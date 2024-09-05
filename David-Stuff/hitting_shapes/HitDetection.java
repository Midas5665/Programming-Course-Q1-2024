import java.util.Scanner;
/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * TODO: Documentation
 * 
 * END TODO
 * 
 * @author <Dediu David Gabriel>
 * @ID <ID STUDENT 1>
 * @author <Vasilescu Dan Gabriel>
 * @ID <ID STUDENT 2>
 * 
 */
class HitDetection {
    
    public void run() {

        // TODO: Hit detection

        double xCoordFirst;
        double yCoordFirst;
        double radiusFirst;

        double xCoordSecond;
        double yCoordSecond;
        double radiusSecond;

        double xCoordPoint;
        double yCoordPoint;

        Scanner scanner = new Scanner(System.in);

        xCoordFirst = scanner.nextDouble();
        yCoordFirst = scanner.nextDouble();
        radiusFirst = scanner.nextDouble();

        xCoordSecond = scanner.nextDouble();
        yCoordSecond = scanner.nextDouble();
        radiusSecond = scanner.nextDouble();

        xCoordPoint = scanner.nextDouble();
        yCoordPoint = scanner.nextDouble();

        //Check whether either of the provided radiuses is negative

        if (radiusFirst < 0 || radiusSecond < 0) {
            System.out.println("input error");
            return;
        }

        /*
        * Compute the distance between the point to the centers of both of  
        * the circles using the following formula : 
        * Distance = sqrt( (x1-x2)^2 + (y1-y2)^2 )
        */  

        double distanceFirst;
        double distanceSecond;

        distanceFirst = Math.sqrt(Math.pow(xCoordFirst - xCoordPoint,2) + Math.pow(yCoordFirst - yCoordPoint,2));
        distanceSecond = Math.sqrt( Math.pow(xCoordSecond - xCoordPoint, 2) + Math.pow(yCoordSecond - yCoordPoint,2) );
        System.out.println(distanceFirst);
        System.out.println(distanceSecond);
        if (distanceFirst <= radiusFirst && distanceSecond <= radiusSecond) {
            System.out.println("The point hits both circles");
            return;
        }
        if (distanceFirst <= radiusFirst) {
            System.out.println("The point hits the first circle");
            return;
        }
        if (distanceSecond <= radiusSecond) {
            System.out.println("The point hits the second circle");
            return;
        }
        System.out.println("The point doesn't hit shit");
        // END TODO
    }

    public static void main(String[] args) {
        System.out.println("The program has started \n");
        new HitDetection().run();
    }
}