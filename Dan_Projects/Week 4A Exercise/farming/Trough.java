/**
 * A through.
 */
class Trough {
    static final int PORTION_SIZE = 1;
    int nrOfServings;

    Trough() {
        this.nrOfServings = 0;
    }

    /**
     * Fill this through with m servings.
     * 
     * @param m number of servings
     */
    void fill(int m) {
        nrOfServings = nrOfServings + m;
    }

    /**
     * Let an animal eat from this through.
     */
    int give() {
        if (nrOfServings > 0) {
            nrOfServings = nrOfServings - PORTION_SIZE;
        }
        else{
            return 0;
        }
        return PORTION_SIZE;
    }

    /**
     * Print feeding info about this through.
     */
    void print() {
        System.out.println("The trough still has %d servings.".formatted(nrOfServings));
    }
}