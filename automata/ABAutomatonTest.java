import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test ABAutomaton.
 * 
 * 
 * @author Vasilescu Dan Gabriel
 * @ID <2155699> 
 * @author Dediu David Gabriel
 * @ID <2096676>
 */
public class ABAutomatonTest {
    ABAutomaton automaton = new ABAutomaton();

    @Test
    public void testGenToString() {
        //

        // 1. Basic test on a smaller array.
        boolean[] genTest1 = {false, true, false, true, false};
        assertEquals("* *", new ABAutomaton().genToString(genTest1));
        // 2. Test accuracy on all True array.
        boolean[] genTest2 = {false, true, true, true, false};
        assertEquals("***", new ABAutomaton().genToString(genTest2));
        // 3. Test an empty array (excluding the borders).
        boolean[] genTest3 = {false, false};
        assertEquals("", new ABAutomaton().genToString(genTest3));
        // 4. Test what happens if a border is True.
        boolean[] genTest4 = {true, false, true};
        assertEquals(" ", new ABAutomaton().genToString(genTest4));
        // 5. Test the accuracy on a bigger array.
        boolean[] genTest5 = {false, true, false, true, true, true, false, true, false, false};
        assertEquals("* *** * ", new ABAutomaton().genToString(genTest5));

    }

    @Test
    public void testNextGenA() {
        //  
        
        // 1. Test what happens if only the middle cell is true.
        boolean[] genTest1 = {false, true, false};
        boolean[] expectedOutput1 = {false, false, false};
        assertArrayEquals(expectedOutput1, new ABAutomaton().nextGenA(genTest1));
        // 2. Test what happens if the left and center cells are true.
        boolean[] genTest2 = {true, true, false};
        boolean[] expectedOutput2 = {false, true, false};
        assertArrayEquals(expectedOutput2, new ABAutomaton().nextGenA(genTest2));
        // 3. Test what happens if the center and right cell are true.
        boolean[] genTest3 = {false, true, true};
        boolean[] expectedOutput3 = {false, true, false};
        assertArrayEquals(expectedOutput3, new ABAutomaton().nextGenA(genTest3));
        // 4.  Test what happens if all cells are true.
        boolean[] genTest4 = {true, true, true};
        boolean[] expectedOutput4 = {false, false, false};
        assertArrayEquals(expectedOutput4, new ABAutomaton().nextGenA(genTest4));
        // 5. Test waht happens if no cells are true.
        boolean[] genTest5 = {false, false, false};
        boolean[] expectedOutput5 = {false, false, false};
        assertArrayEquals(expectedOutput5, new ABAutomaton().nextGenA(genTest5));
        // 6. Test what happens when only the left cell is true.
        boolean[] genTest6 = {true, false, false};
        boolean[] expectedOutput6 = {false, true, false};
        assertArrayEquals(expectedOutput6, new ABAutomaton().nextGenA(genTest6));
        // 7. Test what happens when only the right cell is true.
        boolean[] genTest7 = {false, false, true};
        boolean[] expectedOutput7 = {false, true, false};
        assertArrayEquals(expectedOutput7, new ABAutomaton().nextGenA(genTest7));
        // 8. Test what happens when only the right and left cells are true.
        boolean[] genTest8 = {true, false, true};
        boolean[] expectedOutput8 = {false, true, false};
        assertArrayEquals(expectedOutput8, new ABAutomaton().nextGenA(genTest8));


    }

    @Test
    public void testNextGenB() {
        // 
        // 1. Test what happens if only the middle cell is true.
        boolean[] genTest1 = {false, true, false};
        boolean[] expectedOutput1 = {false, true, false};
        assertArrayEquals(expectedOutput1, new ABAutomaton().nextGenB(genTest1));
        // 2. Test what happens if the left and center cells are true.
        boolean[] genTest2 = {true, true, false};
        boolean[] expectedOutput2 = {false, true, false};
        assertArrayEquals(expectedOutput2, new ABAutomaton().nextGenB(genTest2));
        // 3. Test what happens if the center and right cell are true.
        boolean[] genTest3 = {false, true, true};
        boolean[] expectedOutput3 = {false, false, false};
        assertArrayEquals(expectedOutput3, new ABAutomaton().nextGenB(genTest3));
        // 4.  Test what happens if all cells are true.
        boolean[] genTest4 = {true, true, true};
        boolean[] expectedOutput4 = {false, false, false};
        assertArrayEquals(expectedOutput4, new ABAutomaton().nextGenB(genTest4));
        // 5. Test waht happens if no cells are true.
        boolean[] genTest5 = {false, false, false};
        boolean[] expectedOutput5 = {false, false, false};
        assertArrayEquals(expectedOutput5, new ABAutomaton().nextGenB(genTest5));
        // 6. Test what happens when only the left cell is true.
        boolean[] genTest6 = {true, false, false};
        boolean[] expectedOutput6 = {false, true, false};
        assertArrayEquals(expectedOutput6, new ABAutomaton().nextGenB(genTest6));
        // 7. Test what happens when only the right cell is true.
        boolean[] genTest7 = {false, false, true};
        boolean[] expectedOutput7 = {false, true, false};
        assertArrayEquals(expectedOutput7, new ABAutomaton().nextGenB(genTest7));
        // 8. Test what happens when only the right and left cells are true.
        boolean[] genTest8 = {true, false, true};
        boolean[] expectedOutput8 = {false, false, false};
        assertArrayEquals(expectedOutput8, new ABAutomaton().nextGenB(genTest8));
    }

}
