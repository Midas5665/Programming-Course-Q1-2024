import java.awt.Point;

/**
 * Creation of the main SudokuGrid class. It contains variables for size, digit range,
 * a grid and the coordinates of the last found empty cell initialized at -1.
 * It also contains the methods for printing, filling cells, and checking for 
 * any conflicts in the grid.
 */
public class SudokuGrid {
    private static final int SIZE = 9;
    private static final int DIGIT_RANGE = 9;

    private int[][] grid;
    private int rEmpty;
    private int cEmpty; // Coordinates of the last found empty cell

    /**
     * Initialize the grid and set rEmpty and cEmpty to -1.
     */
    public SudokuGrid() {
        rEmpty = - 1;
        cEmpty = -1;
        //int[][] thing = new int[SIZE][SIZE];
        int[][] thing = {

            //Cases with solutions:
            
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

            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0},
            // {0, 0, 0, 0, 0, 0, 0, 0, 0}

            // {0, 9, 0, 7, 3, 0, 4, 0, 0},
            // {0, 0, 0, 0, 0, 0, 5, 0, 0},
            // {3, 0, 0, 0, 0, 6, 0, 0, 0},
            // {0, 0, 0, 0, 0, 2, 6, 4, 0},
            // {0, 0, 0, 6, 5, 1, 0, 0, 0},
            // {0, 0, 6, 9, 0, 7, 0, 0, 0},
            // {5, 8, 0, 0, 0, 0, 0, 0, 0},
            // {9, 0, 0, 0, 0, 3, 0, 2, 5},
            // {6, 0, 3, 0, 0, 0, 8, 0, 0}

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

    /**
     * Create a copy of the SudokuGrid and return it.
     * 
     * @return a copy of the grid object from the SudokuGrid class
     */

    public SudokuGrid copy() {
        SudokuGrid copyGrid = new SudokuGrid();
        copyGrid.cEmpty = this.cEmpty;
        copyGrid.rEmpty = this.rEmpty;
        copyGrid.grid = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(this.grid[i], 0, copyGrid.grid[i], 0, SIZE);
            // for (int j = 0; j < SIZE; j++) {
            //     copyGrid.grid[i][j] = this.grid[i][j];
            // }
        }

        return copyGrid;

    }

    /**
     * Find the next empty cell in reading order and return its coordinates as a Point.
     * 
     * @return a point with the coordinates of the next empty cell
     */

    public Point findEmptyCell() {
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
    /**
     * The command used to print the entire sudoku grid with separators.
     */

    public void print() { 
        System.out.println("+-----------------+");

        for(int i = 0; i < 3; i++){
            System.out.print("|");
            System.out.print(grid[i][0]);
            for (int j = 1; j < 3; j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.print("|");
            System.out.print(grid[i][3]);
            for (int j = 4; j < 6; j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.print("|");
            System.out.print(grid[i][6]);
            for (int j = 7; j < 9; j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("+-----------------+");
        

        // // Print each row of the grid
        // for (int i = 0; i < grid.length; i++) {
        //     System.out.print("|");
        //     for (int j = 0; j < grid[i].length; j++) {
        //         System.out.print(grid[i][j] + ((j == 2 || j == 5 || j == 8) ? "" : " "));
        //         if ((j + 1) % 3 == 0 && j != grid[i].length - 1) {
        //             System.out.print("|"); // Print vertical separators between 3x3 blocks
        //         }
        //     }
        //     System.out.println("|");

        //     // Print horizontal separators after every 3rd row
        //     if ((i + 1) % 3 == 0) {
        //         System.out.println("+-----------------+");
        //     }
        // }
    }

    /**
     * Fill the cell at row r and column c.
     * 
     * @param r row coordinate
     * @param c column coordinate
     * @param d value used to fill cell
     */

    public void fillCell(int r, int c, int d) {
        grid[r][c] = d;
    }

    /**
     * Check if filling the number d in the cell at row r and column c causes a conflict.
     * 
     * @param r row coordinate
     * @param c column coordinate
     * @param d value of the cell
     * @return whether there is a conflict or not
     */

    public boolean givesConflict(int r, int c, int d) {
        return rowConflict(r, d) || colConflict(c, d) || boxConflict(r, c, d);
    }

    /**
     * Check if there is a conflict in the row r when filling the number d.
     * 
     * @param r row coordinate
     * @param d value used to fill the cell
     * @return whether there is a conflict or not
     */

    private boolean rowConflict(int r, int d) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[r][i] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is a conflict in the column c when filling the number d.
     * 
     * @param c column coordinate
     * @param d value used to fill the cell
     * @return whether there is a conflict or not
     */

    private boolean colConflict(int c, int d) {
        for (int i = 0; i < SIZE; i++) {
            if (grid[i][c] == d) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if there is a conflict in the 3x3 box containing the cell at row r and column c
     * when filling the number d.
     * 
     * @param r row coordinate
     * @param c column coordinate
     * @param d value of the cell at coordiante r and c
     * @return whether there is a conflict in the box for the value
     */

    private boolean boxConflict(int r, int c, int d) {
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