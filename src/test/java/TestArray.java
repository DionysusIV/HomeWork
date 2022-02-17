import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestArray {

    @Test
    public void test1ArrayAfter4(){
        int[] in = new int[]{1, 3, 4, 5, 5, 6, 8};
        int[] out = new int[]{5, 5, 6, 8};
        Assertions.assertArrayEquals(out, MainApp.arraayAfter4(in));
 }

    @Test
    public void test2ArraayAfter4(){
        int[] in = new int[]{1, 3, 5, 5, 6, 8};
        Assertions.assertThrows(RuntimeException.class, () ->{
            MainApp.arraayAfter4(in);
        });
    }

    @Test
    public void test1arrayContainsOnly1and4(){
        int[] in = new int[]{1, 3, 4, 5};
        Assertions.assertFalse(MainApp.arrayContainsOnly1and4(in));
    }

    @Test
    public void test2arrayContainsOnly1and4(){
        int[] in = new int[]{1, 4, 1};
        Assertions.assertTrue(MainApp.arrayContainsOnly1and4(in));
    }


}
