package work.iruby.leetcode.easy;//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 666 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1 || x == 2 || x == 3) {
            return 1;
        }
        int l = 0, r = x, index = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long cache = (long) mid * mid;
            if (cache == x) {
                return mid;
            } else if (cache > x) {
                r = mid - 1;
            } else if (cache < x) {
                index = mid;
                l = mid + 1;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
