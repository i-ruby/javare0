package work.iruby.leetcode.medium;//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量0和1的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 哈希表 
// 👍 273 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution525 {
    static class Test {
        public static void main(String[] args) {
            Solution525 test = new Solution525();
            long start = System.currentTimeMillis();
            System.out.println(test.findMaxLength(new int[]{1, 1, 0, 1, 0, 0}));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length, maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            map.putIfAbsent(counter, i);
            maxLength = Math.max(maxLength, i - map.get(counter));
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
