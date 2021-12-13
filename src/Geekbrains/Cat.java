package Geekbrains;

public class Cat implements Competitor {
    private int maxRun;
    private int maxJump;

    public Cat(int maxRun, int maxJump) {
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    public Cat() {
        this(350, 4);
    }

    @Override
    public boolean run(int dist) {
        if (dist <= maxRun) {
            System.out.println("Кот пробежал " + dist + " м");
            return true;
        } else {
            System.out.println("Кот не пробежал " + dist + " м");
            return false;
        }
    }

    @Override
    public boolean jump(int dist) {
        if (dist <= maxJump) {
            System.out.println("Кот перепрыгнул " + dist + " м");
            return true;
        } else {
            System.out.println("Кот не перепрыгнул " + dist + " м");
            return false;
        }
    }
}
