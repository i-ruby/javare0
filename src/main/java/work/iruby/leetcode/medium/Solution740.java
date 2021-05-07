package work.iruby.leetcode.medium;//给你一个整数数组 nums ，你可以对它进行一些操作。
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
// 1 的元素。
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
//
//
//
// 示例 1：
//
//
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
//
//
// 示例 2：
//
//
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i] <= 104
//
// Related Topics 动态规划
// 👍 263 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int maxVal = Arrays.stream(nums).boxed().max(Integer::compareTo).get();
        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        int first = sum[0], max = Math.max(sum[0], sum[1]);
        for (int i = 2; i < sum.length; i++) {
            int temp = max;
            max = Math.max(first + sum[i], max);
            first = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution740 solution740 = new Solution740();
        System.out.println(solution740.deleteAndEarn(new int[]{3, 4, 2}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
