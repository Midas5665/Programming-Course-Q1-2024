import java.awt.Point;

public class SudokuSolver {
    SudokuGrid grid;
    SudokuGrid lastSolution = null;
    SudokuGrid firstSolution = null;
    static int numberOfSolutions;

    public SudokuSolver(SudokuGrid grid) {
        // Initialize the SudokuSolver with the provided SudokuGrid
        this.grid = grid;
    }
    
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
                }
                else {
                    grid = oldGrid;
                }
            }
        }
        return false;
    }
    
    public void solveIt() {
        // Use solve() to solve the puzzle and print the solution or
        // a message if no solution is found
        boolean isSolution = solve();
        if (isSolution) {
            grid.print();
        }
        else {
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