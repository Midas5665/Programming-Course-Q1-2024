public class BlackjackPlus{


    public int blackjackPlus (int a, int b) {
        int aa = limit21 (a);
        int bb = limit21 (b);
        int result = max(aa , bb);
        return result;
        }

        int max(int a, int b) {
            if(a>= b){
                return a;
            }
            return b;
        }

        int limit21 (int n) {
            if(n-21<=0){
                return n;
            }
            return 0;
        }

        public static void main(String[] args) {
            BlackjackPlus black = new BlackjackPlus();
            System.out.println(black.blackjackPlus(19, 22));
        }

}