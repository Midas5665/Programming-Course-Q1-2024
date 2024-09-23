import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test UniversalAutomaton.
 * 
 * 
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 */
public class UniversalAutomatonTest {
    UniversalAutomaton automaton = new UniversalAutomaton();

    @Test
    public void testGenToString() {
        // 
        // 1. Basic test on a smaller array.
        boolean[] genTest1 = {false, true, false, true, false};
        assertEquals("* *", new UniversalAutomaton().genToString(genTest1));
        // 2. Test accuracy on all True array.
        boolean[] genTest2 = {false, true, true, true, false};
        assertEquals("***", new UniversalAutomaton().genToString(genTest2));
        // 3. Test an empty array (excluding the borders).
        boolean[] genTest3 = {false, false};
        assertEquals("", new UniversalAutomaton().genToString(genTest3));
        // 4. Test what happens if a border is True.
        boolean[] genTest4 = {true, false, true};
        assertEquals(" ", new UniversalAutomaton().genToString(genTest4));
        // 5. Test the accuracy on a bigger array.
        boolean[] genTest5 = {false, true, false, true, true, true, false, true, false, false};
        assertEquals("* *** * ", new UniversalAutomaton().genToString(genTest5));
    }

   @Test
    public void testNextGen() {
        // 
        // 1. Test what happens when all rule patterns are false 
        //      on an initial generation of only one full cell
        boolean[] ruleSequence1 = {false, false, false, false, false, false, false, false};
        boolean[] initGen1 = {false, false, false, false, true, false, false};
        boolean[] expectedOutput1 = { false, false, false, false, false, false, false};
        assertArrayEquals(expectedOutput1, new 
            UniversalAutomaton().nextGen(ruleSequence1, initGen1));
        // 2. Test what happens when all rule patterns are 
        //      true on the same initial generation as before
        boolean[] ruleSequence2 = {true, true, true, true, true, true, true, true};
        boolean[] initGen2 = {false, false, false, false, true, false, false};
        boolean[] expectedOutput2 = { false, true, true, true, true, true, false};
        assertArrayEquals(expectedOutput2, new 
            UniversalAutomaton().nextGen(ruleSequence2, initGen2));
        // 3. Test what happens on more complicated patterns
        boolean[] ruleSequence3 = {false, true, false, true, true, true, true, false};
        boolean[] initGen3 = {false, false, false, false, true, false, false, false, false, false, false, false};
        boolean[] expectedOutput3 = { false, false, false, true, false, true, false, false, false, false, false, false};
        assertArrayEquals(expectedOutput3, new UniversalAutomaton().nextGen(ruleSequence3, initGen3));
        // 4. Test what happens when the initial generation is completely false
        //      with a random set of rules
        boolean[] ruleSequence4 = {true, true, false, false, true, true, false, false};
        boolean[] initGen4 = {false, false, false, false, false,
            false, false, false, false, false, false, false};
        boolean[] expectedOutput4 = { false, true, true, true, true,
            true, true, true, true, true, true, false};
        assertArrayEquals(expectedOutput4, new 
            UniversalAutomaton().nextGen(ruleSequence4, initGen4));
    }
}