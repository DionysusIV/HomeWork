import java.util.Arrays;

public class MainClass {
    static final int size = 10_000_000;
    static final int h= size / 2;
    public static void main(String[] args){
        firstMethod();
        secondMethod();

    }
    public static void firstMethod() {
        System.out.println("Старт метода 1");
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        System.out.println("Время выполнния потока: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void  secondMethod() {
        System.out.println("Старт метода 2");
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        Arrays.fill(arr, 1.0f);
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, 0, arr2, 0, h);
        long split = System.currentTimeMillis();
        System.out.printf("Время выполнния разделения массива: %s ms.", split - start);

        Thread thread1 = new Thread(() -> methodTwoInternal(arr1, 1));
        Thread thread2 = new Thread(() -> methodTwoInternal(arr2, 2));

        thread1.start();
        thread2.start();

        long connect = System.currentTimeMillis();
        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        long end = System.currentTimeMillis();
        System.out.printf(" Время выполнния склейки массива: %s ms.", end - connect);
        System.out.printf(" Завершение метода 2. Время выполнения: %s ms.", end - start);
    }

    private static void methodTwoInternal(float[] arr, int number) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
        long end = System.currentTimeMillis();
        System.out.printf(" Время выполнния потока %d:  %s ms.", number, end - start);
    }


}
