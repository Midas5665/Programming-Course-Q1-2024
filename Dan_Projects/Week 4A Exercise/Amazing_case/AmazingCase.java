/**
 * The AmazingCase game with a maze.
 * 
 * Lecture demo of backtracking
 * 
 * @author Kees Huizing
 * @date 30 Sep 2021
 */
class AmazingCase {
    static final Tile ME = new Tile('@');
    static final Tile EXIT = new Tile('>');
    static final Tile CRUMB = new Tile('.');
    static final Tile EMPTY = new Tile(' ');
    static final Tile PATH = new Tile('o');
    static final Tile WALL = new Tile('#');

    final int rowNum; // number of rows of the maze
    final int colNum; // number of collumns of the maze
    Tile[][] maze;

    Pair exit; // location of exit in the maze
    Pair me; // location of me in the maze

    /**
     * Create a new AmazingCase maze.
     * 
     * @param map strings describing the map of the maze.
     *            All strings in this map have the same length.
     */
    AmazingCase(String[] map) {
        rowNum = map.length;
        colNum = map[0].length();
        maze = new Tile[rowNum][colNum];

        for (int row = 0; row < rowNum; row++) {
            char[] rowCharacters = map[row].toCharArray();

            for (int col = 0; col < colNum; col++) {
                maze[row][col] = tileFromChar(rowCharacters[col]);

                if (maze[row][col] == EXIT) {
                    exit = new Pair(row, col);
                } else if (maze[row][col] == ME) {
                    me = new Pair(row, col);
                }
            }
        }
    }

    /**
     * Create a default maze.
     */
    AmazingCase() {
        // maze defined by hard-wired map
        this(new String[] {
            "##########",
            "#@    #  #",
            "### ### ##",
            "#   #    #",
            "# #   # >#",
            "##########",
        });
    }

    /**
     * Create a tile based on a character representing a tile.
     * 
     * @param c character representing a tile
     * @return the tile matching c
     */
    Tile tileFromChar(char c) {
        return switch (c) {
            case '#' -> WALL;
            case ' ' -> EMPTY;
            case '>' -> EXIT;
            case '@' -> ME;
            default -> EMPTY;
        };
    }

    /**
     * Solve the maze.
     */
    void solve() {
        if (explore()) {
            print("I am saved!");
        } else {
            print("I am lost!");
        }
    }

    /**
     * Print the maze.
     * 
     * @param suffix right padding
     */
    void print(String suffix) {
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[row].length; col++) {
                if (me.rowIndex() == row && me.colIndex() == col) {
                    System.out.print(ME.show());
                } else {
                    System.out.print(maze[row][col].show());
                }
            }
            System.out.println();
        }   

        System.out.println(suffix);
        pause(0.4);
    }

    /**
     * Print the maze.
     */
    void print() {
        print("");
    }

    /**
     * Pause the program for a number of seconds.
     * 
     * @param s number of seconds
     */
    void pause(double s) {
        try {
            Thread.sleep((long) (s * 1000));
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    /**
     * Determine emptiness of the tile at position described by pair p.
     * 
     * @param p pair describing a position in the maze.
     * @return True when the tile is empty or the exit.
     */
    boolean isFree(Pair p) {
        Tile t = maze[p.rowIndex()][p.colIndex()];
        return t == EMPTY || t == EXIT;
    }

    /**
     * Validate pair p.
     * 
     * @param p pair
     * @return True if pair is inside the maze
     */
    boolean withinBounds(Pair p) {
        return 0 <= p.rowIndex()
                && p.rowIndex() < rowNum
                && 0 <= p.colIndex()
                && p.colIndex() < colNum;
    }

    /**
     * Explore the maze.
     * 
     * @return True if the exit is found.
     */
    boolean explore() {
        print();

        if (me.rowIndex() == exit.rowIndex() && me.colIndex() == exit.colIndex()) {
            return true;
        }

        Pair[] nexts = {
            new Pair(me.rowIndex() - 1, me.colIndex()),
            new Pair(me.rowIndex(), me.colIndex() - 1),
            new Pair(me.rowIndex() + 1, me.colIndex()),
            new Pair(me.rowIndex(), me.colIndex() + 1),
        };

        for (Pair next : nexts) {
            if (withinBounds(next) && isFree(next)) {

                maze[me.rowIndex()][me.colIndex()] = PATH;
                Pair oldMe = me;
                me = next;
                boolean hasExit = explore();

                if (hasExit) {
                    return true;
                } else {
                    // backtracking
                    maze[next.rowIndex()][next.colIndex()] = CRUMB;
                        me = oldMe;
                    print();
                }
            }
        }

        return false;
    }

    public static void main(String[] a) {
        (new AmazingCase()).solve();
    }
}

/**
 * A tile in the maze.
 * 
 * @param view character representing the type of tile
 */
record Tile(char view) {
    String show() {
        return String.valueOf(view);
    }
}

/**
 * A pair (rowIndex, colIndex) representing the coordinates of a tile in the
 * maze.
 * 
 * @param rowIndex the row coordinate
 * @param colIndex the column coordinate
 */
record Pair(int rowIndex, int colIndex) {
}