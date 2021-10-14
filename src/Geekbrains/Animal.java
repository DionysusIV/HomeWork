package Geekbrains;

public abstract class Animal {
    private String name;
    private int animalDistanceRun;
    private int animalDistanceSwim;

    public Animal(String name, int animalDistanceRun, int animalDistanceSwim){
        this.name = name;
        this.animalDistanceRun = animalDistanceRun;
        this.animalDistanceSwim = animalDistanceSwim;


    }

    public Animal() {

    }



    abstract void name();

    abstract void run(int length);

    abstract void swim(int length);
}
