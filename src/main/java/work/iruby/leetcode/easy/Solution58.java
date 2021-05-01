package work.iruby.leetcode.easy;//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 308 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution58 {
    public int lengthOfLastWord(String s) {
        String s1 = s.trim();
        if (s1.length() <= 2) {
            return s1.length();
        }

        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(s1.length() - 1 - i) == ' ') {
                return i;
            }
        }
        return s1.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
