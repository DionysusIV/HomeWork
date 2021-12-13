package Geekbrains;

public class Human implements Competitor {
    private int maxRun;
    private int maxJump;

    public Human(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public Human() {
        this(200, 3);
    }

    @Override
    public boolean run(int dist) {
        if (dist <= maxRun) {
            System.out.println("Человек пробежал " + dist + " м");
            return true;
        } else {
            System.out.println("Человек не пробежал " + dist + " м");
            return false;
        }
    }

    @Override
    public boolean jump(int dist) {
        if (dist <= maxJump) {
            System.out.println("Человек перепрыгнул " + dist + " м");
            return true;
        } else {
            System.out.println("Человек не перепрыгнул " + dist + " м");
            return false;
        }
    }
}
