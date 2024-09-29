import java.awt.Point;

/**
 * The main class for the sudoku solver, containing the methods to find
 * the solution to any sudoku grid if it has any. If it doesn't,
 * the message "No solution" will be printed.
 */
public class SudokuSolver {
    SudokuGrid grid;

    /**
     * Initialize the SudokuSolver with the provided SudokuGrid.
     * 
     * @param grid of the sudoku puzzle
     */
    public SudokuSolver(SudokuGrid grid) {
        this.grid = grid;
    }

    /**
     * Using recursion and backtracking, solve() is supposed to brute force its
     * way through every possible option for the empty cells in the grid until it finds
     * a valid solution.
     * 
     * @return whether the grid in its current state is solvable and conflict-free
     */
    
    public boolean solve() {
        // Use a recursive strategy to solve the Sudoku puzzle
        //solution condition
        Point auxPoint = grid.findEmptyCell();
        if (auxPoint == null) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            int x = i;
            //find next empty cell
            SudokuGrid oldGrid = grid.copy();
            if (!grid.givesConflict(auxPoint.x, auxPoint.y, x)) {
                grid.fillCell(auxPoint.x, auxPoint.y, x);
                boolean isSolution = solve();
                if (isSolution) {
                    return true;
                } else {
                    grid = oldGrid;
                }
            }
        }
        return false;
    }

    /**
     * Use solve() to solve the puzzle and 
     * print the solution or a message if no solution is found.
     */
    
    public void solveIt() {
        if (solve()) {
            grid.print();
        } else {
            System.out.println("No solution");
        }
        
    }

    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver
        SudokuGrid grid = new SudokuGrid();
        SudokuSolver solver = new SudokuSolver(grid);
        solver.solveIt();
        
    }
}