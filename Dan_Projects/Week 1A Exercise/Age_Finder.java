import java.util.Scanner;

/*test cases
DOB: 19930523,20000107, 20000101, 19900725,19900725,19900300
CD:20140524, 20000108, 20240102,20250621,20250720,20000002

*/

public class Age_Finder {
    Scanner scanner = new Scanner(System.in);

    public void Calculate_Age() {
                    //int DOB;
                    //int CD; 
                    int Age;
    
    System.out.println("Please give the date of your birth in the yyyymmdd format: ");
    Age = dateCheck(scanner.nextInt()) * (-1);
    //DOB = scanner.nextInt();
    System.out.println("Please do the same, but for today's date: ");
    Age = (Age + dateCheck(scanner.nextInt()))/10000;
    //CD = scanner.nextInt();
    
    //Age = (CD-DOB)/10000;
   
    System.out.println("You are " + Age + " years old");
    
}   

    public int dateCheck(int x){
        if( x%10== 0 || x/100%100 == 0 || x/10000 == 0 || x >= 100000000){
            System.out.println("Incorrect input. Try again");
            x= scanner.nextInt();
            return x;
        }
        return x;

    }
    
    
    public static void main(String[] args){
        new Age_Finder().Calculate_Age();
     }
}
