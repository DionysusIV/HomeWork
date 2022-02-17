import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

    }

    public static int[] arraayAfter4(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException();
    }

    public static boolean arrayContainsOnly1and4(int[] arr){
        boolean has1 = false;
        boolean has2 = false;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 1 && arr[i] != 4){
                return false;
            }
            if (arr[i] == 1 ){
                has1 = true;
            }
            if (arr[i] == 4){
                has2 = true;
            }
        }
        return has1 && has2;
    }
}
