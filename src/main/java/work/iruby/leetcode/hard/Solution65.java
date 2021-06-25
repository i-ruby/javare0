package work.iruby.leetcode.hard;//有效数字（按顺序）可以分成以下几个部分：
//
// 
// 一个 小数 或者 整数 
// （可选）一个 'e' 或 'E' ，后面跟着一个 整数 
// 
//
// 小数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 下述格式之一：
// 
// 至少一位数字，后面跟着一个点 '.' 
// 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 
// 一个点 '.' ，后面跟着至少一位数字 
// 
// 
// 
//
// 整数（按顺序）可以分成以下几个部分： 
//
// 
// （可选）一个符号字符（'+' 或 '-'） 
// 至少一位数字 
// 
//
// 部分有效数字列举如下： 
//
// 
// ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1",
// "53.5e93", "-123.456e789"] 
// 
//
// 部分无效数字列举如下： 
//
// 
// ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"] 
// 
//
// 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "e"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s = "."
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = ".1"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。 
// 
// Related Topics 数学 字符串 
// 👍 239 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution65 {

    static class Test {


        public static void main(String[] args) {
            Solution65 test = new Solution65();
            long start = System.currentTimeMillis();
            String[] strings = new String[]{"e6"};
            for (String s : strings) {
                if (!test.isNumber(s)) {
                    System.out.println(s + " is false");
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("执行用时: " + (end - start) + " ms");
        }
    }

    public boolean isNumber(String s) {

        Map<State, Map<CharType, State>> transfer = new HashMap<>();

        Map<CharType, State> initMap = new HashMap<>();
        initMap.put(CharType.SIGN, State.INT_SIGN);
        initMap.put(CharType.NUMBER, State.INT);
        initMap.put(CharType.DOT, State.DOT_WITHOUT_INT);
        transfer.put(State.INIT, initMap);

        Map<CharType, State> initSignMap = new HashMap<>();
        initSignMap.put(CharType.NUMBER, State.INT);
        initSignMap.put(CharType.DOT, State.DOT_WITHOUT_INT);
        transfer.put(State.INT_SIGN, initSignMap);

        Map<CharType, State> intMap = new HashMap<>();
        intMap.put(CharType.NUMBER, State.INT);
        intMap.put(CharType.EXE, State.EXE);
        intMap.put(CharType.DOT, State.DOT);
        transfer.put(State.INT, intMap);

        Map<CharType, State> dotMap = new HashMap<>();
        dotMap.put(CharType.NUMBER, State.DOT_AFTER_INT);
        dotMap.put(CharType.EXE, State.EXE);
        transfer.put(State.DOT, dotMap);

        Map<CharType, State> dotWithoutIntMap = new HashMap<>();
        dotWithoutIntMap.put(CharType.NUMBER, State.DOT_AFTER_INT);
        transfer.put(State.DOT_WITHOUT_INT, dotWithoutIntMap);

        Map<CharType, State> dotAfterIntMap = new HashMap<>();
        dotAfterIntMap.put(CharType.NUMBER, State.DOT_AFTER_INT);
        dotAfterIntMap.put(CharType.EXE, State.EXE);
        transfer.put(State.DOT_AFTER_INT, dotAfterIntMap);

        Map<CharType, State> exeMap = new HashMap<>();
        exeMap.put(CharType.SIGN, State.EXE_SIGN);
        exeMap.put(CharType.NUMBER, State.EXE_INT);
        transfer.put(State.EXE, exeMap);

        Map<CharType, State> exeSignMap = new HashMap<>();
        exeSignMap.put(CharType.NUMBER, State.EXE_INT);
        transfer.put(State.EXE_SIGN, exeSignMap);

        Map<CharType, State> exeIntMap = new HashMap<>();
        exeIntMap.put(CharType.NUMBER, State.EXE_INT);
        transfer.put(State.EXE_INT, exeIntMap);

        State state = State.INIT;
        for (int i = 0; i < s.length(); i++) {
            Map<CharType, State> map = transfer.get(state);
            CharType charType = CharType.of(s.charAt(i));
            if (map.containsKey(charType)) {
                state = map.get(charType);
            } else {
                return false;
            }
        }

        return State.valid(state);
    }

    private enum State {
        INIT, INT_SIGN, INT, DOT, DOT_WITHOUT_INT, DOT_AFTER_INT, EXE, EXE_SIGN, EXE_INT;

        public static boolean valid(State state) {
            return state == INT || state == DOT || state == DOT_AFTER_INT || state == EXE_INT;
        }
    }

    private enum CharType {
        SIGN, DOT, NUMBER, EXE, BLANK, OTHER;

        public static CharType of(char ch) {
            if (ch == '-' || ch == '+') {
                return SIGN;
            } else if (ch == '.') {
                return DOT;
            } else if (ch >= '0' && ch <= '9') {
                return NUMBER;
            } else if (ch == 'e' || ch == 'E') {
                return EXE;
            } else if (ch == ' ') {
                return BLANK;
            } else {
                return OTHER;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
