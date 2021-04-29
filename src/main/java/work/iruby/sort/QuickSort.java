package work.iruby.sort;

import java.util.Arrays;

/**
 * @author Ruby
 * @date 2020/12/7 12:17
 */
public class QuickSort {
    public static int[] sort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int start, int end) {
        Pivot pivot = dealPivot(array, start, end);
        System.out.println("pivot.value:" + pivot.value + ",start:" + start + ",end:" + end);
        System.out.println(Arrays.toString(array));
        if ((end - start) <= 2) {
            return;
        }
        int s = start;
        int e = end;
        while (s < e) {
            while (s < e && array[s] < pivot.value) {
                s++;
            }
            while (s < e && array[e] > pivot.value) {
                e--;
            }
            if (s < e && array[s] == array[e]) {
                s++;
            } else {
                SortTools.swap(array, s, e);
            }
        }

        quickSort(array, start, e - 1);
        quickSort(array, s + 1, end);

    }

    private static Pivot dealPivot(int[] array, int start, int end) {
        int mid = (start + end) / 2;
        if (array[mid] > array[end]) {
            SortTools.swap(array, mid, end);
        }
        if (array[start] > array[end]) {
            SortTools.swap(array, start, end);
        }
        if (array[start] > array[mid]) {
            SortTools.swap(array, start, mid);
        }
        return new Pivot(mid, array[mid]);
    }

    private static class Pivot {
        int index;
        int value;

        public Pivot(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
