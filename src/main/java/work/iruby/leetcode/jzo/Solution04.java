package work.iruby.leetcode.jzo;//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 327 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution04 {
    static class Test {
        public static void main(String[] args) {
            Solution04 test = new Solution04();
            long start = System.currentTimeMillis();
            System.out.println(test.findNumberIn2DArray(new int[][]{{1, 2, 3, 4}, {1, 3, 5, 7, 9}}, 9));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] array : matrix) {
            if (search(array, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
