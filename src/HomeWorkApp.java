public class HomeWorkApp {

    public static void main(String[] args) {
        checkSum(5, 1);
        number(-8);
        meaning(16);
        word("Hello", 5);
        leapYear(2000);
    }

    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum > 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }

    public static void number(int a) {
        if (a >= 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }
    }

    public static boolean meaning(int c) {
        if (c < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void word(String x, int y) {
        for (int i = 0; i < y; i++) {
            System.out.println(x);
        }
    }

    public static boolean leapYear(int x) {
        if (x % 4 == 0) {
            return true;
        } else if (x % 100 == 0) {
            return false;
        } else if (x % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}