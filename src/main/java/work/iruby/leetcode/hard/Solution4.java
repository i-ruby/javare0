package work.iruby.leetcode.hard;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4243 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    static class Test {
        public static void main(String[] args) {
            Solution4 test = new Solution4();
            long start = System.currentTimeMillis();
            System.out.println(test.findMedianSortedArrays(new int[]{1}, new int[]{3, 4, 5}));
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, l = n + m;
        int[] newArr = Arrays.copyOf(nums1, l);
        System.arraycopy(nums2, 0, newArr, n, m);
        Arrays.sort(newArr);
        return findMedian(newArr);
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length, l = n + m;
        if (l % 2 == 0) {
            return (findMedian(nums1, 0, nums2, 0, (l - 1) / 2) + findMedian(nums1, 0, nums2, 0, l / 2)) / 2.0;
        } else {
            return findMedian(nums1, 0, nums2, 0, l / 2);
        }
    }

    private double findMedian(int[] nums1, int i1, int[] nums2, int i2, int k) {
        if (k == 0) {
            return Math.min(nums1[i1], nums2[i2]);
        }else {

        }
        return 0;
    }

    private double findMedian(int[] nums) {
        return (nums[(nums.length - 1) / 2] + nums[nums.length / 2]) / 2.0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
