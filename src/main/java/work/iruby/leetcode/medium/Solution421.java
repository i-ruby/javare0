package work.iruby.leetcode.medium;//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 0 <= nums[i] <= 231 - 1 
// 
// 
// 
// Related Topics 位运算 字典树 
// 👍 307 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int max = nums[0] ^ nums[1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int n = nums[i] ^ nums[j];
                if (n > max) {
                    max = n;
                }
            }
        }
        return max;
    }
    static class test{
        public static void main(String[] args) {
            Solution421 solution421 = new Solution421();
            System.out.println(solution421.findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
