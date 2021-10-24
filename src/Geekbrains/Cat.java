package Geekbrains;

public class Cat {
    private String name;
    private int appetite;
    private boolean isHungry;

    public Cat (String name,int appetite){
        this.name = name;
        this.appetite = appetite;
        this.isHungry = false;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public int getAppetite() {
        return appetite;
    }

    public String getName() {
        return name;
    }

    public void info(){
        System.out.println("Name: " + name + ", hungry: " + isHungry);
    }

    public void  eat(Plate plate){
        plate.setFood(plate.getFood() - appetite);
        isHungry = true;
        System.out.println(name + " поел из тарелки");
    }
}
