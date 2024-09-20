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
        for(int i = 0; i < gen.length; i++) {
            if(gen[i]) {
                resultString += "*";
            }
            else {
                resultString += " ";
            }
        }
        return resultString;
    }

    boolean[] nextGenA(boolean[] gen) {
        // TODO 7
        boolean[] resultArray = new boolean[gen.length];

        for(int i = 0; i < gen.length; i++) {
            boolean checked = false;
            if (i - 1 > 0 && gen[i-1] ) {
                resultArray[i] = gen[i] && gen[i+1] ? false : true;
                checked = true;
            }
            if ( i + 1 < gen.length && gen[i+1] && !checked) {
                resultArray[i] = true;
                checked = true;
            }
            if (!checked) {
                resultArray[i] = false;
            }
        }

        return resultArray;
    }

    boolean[] nextGenB(boolean[] gen) {
        // TODO 9
        return new boolean[] { true, false };
    }

    boolean[] readInitalGeneration(int length) {
        // TODO 11
        boolean[] resultArray = new boolean[length];

        for (int i = 0; i < length; i++) {
            resultArray[i] = false;
        }
        if (scanner.next().equals("init_start")) {
            System.out.println("Start reading stuff");
            while (!scanner.hasNextInt()) {
                resultArray[scanner.nextInt()] = true;
                if (scanner.next().equals("init_end")) {
                    System.out.println("WE STOP HERE");
                    break;
                }
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
