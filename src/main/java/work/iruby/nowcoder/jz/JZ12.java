package work.iruby.nowcoder.jz;

import java.util.Arrays;

public class JZ12 {
    public int[] reOrderArray(int[] array) {
        int[] res = new int[array.length];
        int[] cache = new int[array.length];
        int n1 = 0, n2 = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                cache[n2] = j;
                n2++;
            } else {
                res[n1] = j;
                n1++;
            }
        }
        System.arraycopy(cache, 0, res, n1, n2);
        return res;
    }

    static class Test {
        public static void main(String[] args) {
            JZ12 test = new JZ12();
            long start = System.currentTimeMillis();
            System.out.println(Arrays.toString(test.reOrderArray(new int[]{1, 2, 3, 4})));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}