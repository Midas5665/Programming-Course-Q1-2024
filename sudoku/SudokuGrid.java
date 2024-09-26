import java.awt.Point;

public class SudokuGrid {
    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;

    private int[][] grid;
    private int rEmpty, cEmpty; // Coordinates of the last found empty cell

    public SudokuGrid() {
        // Initialize the grid and set rEmpty and cEmpty to -1
        rEmpty = - 1;
        cEmpty = -1;
        grid = new int[SIZE][SIZE];
    }

    public SudokuGrid copy() {
        // Create a copy of the SudokuGrid and return it
        return null;

    }

    public Point findEmptyCell() {
        // Find the next empty cell in reading order and return its coordinates as a Point
        for (int i = 0 ; i < SIZE; i++) {
            for (int j = 0 ; j < SIZE; j++) {
                if (grid[i][j] == 0) {
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    public void print() { 
        // I would say this is done
        // Print the Sudoku grid
        for(int i = 0 ; i < SIZE; i++ ) {
            if(i == 0 || i == 3 || i == 6)
                System.out.println("+-----------------+");
            System.out.print("|");
            for(int j = 0; j < SIZE; j ++) {
                if(j == 3 || j == 6) {
                    System.out.print("|");
                }
                System.out.print(grid[i][j] == 0 ? " " : grid[i][j]);
                if(!(j == 2 || j == 5 || j == 8)) {
                    System.out.print(" ");
                }
                    
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+-----------------+");
    }

    public void fillCell(int r, int c, int d) {
        // Fill the cell at row r and column c
        grid[r][c] = d;
    }

    public boolean givesConflict(int r, int c, int d) {
        // Check if filling the number d in the cell at row r and column c causes a conflict
        return rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d);
    }

    private boolean rowConflict(int r, int d) {
        // Check if there is a conflict in the row r when filling the number d
        for(int i = 0; i < SIZE; i++) {
            if(grid[r][i] == d)
                return true;
        }
        return false;
    }

    private boolean colConflict(int c, int d) {
        // Check if there is a conflict in the column c when filling the number d
        for(int i = 0; i < SIZE; i++) {
            if(grid[i][c] == d)
                return true;
        }
        return false;
    }

    private boolean boxConflict(int r, int c, int d) {
        // Check if there is a conflict in the 3x3 box containing the cell at row r and column c
        // when filling the number d
        return false;
    }
}