package Geekbrains;

public class Cat extends Animal {
    private String name;
    private final int animalDistanceRun = 200;
    private final int animalDistanceSwim = 0;

    public Cat(String name, int animalDistanceRun, int animalDistanceSwim) {
        super(name, animalDistanceRun, animalDistanceSwim);
    }

    public Cat() {
        super();
    }

    @Override
    void name() {

    }


    @Override
    void run(int length) {
        if (length >= 0) {
            System.out.println(name + " пробежал " + animalDistanceRun );
        }
        }
        @Override
        void swim ( int length){
            if (length >= 0){
                System.out.println("Кот не умеет плавать" );
            }
        }
    }


