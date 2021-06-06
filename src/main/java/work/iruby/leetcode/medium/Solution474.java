package work.iruby.leetcode.medium;//给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
//
//
// 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
//
// 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
//
//
//
//
// 示例 1：
//
//
//输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
//输出：4
//解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
//其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于
//n 的值 3 。
//
//
// 示例 2：
//
//
//输入：strs = ["10", "0", "1"], m = 1, n = 1
//输出：2
//解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
//
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] 仅由 '0' 和 '1' 组成
// 1 <= m, n <= 100
//
// Related Topics 动态规划
// 👍 404 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution474 {
    public int findMaxForm(String[] str, int m, int n) {
        int length = str.length;
        int[][][] res = new int[length + 1][m + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zeroOne = getZeroOne(str[i - 1]);
            int zero = zeroOne[0], one = zeroOne[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    res[i][j][k] = res[i - 1][j][k];
                    if (j >= zero && k >= one) {
                        res[i][j][k] = Math.max(res[i][j][k], res[i - 1][j - zero][k - one] + 1);
                    }
                }
            }
        }
        return res[length][m][n];
    }

    private int[] getZeroOne(String str) {
        int[] zeroOne = new int[2];
        for (int i = 0; i < str.length(); i++) {
            zeroOne[str.charAt(i) - '0']++;
        }
        return zeroOne;
    }

    public int findMaxForm(String[] str, int n) {
        int length = str.length;
        int[][] res = new int[length + 1][n + 1];
        for (int i = 1; i <= length; i++) {
            int[] zeroOne = getZeroOne(str[i - 1]);
            int zero = zeroOne[0], one = zeroOne[1];
            for (int j = 0; j <= n; j++) {
                res[i][j] = res[i - 1][j];
                if (j >= one) {
                    res[i][j] = Math.max(res[i][j], res[i - 1][j - one] + 1);
                }
            }
        }
        return res[length][n];
    }

    static class Test {
        public static void main(String[] args) {
            Solution474 test = new Solution474();
            long start = System.currentTimeMillis();
            System.out.println(test.findMaxForm(new String[]{"10", "10", "101", "11", "0", "0"}, 4, 3));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
