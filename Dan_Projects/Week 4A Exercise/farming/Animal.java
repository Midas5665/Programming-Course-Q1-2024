/**
 * An animal.
 * 
 */
class Animal {
    String name = "noname";
    int nrOfMealsEaten; // number of meals
    Trough trough; // the trough for this animal

    /**
     * Create a new animal.
     */
    Animal(String s) {
        this.trough = new Trough();
        nrOfMealsEaten = 0;
        name = s;
    }

    /**
     * Get this animal's through.
     * 
     * @return the through
     */
    Trough getTrough() {
        return trough;
    }

    /**
     * Let this animal eat.
     */
    void eat() {
        nrOfMealsEaten = nrOfMealsEaten + trough.give();
        
    }

    /**
     * Print feeding info for this animal.
     */
    void print() {
        System.out.println("Animal %s has eaten %d meals.".formatted(name, nrOfMealsEaten));
        trough.print();
    }
}