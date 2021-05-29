package work.iruby.leetcode.hard;//给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
//
// 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。 
//
//
// 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵
//也不同。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
//输出：4
//解释：四个只含 0 的 1x1 子矩阵。
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,-1],[-1,1]], target = 0
//输出：5
//解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[904]], target = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= matrix.length <= 100 
// 1 <= matrix[0].length <= 100 
// -1000 <= matrix[i] <= 1000 
// -10^8 <= target <= 10^8 
// 
// Related Topics 数组 动态规划 Sliding Window 
// 👍 120 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution1074 {
    static class Test {
        public static void main(String[] args) {
            Solution1074 test = new Solution1074();
            long start = System.currentTimeMillis();
            System.out.println(test.numSubMatrixSumTarget(new int[][]{{1, -1}, {-1, 1}}, 0));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int numSubMatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] += matrix[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }

        int ans = 0;
        // 从坐标 (k,l) 到(i,j)  的矩阵和
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        if (sum[i][j] + sum[k - 1][l - 1] - sum[k - 1][j] - sum[i][l - 1] == target) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
