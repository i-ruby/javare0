package work.iruby.leetcode.hard;//集团里有 n 名员工，他们可以完成各种各样的工作创造利润。
//
// 第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与。如果成员参与了其中一项工作，就不能参与另一项工作。 
//
// 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n 。 
//
// 有多少种计划可以选择？因为答案很大，所以 返回结果模 10^9 + 7 的值。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 5, minProfit = 3, group = [2,2], profit = [2,3]
//输出：2
//解释：至少产生 3 的利润，该集团可以完成工作 0 和工作 1 ，或仅完成工作 1 。
//总的来说，有两种计划。 
//
// 示例 2： 
//
// 
//输入：n = 10, minProfit = 5, group = [2,3,5], profit = [6,7,8]
//输出：7
//解释：至少产生 5 的利润，只要完成其中一种工作就行，所以该集团可以完成任何工作。
//有 7 种可能的计划：(0)，(1)，(2)，(0,1)，(0,2)，(1,2)，以及 (0,1,2) 。 
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 0 <= minProfit <= 100 
// 1 <= group.length <= 100 
// 1 <= group[i] <= 100 
// profit.length == group.length 
// 0 <= profit[i] <= 100 
// 
// Related Topics 动态规划 
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution879 {
    static class Test {
        public static void main(String[] args) {
            Solution879 test = new Solution879();
            long start = System.currentTimeMillis();
            System.out.println(test.profitableSchemes(10, 5, new int[]{2, 3, 5}, new int[]{6, 7, 8}));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = profit.length, mod = (int) 1e9 + 7;
        // res[i][j][k]  前i个任务, 使用了j个人, 收益为k, 总收益为minProfit以上的人数
        int[][][] res = new int[m + 1][n + 1][minProfit + 1];

        res[0][0][0] = 1;
        for (int i = 1; i <= m; i++) {

            // 这件工作需要cost个人, 收益为pro
            int cost = group[i - 1], pro = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    res[i][j][k] = res[i - 1][j][k];
                    if (j >= cost) {
                        res[i][j][k] += res[i - 1][j - cost][Math.max(0, k - pro)];
                        res[i][j][k] %= mod;
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + res[m][i][minProfit]) % mod;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
