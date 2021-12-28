package Geekbrains;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String[] word = {"table", "shot", "chair", "armchair", "telephone", "floor", "ball", "table", "ceiling", "shot", "armchair"};
        System.out.println(Arrays.toString(word));

        Map<String, Integer> heap = new HashMap<>();
        for (String y : word) {
            heap.put(y, heap.getOrDefault( y, 0) + 1);
        }
        System.out.println(heap);

        Phone peBook = new Phone();
        peBook.add("Сидоров","445454548");
        peBook.add("Кузьмичев","454848199");
        peBook.add("Петров","788566465456");
        peBook.add("Сидоров","5995682166");

        System.out.println("Телефон:" + peBook.get("Сидоров"));
        System.out.println("Телефон:" + peBook.get("Кузьмичев"));
        System.out.println("Телефон:" + peBook.get("Петров"));

    }
}