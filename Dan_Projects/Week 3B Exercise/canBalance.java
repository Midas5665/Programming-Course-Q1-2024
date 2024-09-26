public class canBalance{
    boolean canBalancePlus(int[] nums) {
        for(int i=0; i<nums.length;i++){
          if(segmentSum(nums, i, nums.length)==segmentSum(nums, 0, i)){
            return true;
          }
        }
          
        return false;
        
      }
      
      
      
      int segmentSum(int[] nums, int from, int upto) {
        int sum=0;
        for(int i = from; i<upto; i++){
          sum += nums[i];
        }
        return sum;
        }


    public static void main(String[] args){
        //add an array for which you want to check if it can be divided to have an equal sum on both sides
    }
}