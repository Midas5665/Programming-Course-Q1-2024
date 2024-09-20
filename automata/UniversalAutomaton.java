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
        // TODO 5
        String resultString = "";
        for (int i = 1; i < gen.length; i++) {
            if (gen[i]) {
                resultString += "*";
            }
            else {
                resultString += " ";
            }
        }
        return resultString;
    }

    boolean[] nextGen(boolean[] ruleSequence, boolean[] gen) {
        // TODO 14
        boolean[] resultArray = new boolean[gen.length];
        resultArray[0] = resultArray[resultArray.length - 1] = false;
        for (int i = 1; i < gen.length - 1; i++) {
            resultArray[i] = false;
            if (ruleSequence[0] && !(gen[i - 1] || gen[i] || gen[i + 1])) { 
                resultArray[i] = true;
            }
            if (ruleSequence[1] && (!gen[i - 1] && !gen[i] && gen[i + 1])) {
                resultArray[i] = true;
            }
            if (ruleSequence[2] && (!gen[i - 1] && gen[i] && !gen[i + 1])) {
                resultArray[i] = true;
            }
            if (ruleSequence[3] && (!gen[i - 1] && gen[i] && gen[i + 1])) {
                resultArray[i] = true;
            }
            if (ruleSequence[4] && (gen[i - 1] && !gen[i] && !gen[i + 1])) {
                resultArray[i] = true;
            }
            if (ruleSequence[5] && (gen[i - 1] && !gen[i] && gen[i + 1])) {
                resultArray[i] = true;
            }
            if (ruleSequence[6] && (gen[i - 1] && gen[i] && !gen[i + 1])) {
                resultArray[i] = true;
            }
            if (ruleSequence[7] && (gen[i - 1] && gen[i] && gen[i + 1])) {
                resultArray[i] = true;
            }
        }
        return resultArray;
    }

    boolean[] readInitalGeneration(int length) {
        // TODO 11
        boolean[] resultArray = new boolean[length + 2];
        resultArray[0] = resultArray[length + 1] = false;
        for (int i = 1; i <= length; i++) {
            resultArray[i] = false;
        }
        if (scanner.next().equals("init_start")) {
            String input = scanner.next();
            while (!input.equals("init_end")) {
                resultArray[Integer.valueOf(input)] = true;
                input = scanner.next();
            }
        }
        return resultArray;
    }

    boolean[] readRuleSequence() {
        // TODO 17
        boolean[] ruleArray = new boolean[8];
        for (int i = 0; i < 8; i++) {
            int arrayInput = scanner.nextInt();
            if (arrayInput == 0) {
                ruleArray[i] = false;
            }
            if (arrayInput == 1) {
                ruleArray[i] = true;
            }
        }
        return ruleArray;
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
