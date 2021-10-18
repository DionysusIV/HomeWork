package Geekbrains;

public class Plate {
    private int food;

    public Plate (int food){
        this.food = food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int amount){
        food -=amount -1;
    }

    public void increaseFood() {
        if (food <= 0) {
            food += 40;
            System.out.println("Еда добавлена в тарелку");
        }
    }

    public int getFood() {
        return food;
    }


    public void info(){
        System.out.printf("Plate [ Food: %d ]\n", food);
    }
}
