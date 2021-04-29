package work.iruby.sort;

import java.util.Random;

/**
 * @author Ruby
 * @date 2020/12/6 20:51
 */
public class SortTools {
    public static int[] createArray(int length, int scope) {
        Random random = new Random();

        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(scope * 2 + 1) - scope;
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int cache = array[i];
        array[i] = array[j];
        array[j] = cache;
    }
}
