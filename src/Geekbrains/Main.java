package Geekbrains;

public class Main {

    public static void main(String[] args) {
        Cat[] cat = new Cat[3];
        cat[0] = new Cat("Barsic",15 );
        cat[1] = new Cat("Barsic1",20);
        cat[2] = new Cat("Barsic2",10);


        Plate plate = new Plate(40);

       plate.info();

        cat.info();

        plate.setFood(plate.getFood() - cat.getAppetite());
        cat.setHungry(false);
        System.out.println(cat.getName() + " поел из тарелки");

        cat.eat(plate);
        plate.increaseFood();
        plate.info();
        cat.info();
    }


}
