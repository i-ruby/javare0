package work.iruby.leetcode;//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
// Related Topics 数组 
// 👍 681 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int i = 0;
        while (i <= digits.length - 1) {
            if (digits[digits.length - 1 - i] != 9) {
                digits[digits.length - 1 - i] = digits[digits.length - 1 - i] + 1;
                break;
            } else {
                digits[digits.length - 1 - i] = 0;
                i++;
                // 预防数组只包含9的情况
                if (i > digits.length-1) {
                    int[] ints = new int[digits.length+1];
                    ints[0] = 1;
                    return ints;
                }
            }
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
