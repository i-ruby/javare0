package work.iruby.leetcode.medium;//给你一个整数数组 nums 和一个整数 target 。
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 738 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution494 {
    static class Test {
        public static void main(String[] args) {
            Solution494 test = new Solution494();
            long start = System.currentTimeMillis();
            System.out.println(test.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int def = sum - target;
        if (def < 0 || def % 2 != 0) {
            return 0;
        }
        // 取负号的总值为 def/2 , 此时正总值为 target + def/2 , 差值为target
        int neg = def / 2;
        int n = nums.length;

        int[][] res = new int[2][neg + 1];
        res[0][0] = 1;
        // 当前对第i-1个数进行选择
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                res[i % 2][j] = res[(i + 1) % 2][j];
                int num = nums[i - 1];
                if (j >= num) {
                    res[i % 2][j] += res[(i + 1) % 2][j - num];
                }
            }
        }
        return res[n % 2][neg];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
