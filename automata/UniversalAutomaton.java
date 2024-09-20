import java.util.Scanner;

/**
 * Universal Automaton.
 * 
 * TODO 3: Fill in your names and student IDs
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 */
class UniversalAutomaton {
    Scanner scanner = new Scanner(System.in);

    String genToString(boolean[] gen) {
        // TODO 13: Copy from ABAutomaton.java
        return "Hello";
    }

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        // TODO 14
        return new boolean[] { true, false };
    }

    boolean[] readInitalGeneration(int length) {
        // TODO 16: Copyt from ABAutomaton.java
        return new boolean[] { true, false };
    }

    boolean[] readRuleSequence() {
        // TODO 17
        return new boolean[] { true, false };
    }

    void run() {
        // Read input to configure the universal automaton
        boolean[] ruleSequence = readRuleSequence();
        int generationLength = scanner.nextInt();
        int numberOfGenerations = scanner.nextInt();
        boolean[] initGen = readInitalGeneration(generationLength);

        // Run the automaton
        boolean[] gen = initGen;

        for (int i = 0; i < numberOfGenerations; i++) {
            // Display the current generation
            System.out.println(genToString(gen));
            // Determine the next generation
            gen = nextGen(ruleSequence, gen);
        }
    }

    public static void main(String[] args) {
        new UniversalAutomaton().run();
    }
}
