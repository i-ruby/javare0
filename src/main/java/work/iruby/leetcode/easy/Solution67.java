package work.iruby.leetcode.easy;//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 602 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution67 {
    public String addBinary(String a, String b) {
        if ("0".equals(a) && "0".equals(b)) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int leng = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < leng; i++) {
            carry += i > a.length() - 1 ? 0 : a.charAt(a.length() - 1 - i) - '0';
            carry += i > b.length() - 1 ? 0 : b.charAt(b.length() - 1 - i) - '0';
            stringBuilder.append((char) (carry % 2 + '0'));
            carry /=2;
        }
        if (carry > 0) {
            stringBuilder.append(1);
        }
//        Integer.toBinaryString((Integer.getInteger(a, 2) + Integer.getInteger(b, 2)));
        return stringBuilder.reverse().toString();
    }


}
//leetcode submit region end(Prohibit modification and deletion)
