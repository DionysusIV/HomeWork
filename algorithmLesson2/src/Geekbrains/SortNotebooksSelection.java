package Geekbrains;

import java.util.List;

public class SortNotebooksSelection extends SelectionSort {
    public static List<Notebook> sort(List<Notebook> notebooks) {
        int min;
        for (int i = 0; i < notebooks.size() - 1; i++) {
            min = i;

            for (int j = i + 1; j < notebooks.size(); j++) {
                if (notebooks.get(j).compareTo(notebooks.get(min)) < 0) {
                    min = j;
                }
            }
            if (i == min) {
                continue;
            }
            Notebook temp = notebooks.get(i);
            notebooks.set(i, notebooks.get(min));
            notebooks.set(min, temp);
        }

        return notebooks;
    }

}
