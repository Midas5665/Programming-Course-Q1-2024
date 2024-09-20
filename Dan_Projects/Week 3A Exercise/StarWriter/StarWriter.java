
public class StarWriter{

    int numStars = 10;
    public void printStars(int n, String s){
        for (int i = 0; i < n; i++) {
            System.out.print(s);
        }
    }

    public void write(){
        printStars(numStars, "*");
    }

    public void triangle(){
        for (int i = 1; i < 6; i++) {
            printStars(i,"*");
            nl();
        }
    }

    public void nl(){
        System.err.println("");
    }

    public void printSpace(int n){
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public void printH(){
        String H ="H";
        for (int i = 0; i < 2; i++) {
            printStars(3, H);
            printSpace(3);
            printStars(3, H);
            nl();
        }
        for (int i = 0; i < 2; i++) {
            printStars(9, H);
            nl();
        }
        for (int i = 0; i < 2; i++) {
            printStars(3, H);
            printSpace(3);
            printStars(3, H);
            nl();
        }
    }

    public void printE(){
        String E ="E";
        for (int i = 0; i < 2; i++) {
            printStars(9,E);
            nl();
        }
        for (int i = 0; i < 2; i++) {
            printStars(3, E);
            nl();
        }
        for (int i = 0; i < 2; i++) {
            printStars(9, E);
            nl();
        }
        for (int i = 0; i < 2; i++) {
            printStars(3, E);
            nl();
        }
        for (int i = 0; i < 2; i++) {
            printStars(9,E);
            nl();
        }
    }


    public void printL(){
        String L = "L";
        for (int i = 0; i < 7; i++) {
            printStars(3, L);
            nl();
        }
        for (int i = 0; i < 3; i++) {
            printStars(9, L);
            nl();
        }
    }
    public void printO(){
        String O = "O";
        printSpace(2);
        printStars(5, O);
        printSpace(2);
        nl();
        printSpace(1);
        printStars(3, O);
        printSpace(1);
        printStars(3, O);
        nl();
        for (int i = 0; i < 6; i++) {
            printStars(3, O);
            printSpace(3);
            printStars(3, O);
            nl();
        }
        printSpace(1);
        printStars(3, O);
        printSpace(1);
        printStars(3, O);
        nl();
        printSpace(2);
        printStars(5, O);
        printSpace(2);
        nl();
    }
    public void printHello(){
        printH();
        nl();
        nl();
        printE();
        nl();
        nl();
        printL();
        nl();
        nl();
        printL();
        nl();
        nl();
        printO();
    }
    public void printWord(String s){
        for(int i=0; i<s.length(); i++){
            switch (s.substring(i,i+1)){
                case("H"):
                    printH();
                    break;
                case("E"):
                    printE();
                    break;
                case("L"):
                    printL();
                    break;
                case("O"):
                    printO();
                    break;
            }
            nl();
            nl();

        }
    }
}