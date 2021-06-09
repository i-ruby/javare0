package work.iruby.leetcode.medium;//有一堆石头，每块石头的重量都是正整数。
//
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下： 
//
// 
// 如果 x == y，那么两块石头都会被完全粉碎； 
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。 
// 
//
// 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。 
//
// 
//
// 示例： 
//
// 输入：[2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 160 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1049 {
    static class Test {
        public static void main(String[] args) {
            Solution1049 test = new Solution1049();
            long start = System.currentTimeMillis();
            System.out.println(test.lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        // 将石头分成两堆, 根据题意就是将两堆差值尽量下, 我们取其中较小重量的一堆总重量为neg, 可知neg的取值范围为 [0,SUM/2]
        int neg = sum / 2;

        int n = stones.length;
        boolean[][] res = new boolean[n + 1][neg + 1];
        res[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int weight = stones[i - 1];
            // res[i][j] 前i块石头, 能否凑出j重量的小堆, 如果j < 这块石头的重量, 必然false

            for (int j = 0; j <= neg; j++) {
                // 前i块石头有两种情况, 这块石头在大堆res[i - 1][j], 或者这块石头在小堆 res[i][j - weight]
                if (j >= weight) {
                    res[i][j] = res[i - 1][j] || res[i - 1][j - weight];
                } else {
                    res[i][j] = res[i - 1][j];
                }
            }
        }

        for (int i = neg; i >= 0; i--) {
            if (res[n][i]) {
                return sum - 2 * i;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
