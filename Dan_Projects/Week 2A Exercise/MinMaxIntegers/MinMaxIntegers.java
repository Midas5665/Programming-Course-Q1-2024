public class MinMaxIntegers{

    public void MaxIntegers(){
        int sum = 0;
        int temp =0;
        for(sum=0; sum >= 0; sum++){
            sum+=sum;
            if(sum>0){
                temp = sum;
            }
        }
        System.out.println(temp);
    }
    public void MinIntegers(){
        int sum2 = 0;
        int temp2 =0;
        for(sum2=0; sum2 <= 0; sum2--){
            sum2-=sum2;
            if(sum2<0){
                temp2 = sum2;
            }
        }
        System.out.println(temp2);
    }
}