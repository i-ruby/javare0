package work.iruby.nowcoder.jz;

public class JZ6 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int target = array[array.length - 1];
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (array[l] < array[r]) {
                return array[l];
            }
            int mid = (l + r) / 2;
            System.out.println(l + "-" + r + "-" + mid);
            if (array[mid] > target) {
                l = mid + 1;
            } else if (array[mid] < target) {
                r = mid;
            } else if (array[mid] == target) {
                l = l + 1;
            }
        }
        return array[l];
    }

    static class Test {
        public static void main(String[] args) {
            JZ6 jz6 = new JZ6();
            System.out.println(jz6.minNumberInRotateArray(new int[]{3, 4, 5, 1, 2}));
            System.out.println(jz6.minNumberInRotateArray(new int[]{2, 2, 2, 2, 2, 2}));
        }
    }
}