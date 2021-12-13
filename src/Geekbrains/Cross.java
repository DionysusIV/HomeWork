package Geekbrains;
public class Cross implements Obstacle  {
    private int dist;

    public Cross(int dist){
        this.dist = dist;
    }

    @Override
    public boolean action(Competitor c) {
        return c.run(dist);
    }
}
