package work.iruby.sort;

/**
 * @author Ruby
 * @date 2020/12/6 22:14
 */
public class BubbleSort {
    public static int[] sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean swap = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    SortTools.swap(array, j, j + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        return array;
    }
}
