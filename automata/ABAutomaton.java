import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * Documentation.
 * 
 * The program makes use of 4 methods: genToString, which converts a boolean array (gen) by printing
 * "*" for true values and " " for false values, nextgenA, builds a new boolean array using the
 * rules of the A-type pattern, nextGenB, that builds a new boolean array using the rules of the B
 * type pattern, and readInitialGeneration that builds the first line of the output based on user
 * input.
 * 
 *  The program takes the user input: the string automaton will determine which of the two patterns
 *  (A or B) will be followed. genLength will determine the length of one line in the generation,
 *  excluding the two auxiliary, and numberOfGens will determine the number of lines in the
 *  resulting generation.
 * 
 *  The function readInitialGeneration is called. After the user enter the string "init_start"
 *  The program will take information regarding the structure of the first line in the generation.
 *  (The positions of the first stars). To end the input sequence, the user types "init_end".
 * 
 *  Using a for loop, the program prints every line of generation. Each line is generated
 *  depending on the structure of the preceding line.
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 */
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        String resultString = "";
        for (int i = 1; i < gen.length - 1; i++) {
            if (gen[i]) {
                resultString += "*";
            }
            else {
                resultString += " ";
            }
        }
        return resultString;
    }
    boolean[] nextGenA(boolean[] gen) {
        boolean[] resultArray = new boolean[gen.length];

        resultArray[0] = resultArray[resultArray.length - 1] = false;

        for (int i = 1; i < gen.length - 1; i++) {

            boolean checked = false;
            if (gen[i - 1]) {
                resultArray[i] = !(gen[i] && gen[i + 1]);
                checked = true;
            }
            if (gen[i + 1] && !checked) {
                resultArray[i] = true;
                checked = true;
            }
            if (!checked) {
                resultArray[i] = false;
            }

        }

        return resultArray;
    }

    boolean[] nextGenB(boolean[] gen){
        boolean[] resultArray = new boolean[gen.length];

        resultArray[0] = resultArray[resultArray.length - 1] = false;
        for (int i = 1; i < gen.length - 1; i++) {

            if (((gen[i] || gen[i - 1]) && !gen[i + 1])
                || (!(gen[i] || gen[i - 1]) && gen[i + 1])) {
                resultArray[i] = true;
            }
            else {
                resultArray[i] = false;
            }
        }
        return resultArray;
    }


    boolean[] readInitalGeneration(int length) {
        boolean[] resultArray = new boolean[length + 2];
        resultArray[0] = resultArray[length + 1] = false;
        for (int i = 1; i <= length; i++) {
            resultArray[i] = false;
        }
        if (scanner.next().equals("init_start")) {
            String input = scanner.next();
            while (!input.equals("init_end")) {
                if (Integer.valueOf(input) <= length && Integer.valueOf(input) >= 1) {
                    resultArray[Integer.valueOf(input)] = true;
                }
                    
                input = scanner.next();
            }
        }
        return resultArray;
    }

    void run() {
        // Read input to configure the automaton
        String automaton = scanner.next();
        int genLength = scanner.nextInt();
        int numOfGens = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(genLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numOfGens; i++) {
            // Display the current generation
            System.out.println(genToString(gen));

            // And determine the next generation

            if ("A".equals(automaton)) {
                gen = nextGenA(gen);
            } else {
                // B
                gen = nextGenB(gen);
            }
        }
    }

    public static void main(String[] args) {
        new ABAutomaton().run();
    }
}
