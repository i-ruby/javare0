package work.iruby.nowcoder.jz;

public class JZ1 {
    static class Test{
        public static void main(String[] args) {
            JZ1 jz1 = new JZ1();
            jz1.Find(7,new int[][]{{1,2,3,4},{1,3,5,7,9}});
        }
    }
    private boolean search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean Find(int target, int[][] array) {
        for (int[] ints : array) {
            if (search(ints,target)){
                return true;
            }
        }
        return false;
    }
}