package work.iruby.sort;

import java.util.Arrays;

/**
 * @author Ruby
 * @date 2020/12/6 20:36
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("I`m iruby");
        int[] array = SortTools.createArray(10,10);
        System.out.println(Arrays.toString(array));
        //直接插入排序
        System.out.println(Arrays.toString(InsertionSort.sort(array)));
        //希尔排序
        System.out.println(Arrays.toString(ShellSort.sort(array)));
        //冒泡排序
        System.out.println(Arrays.toString(BubbleSort.sort(array)));
        //快速排序
        System.out.println(Arrays.toString(QuickSort.sort(array)));
    }
}
