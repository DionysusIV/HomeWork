package Geekbrains;
public class Robot implements Competitor{
    private int maxRun;
    private int maxJump;

    public Robot(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public Robot() {
        this(400, 5);
    }

    @Override
    public boolean run(int dist) {
        if (dist <= maxRun) {
            System.out.println("Робот пробежал " + dist + " м");
            return true;
        } else {
            System.out.println("Робот не пробежал " + dist + " м");
            return false;
        }
    }

    @Override
    public boolean jump(int dist) {
        if (dist <= maxJump) {
            System.out.println("Робот перепрыгнул " + dist + " м");
            return true;
        } else {
            System.out.println("Робот не перепрыгнул " + dist + " м");
            return false;
        }
    }
}
