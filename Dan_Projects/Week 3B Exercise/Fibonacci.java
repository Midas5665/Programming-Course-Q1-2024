public class Fibonacci{
    int fibCounter=0;
    public int fibonacci (int n) {
        //System.out.printf("fibonacci(%d) %n", n);;
        fibCounter++;
        
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        
        return fibonacci(n - 1) + fibonacci(n - 2);
        }
    
    public void fibCount(){
        System.out.println(fibCounter);
    }

    public int loopFibonacci(int n){
        int sum = 0;
        int minus1 = 1;
        int minus2 = 0;
        if(n==1){
            sum = 1;
        }
        for(int i = 2; i<=n ; i++){
            sum = minus1 + minus2;
            minus2 = minus1;
            minus1 = sum;
        }
        return sum;
        }

        

    public int fibonacciRemix(int n, int a, int b) {
                if(n==0){
                  return 0;
                }
                if(n==1){
                  return 1;
                }
                return  a+ fibonacciRemix(n, b, a+b );
              }
          




    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci(21);
        fibonacci.fibCount();
        
    }




}