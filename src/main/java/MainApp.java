import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
    String []  arr = {"qwe","dfg","yui","zxc"};

        ArrayList<String> ar = arrayToList(arr);
        System.out.println(ar);

        BoxFruits<Apple> box = new BoxFruits<>();
        box.add(new Apple());
    }

    public static <T>ArrayList<T> arrayToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void swap (Object[] arr, int i1, int i2){
        Object obj = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = obj;
    }
}

