import java.util.Scanner;

public class MONEY {

    Scanner scanner = new Scanner(System.in);

    public void Money(){
        double Euros;
        double Dubbeltjes;
        String euro = "euro";  
        double MLength = 0;


        String[] t = {
            "Result: 1 euro plus 7 dubbeltjes is 1,70",
            "Result: 1 euro plus 7 dubbeltjes is 1,7000",
            "Result: 1 euro plus 7 dubbeltjes is 1,70000000",
            "Result: 1 euro plus 7 dubbeltjes is 1,7000000000000000"
        };

        for(String string: t){
            if(MLength < string.length()){
                MLength = string.length();
            }
        }
        System.out.println("How many euros and how many dubbeltjes do you have?");
        Euros = scanner.nextDouble();
        Dubbeltjes = scanner.nextDouble();
        
        
        System.out.println("Euros: " +  Euros);
        System.out.println("Dubbeltjes: " + Dubbeltjes);
        
        // for(int i=0;i<=3;i++){
        //     System.out.printf("%-" + MLength + "s", t[i]);
        //     System.out.printf("euro %n");
        // }
        // System.out.printf("%-" + MLength + "s euro", t[0]);
        System.out.println(t);       
        for(String string: t){
            System.out.printf("%-" + MLength + "s euro %n\n", string);
        }






        //System.out.printf("Result: %1.0f euro plus %1.0f dubbeltjes is %1.2f %18s %n", Euros,Dubbeltjes,(Euros+ Dubbeltjes/10), euro);
        //System.out.printf("Result: %1.0f euro plus %1.0f dubbeltjes is %1.4f %16s %n", Euros,Dubbeltjes,(Euros+ Dubbeltjes/10), euro);
        //System.out.printf("Result: %1.0f euro plus %1.0f dubbeltjes is %1.8f %12s %n", Euros,Dubbeltjes,(Euros+ Dubbeltjes/10), euro);
       // System.out.printf("Result: %1.0f euro plus %1.0f dubbeltjes is %1.16f %1s %n", Euros,Dubbeltjes,(Euros+ Dubbeltjes/10), euro);
       
        
    }
}