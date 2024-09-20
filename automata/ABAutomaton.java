import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * TODO 3: FIll in your names and student IDs:
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 */
class ABAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        // TODO 5
        return "Hello";
    }

    boolean[] nextGenA(boolean[] gen) {
        // TODO 7
        return new boolean[] { true, false };
    }

    boolean[] nextGenB(boolean[] gen) {
        // TODO 9
        return new boolean[] { true, false };
    }

    boolean[] readInitalGeneration(int length) {
        // TODO 11
        return new boolean[] { true, false };
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
