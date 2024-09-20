import java.util.*;

class BigDiffer {
    Scanner sc = new Scanner( System.in );
    
    void readAndGiveBigDiff() {
        int[] nums;
        int n;
        
        int max;
        int min;
        int bigDiff;
        
        System.out.println( "How many values?" );
        n = sc.nextInt();
        nums = new int[n];
        
        System.out.println( "Enter values" );
        /** @inv i numbers from input read and stored in nums[0..i-1] is  */
        for (int i=0; i<nums.length; i++ ){
            nums[i] = sc.nextInt();
        }
        
        max = nums[0]; //guaranteed to exist
        min = nums[0];
        /** @inv max = max(nums[0..i-1]) &&
          *      min = min(nums[0..i-1]) */
        for (int i=1; i<nums.length; i++ ){
            if ( nums[i] > max ) {
                max = nums[i];
            } else if (nums[i]< min) {
                min = nums[i];
            }
        }
        bigDiff = max - min;
        
        System.out.println( "The biggest difference in these values is: ");
        System.out.println( bigDiff );
    }
    
    public static void main( String[] a) {
        ( new BigDiffer() ).readAndGiveBigDiff();
    }
}
        
        
    