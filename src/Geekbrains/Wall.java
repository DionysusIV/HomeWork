package Geekbrains;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public boolean action(Competitor c) {
        return c.jump(height);
    }
}
