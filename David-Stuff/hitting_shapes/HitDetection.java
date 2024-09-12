import java.util.Scanner; //This library will allow us to type in our own input in the console
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
 *  If the distance between the point and the centers is less //or equal to// the circle's radius, 
 *  we can  conclude that the point is situated somewhere in the area of the circle, including 
 *  its border.
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
                           
        /* 
        * The x and y coordinates for the center of the
        * first circle, along with its radius. It's all the 
        * data needed to "build" the first circle.
        */

        double xCoordSecond;  
        double yCoordSecond; 
        double radiusSecond; 

        /*
        * The same procedure, but this
        * time for the second circle.
        */

        double xCoordPoint; 
        double yCoordPoint; 

        /*
        * The x and y coordinates for the point, which will be 
        * later used to determine it's position relative to the two circles. 
        */

        Scanner scanner = new Scanner(System.in); //Creating a new scanner object

        xCoordFirst = scanner.nextDouble();
        yCoordFirst = scanner.nextDouble();
        radiusFirst = scanner.nextDouble();

        xCoordSecond = scanner.nextDouble();
        yCoordSecond = scanner.nextDouble();
        radiusSecond = scanner.nextDouble();

        xCoordPoint = scanner.nextDouble();
        yCoordPoint = scanner.nextDouble(); 

        /*
        * If earlier we defined the variables needed for both circles and the  
        * point, now we feed them values by typing in the console  
        * at the start of every run of the project.
        */

        scanner.close(); //We close the scanner after use
        if (radiusFirst < 0 || radiusSecond < 0) {
            System.out.println("input error");
            return;
        }

        /*
        * This if statement checks for negative inputs for the radiuses. 
        * If true, the program prints out "input error"
        */

        double distanceFirst;
        double distanceSecond;

        distanceFirst = Math.sqrt(Math.pow(xCoordFirst - xCoordPoint, 2) 
        + Math.pow(yCoordFirst - yCoordPoint, 2));
        distanceSecond = Math.sqrt(Math.pow(xCoordSecond - xCoordPoint, 2)
         + Math.pow(yCoordSecond - yCoordPoint, 2));
       
        /*
        * We both declare and calculate the variables for the 
        * distance between the point and the centre of each circle
        * using the formula for distance between two 
        * points on the cartesian coordinate system
        */

        
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

        /*
        * With this triple if statement we check if the distance between the point 
        * and the centre of each circle is less or equal to the radius of the 
        * corresponding circle, which would mean the point is either in the circle or 
        * at the edge of it.
        * If the point hits both cirles, the output of the program would be
        * "The point hits both circles".
        * If it hits only one circle, the output would be "The point hits the first/second circle"
        * depending on which circle the point hit. If the point didn't touch any circles, the
        * output would be "The point does not hit either circle".
        */

            
        // END TODO
    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}
