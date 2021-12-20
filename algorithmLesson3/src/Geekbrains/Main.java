package Geekbrains;

public class Main {

    public static void main(String[] args) {
        int [] b = {1,2,4,5,6};
        int sum = 0;
        int idx = -1;
        for (int i = 0; i < b.length; i++) {
            if (b[i] == 0) {
                idx = i;
            } else {
                sum += b[i];
            }
        }

        int total = (b.length + 1) * b.length / 2;

        System.out.println("Пропущено число: " + (sum - total));
    }
}
