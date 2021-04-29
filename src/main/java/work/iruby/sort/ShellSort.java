package work.iruby.sort;

/**
 * @author Ruby
 * @date 2020/12/6 20:49
 */
public class ShellSort {
    static int[] sort(int[] array) {
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < array.length - gap; i++) {
                int j = i;
                //相邻比较,成功再和之前比较
                while (j >= 0 && array[j + gap] < array[j]) {
                    SortTools.swap(array, j + gap, j);
                    j = j - gap;
                }
            }
        }
        return array;
    }
}
