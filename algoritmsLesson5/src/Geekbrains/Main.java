package Geekbrains;

public class Main {
        public static void main(String[] args) {

                System.out.println(pow(3,-2));
        }

        public static double pow ( double x, int y) {
            if (y > 1){
                return x * pow(x, y - 1);
             }else if (y == 1){
                return x;
             }else if (y == 0){
                return 1;
             }else if (y < 0) {
                return pow(1 / x, -y);
             } else
                 return 0;

        }
}

