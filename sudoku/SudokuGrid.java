import java.awt.Point;

public class SudokuGrid {

    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;

    private int[][] grid;
    private int rEmpty;
    private int cEmpty; // Coordinates of the last found empty cell

    public SudokuGrid() {
        // Initialize the grid and set rEmpty and cEmpty to -1
        rEmpty = - 1;
        cEmpty = -1;
        
        int[][] thing = {
            //Cases that have solutions
            // {2, 9, 5, 7, 4, 3, 8, 6, 1},
            // {4, 3, 1, 8, 6, 5, 9, 0, 0},
            // {8, 7, 6, 1, 9, 2, 5, 4, 3},
            // {3, 8, 7, 4, 5, 9, 2, 1, 6},
            // {6, 1, 2, 3, 8, 7, 4, 9, 5},
            // {5, 4, 9, 2, 1, 6, 7, 3, 8},
            // {7, 6, 3, 5, 3, 4, 1, 8, 9},
            // {9, 2, 8, 6, 7, 1, 3, 5, 4},
            // {1, 5, 4, 9, 3, 8, 6, 0, 0}

            {0, 9, 0, 7, 3, 0, 4, 0, 0},
            {0, 0, 0, 0, 0, 0, 5, 0, 0},
            {3, 0, 0, 0, 0, 6, 0, 0, 0},
            {0, 0, 0, 0, 0, 2, 6, 4, 0},
            {0, 0, 0, 6, 5, 1, 0, 0, 0},
            {0, 0, 6, 9, 0, 7, 0, 0, 0},
            {5, 8, 0, 0, 0, 0, 0, 0, 0},
            {9, 0, 0, 0, 0, 3, 0, 2, 5},
            {6, 0, 3, 0, 0, 0, 8, 0, 0}

            //"No solution" case
            // {0, 2, 3, 4, 5, 6, 7, 8, 9},
            // {1, 0, 0, 0, 0, 0, 0, 0, 0},
            // {3, 0, 0, 0, 0, 0, 0, 0, 0},
            // {4, 0, 0, 0, 0, 0, 0, 0, 0},
            // {5, 0, 0, 0, 0, 0, 0, 0, 0},
            // {6, 0, 0, 0, 0, 0, 0, 0, 0},
            // {7, 0, 0, 0, 0, 0, 0, 0, 0},
            // {8, 0, 0, 0, 0, 0, 0, 0, 0},
            // {9, 0, 0, 0, 0, 0, 0, 0, 0}
        };
        this.grid = thing;
    }

    public SudokuGrid copy() {
        // Create a copy of the SudokuGrid and return it
        SudokuGrid copyGrid = new SudokuGrid();
        copyGrid.cEmpty = this.cEmpty;
        copyGrid.rEmpty = this.rEmpty;
        copyGrid.grid = new int[9][9];

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                copyGrid.grid[i][j] = this.grid[i][j];
            }
        }

        return copyGrid;

    }

    public Point findEmptyCell() {
        // Find the next empty cell in reading order and return its coordinates as a Point
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == 0) {
                    rEmpty = i;
                    cEmpty = j;
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    public void print() { 
        // I would say this is done
        // Print the Sudoku grid
        for (int i = 0; i < SIZE; i++) {
            if (i == 0 || i == 3 || i == 6) {
                System.out.println("+-----------------+");
            }
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                if (j == 3 || j == 6) {
                    System.out.print("|");
                }
                System.out.print(grid[i][j] == 0 ? " " : grid[i][j]);

                if (!(j == 2 || j == 5 || j == 8)) {
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
        for (int i = 0; i < SIZE; i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    private boolean colConflict(int c, int d) {
        // Check if there is a conflict in the column c when filling the number d
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }
    private boolean boxConflict(int r, int c, int d) {
        // Check if there is a conflict in the 3x3 box containing the cell at row r and column c
        // when filling the number d
        for (int i = (0 + (r / 3) * 3); i < (3 + (r / 3) * 3); i++) {
            for (int j = (0 + (c / 3) * 3); j < (3 + (c / 3) * 3); j++) {
                if (grid[i][j] == d) {
                    return true;
                }
            }
        }
        
        return false;
    }
}