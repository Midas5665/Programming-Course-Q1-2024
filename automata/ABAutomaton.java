import java.util.Scanner;

/**
 * Automatons A and B.
 * 
 * 
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
    //THIS IS DONE
    boolean[] nextGenA(boolean[] gen) {
        // TODO 7
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
        // TODO 9
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
        // TODO 11
        boolean[] resultArray = new boolean[length + 2];
        resultArray[0] = resultArray[length + 1] = false;
        for (int i = 1; i <= length; i++) {
            resultArray[i] = false;
        }
        if (scanner.next().equals("init_start")) {
            String input = scanner.next();
            while (!input.equals("init_end")) {
                if(Integer.valueOf(input) <= length && Integer.valueOf(input) >= 1)
                    resultArray[Integer.valueOf(input)] = true;
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
