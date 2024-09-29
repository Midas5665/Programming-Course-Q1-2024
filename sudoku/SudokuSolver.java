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
        Point nextEmptyPoint = grid.findEmptyCell();
        SudokuGrid oldGrid = grid.copy();
        if(nextEmptyPoint == null)
        {
            numberOfSolutions ++;
            if(firstSolution == null)
                firstSolution = grid.copy();
            lastSolution = grid.copy();
            return true;
        }
        for(int i = 1; i <= 9; i ++) {
            
            if(!grid.givesConflict(nextEmptyPoint.x, nextEmptyPoint.y, i)) {
                grid.fillCell(nextEmptyPoint.x, nextEmptyPoint.y, i);
                if(solve() == false) {
                    grid = oldGrid.copy();
                }
                else
                    i = 1;
            }
        }
        return false;
    }
    
    public void solveIt() {
         // Use solve() to solve the puzzle and print the solution or a message if no solution is found
         boolean rez = solve();
         firstSolution.print();
         lastSolution.print();
         System.out.println(rez);
    }

    public static void main(String[] args) {
        // Create a SudokuGrid and a SudokuSolver
        SudokuGrid grid = new SudokuGrid();
        SudokuSolver solver = new SudokuSolver(grid);
        solver.solveIt();
        
    }
}