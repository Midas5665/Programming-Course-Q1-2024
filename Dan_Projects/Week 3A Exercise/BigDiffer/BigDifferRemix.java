import java.util.*;

class BigDifferRemix {
    Scanner sc = new Scanner( System.in );
    
    void readAndGiveBigDiff() {
        int[] nums = readArray();
        int bigDiff = calculateBigDiff(nums);
        printResult(bigDiff);
    }

    public int[] readArray(){
        System.out.println( "How many values?" );
        int n = sc.nextInt();
        int[] x = new int[n];
        
        System.out.println( "Enter values" );
        /** @inv i numbers from input read and stored in nums[0..i-1] is  */
        for (int i=0; i< x.length; i++ ){
            x[i] = sc.nextInt();
        }
        return x;
    }

    public int calculateBigDiff(int x[]){
        int max = x[0]; //guaranteed to exist
        int min = x[0];
        /** @inv max = max(nums[0..i-1]) &&
          *      min = min(nums[0..i-1]) */
        for (int i=1; i<x.length; i++ ){
            if ( x[i] > max ) {
                max = x[i];
            } else if (x[i]< min) {
                min = x[i];
            }
        }
        int bigDiff = max - min;
        return bigDiff;
    }

    public void printResult(int x){
        System.out.println( "The biggest difference in these values is: ");
        System.out.println( x );

    }
    
    public static void main( String[] a) {
        ( new BigDiffer() ).readAndGiveBigDiff();
    }
}
        
        
    