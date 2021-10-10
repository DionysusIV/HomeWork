package com.company;
import java.util.Arrays;

public class HomeWorK3 {

    public static void main(String[] args) {
        invertArray();
        replacement();
        changeArray();
        fillDiagonal();
        lenInitialValue(10, 20);
        minMax();
    }

    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] += 1;
            } else {
                arr[i] -= 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void replacement() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + i;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                }else if(i+j==5-1){
                    arr[i][j]=1;
                }
                System.out.print(arr[i][j] + " ");

            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] lenInitialValue(int len, int initialValue) {
        int arr[] = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void minMax() {
        int[] arr = {2, 7, 1, 3, 5, 12, -9, 20};
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println("Максимальное значение в массиве arr: " + max);
        System.out.println("Минимальное значение в массиве arr: " + min);
    }
}


