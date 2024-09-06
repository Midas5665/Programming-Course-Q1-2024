import java.util.Scanner;
/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * TODO: Documentation
 * 
 *  The program takes 8 double-type inputs: the first three (xCoordFirst, yCoordFirst, radiusFirst)
 *  containing the coordinates of center of the first circle and its radius. The next 3 inputs
 *  (xCoordSecond, yCoordSecond, radiusSecond) contain information regarding the coordinates of
 *  the second circle's center and the length of its radius.
 *  First, the program checks whether either one of the radiuses are negative. If that is the case,
 *  the message "input error" will be displayed.
 * 
 *  Using the formula: Distance(P(x1,y1)) = sqrt( (x1-x2)^2 + (y1-y2)^2 ), the program determines 
 *  the distance between the point and the centers of the circles.
 * 
 *  If the distance between the point and the centers is less than the circle's radius, we can 
 *  conclude that the point is situated somewhere in the area of the circle.
 * 
 *  The program checks whether the point hits both of the circles, in which case, the message 
 *  "The point hits both circles" is displayed. If the point does not hit both of the circles 
 *   simultaneously, then the program checks if the point hits either the first or the second 
 *   circle. If the point is not located in either of the areas, then the message: "The point 
 *   does not hit either circle" is displayed.
 * 
 * END TODO
 * 
 * @author <Dediu David Gabriel>
 * @ID <2096676>
 * @author <Vasilescu Dan Gabriel>
 * @ID <2155699>
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

        scanner.close();

        if (radiusFirst < 0 || radiusSecond < 0) {
            System.out.println("input error");
            return;
        }

        double distanceFirst;
        double distanceSecond;

        distanceFirst = Math.sqrt(Math.pow(xCoordFirst - xCoordPoint, 2) 
        + Math.pow(yCoordFirst - yCoordPoint, 2));
        distanceSecond = Math.sqrt(Math.pow(xCoordSecond - xCoordPoint, 2)
         + Math.pow(yCoordSecond - yCoordPoint, 2));

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
        System.out.println("The point does not hit either circle");
        // END TODO
    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}