import java.util.Random;


/**
 * A stable.
 */
class Stable {
    Animal[] animals = new Animal[3];
    Random random = new Random();

    Stable() {
        // Default constructor.
    }
    
    /**
     * Farm the animals.
     */
    void farm() {
        for(int i =0; i<3;i++){
            String s="animal"+i;
            animals[i]= new Animal(s);
            animals[i].getTrough().fill(random.nextInt(8));
            for (int j = 0; j < random.nextInt(8); j++) {
                animals[i].eat();
            }
        }


        print(animals);
    }

    /**
     * Print information about the stable.
     */
    void print(Animal[] x) {
        for(int i =0; i<x.length;i++){
            x[i].print();
        }
    }

    public static void main(String[] args) {
        Stable stable = new Stable();
        stable.farm();
    }
}