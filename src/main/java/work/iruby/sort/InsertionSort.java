package work.iruby.sort;

/**
 * 直接插入排序
 * @author Ruby
 * @date 2020/12/6 20:12
 */
public class InsertionSort {

    public static int[] sort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int sentry = array[0];
                if (array[j] < sentry){
                    SortTools.swap(array, 0, j);
                    continue;
                }
                if (array[j] < array[i]) {
                    SortTools.swap(array, i, j);
                }
            }
        }
        return array;
    }


}
