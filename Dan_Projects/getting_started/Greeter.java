public class Greeter {
    /**
    **
    Greet the user **/
    void sayHello(){
        System.out.println("Hello, Vasilescu Dan Gabriel, with the student ID 2155699. Today's date is 03/09/2024."); /** Program prints the first line */
        System.out.println("Good luck in the course Programming: Enjoy!");  /**Program prints the second line */
    }

    public static void main(String[] args){
        new Greeter().sayHello(); /**Calls the method defined in the Greeter class */
    }
}
