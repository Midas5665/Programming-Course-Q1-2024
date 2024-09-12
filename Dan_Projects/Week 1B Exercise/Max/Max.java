
public class Max{
    
    public static void main(String[] args) {
        double a=11;
        double b=9;
        double c=10;
        double m;
        double[] d ={a,b,c};
        double z=0;
        if(b<a){
            if(c<a){
                System.out.println(a);
            }
            else{
                System.out.println(c);
            }
        }if(c<b){
            System.out.println(b);
        }
        else if(c>a){
            System.out.println(c);
        }
        m=0;
        if(a>m){
            m=a;
        }
        if(b>m){
            m=b;
        }
        if(c>m){
            m=c;
        }
        System.out.println(m);
        for(int i =0;i<=2;i++){
            if(z<d[i]){
                z=d[i];
            }
        }
        System.out.println(z);
    }
}