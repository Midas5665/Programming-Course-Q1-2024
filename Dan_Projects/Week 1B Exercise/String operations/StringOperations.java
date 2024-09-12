public class StringOperations{
    public static void main(String[] args) {
        String s ="Eindhoven";
        System.out.println(s.substring(0,4));
        System.out.println(s.substring(4,6));
        System.out.println(s.contains("in"));
        System.out.println(s.contains("ho"));

        String p = "perfunctory";
        System.out.println(p.substring(3,6));

        String c ="concatenation";
        System.out.println(c.substring(0,3)+ c.substring(5,8) + c.substring(9,10));
        
    }
    
}