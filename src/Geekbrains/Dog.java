package Geekbrains;

public class Dog extends Animal {
    private String name;
    private final int animalDistanceRun = 500;
    private final int animalDistanceSwim = 10;

    public Dog(String name, int animalDistanceRun, int animalDistanceSwim) {
        super( name, animalDistanceRun, animalDistanceSwim);
    }

    public Dog() {

    }
    @Override
    void name(){

    }

    @Override
    void run(int length) {
        if (length >= 0) {
            System.out.println(name + " пробежал " + animalDistanceRun );
        }
    }

    @Override
    void swim(int length) {
        if (length >= 0) {
            System.out.println(name + " проплывет " + animalDistanceSwim );
        }
    }
}